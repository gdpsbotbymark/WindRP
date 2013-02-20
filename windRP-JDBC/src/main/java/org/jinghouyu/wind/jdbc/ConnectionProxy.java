package org.jinghouyu.wind.jdbc;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jinghouyu.windRP.Partition;
import org.jinghouyu.windRP.Resource;
import org.jinghouyu.windRP.ResourceEntry;
import org.jinghouyu.windRP.exception.ResourceException;

public class ConnectionProxy implements Connection, Resource {

	private Connection conn;

	private ResourceEntry<Connection> resourceEntry;

	private Partition<Connection> partition = null;

	// if these sql error states appears, that is, the remote server has crashed
	// down probably, but not completely sure.
	private static final Set<String> dbCrashSqlState = new HashSet<String>(
			Arrays.asList(new String[] { "08001", "08007", "08S01", "57P01",
					"HY000" }));

	public ConnectionProxy(Connection conn, Partition<Connection> partition) {
		this.conn = conn;
		this.partition = partition;
		resourceEntry = new ResourceEntry<Connection>(partition, this);
	}

	/**
	 * the author refered to BoneCP to implement this method.
	 * 
	 * @param e
	 */
	public void processSqlException(SQLException e) {
		String state = e.getSQLState();
		if (state == null) { // safety;
			state = "08999";
		}

		if (dbCrashSqlState.contains(state)) {
			// log error "Database access problem. Killing off all remaining
			// connections in the connection pool.
			partition.getPool().releaseAndRemoveAll();
		}

		// SQL-92 says:
		// Class values that begin with one of the <digit>s '5', '6', '7',
		// '8', or '9' or one of the <simple Latin upper case letter>s 'I',
		// 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
		// 'W', 'X', 'Y', or 'Z' are reserved for implementation-specified
		// conditions.

		// FIXME: We should look into
		// this.connection.getMetaData().getSQLStateType();
		// to determine if we have SQL:92 or X/OPEN sqlstatus codes.

		// char firstChar = state.charAt(0);
		// if it's a communication exception, a mysql deadlock or an
		// implementation-specific error code, flag this connection as being
		// potentially broken.
		// state == 40001 is mysql specific triggered when a deadlock is
		// detected
		char firstChar = state.charAt(0);

		// this connection is possibly disconnected, so we should remove it from
		// the pool
		if (state.equals("40001") || state.startsWith("08")
				|| (firstChar >= '5' && firstChar <= '9')) {
			resourceEntry.destroy();
		}
	}

	public ResourceEntry<Connection> getResourceEntry() {
		return this.resourceEntry;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		try {
			return conn.unwrap(iface);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		try {
			return conn.isWrapperFor(iface);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}
	
	private LinkedList<Statement> statements = new LinkedList<Statement>();
	
	private synchronized void addStatement(Statement statement) {
		statements.add(statement);
	}

	public Statement createStatement() throws SQLException {
		try {
			Statement st = new StatementProxy(this, conn.createStatement());
			addStatement(st);
			return st;
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		try {
			PreparedStatement pst = new PreparedStatementProxy(this, conn.prepareStatement(sql));
			addStatement(pst);
			return pst;
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public CallableStatement prepareCall(String sql) throws SQLException {
		try {
			CallableStatement cst = new CallableStatementProxy(this, conn.prepareCall(sql));
			addStatement(cst);
			return cst;
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public String nativeSQL(String sql) throws SQLException {
		try {
			return conn.nativeSQL(sql);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public void setAutoCommit(boolean autoCommit) throws SQLException {
		try {
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public boolean getAutoCommit() throws SQLException {
		try {
			return conn.getAutoCommit();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public void commit() throws SQLException {
		try {
			conn.commit();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public void rollback() throws SQLException {
		try {
			conn.rollback();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	/**
	 * according to the official documentations
	 * when close method called, it will close all Statement created by this connection instance.
	 */
	public void close() throws SQLException {
		Statement st = null;
		while((st = statements.poll()) != null) {
			st.close();
		}
		setAutoCommit(true);   //the default value
		//reset readonly
		//reset catalog
		//reset transaction isolation level
		resourceEntry.release();
	}
	
	public boolean isClosed() throws SQLException {
		try {
			return conn.isClosed();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public DatabaseMetaData getMetaData() throws SQLException {
		try {
			return conn.getMetaData();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public void setReadOnly(boolean readOnly) throws SQLException {
		try {
			conn.setReadOnly(readOnly);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public boolean isReadOnly() throws SQLException {
		try {
			return conn.isReadOnly();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public void setCatalog(String catalog) throws SQLException {
		try {
			conn.setCatalog(catalog);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public String getCatalog() throws SQLException {
		try {
			return conn.getCatalog();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public void setTransactionIsolation(int level) throws SQLException {
		try {
			conn.setTransactionIsolation(level);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public int getTransactionIsolation() throws SQLException {
		try {
			return conn.getTransactionIsolation();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public SQLWarning getWarnings() throws SQLException {
		try {
			return conn.getWarnings();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public void clearWarnings() throws SQLException {
		try {
			conn.clearWarnings();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency)
			throws SQLException {
		try {
			Statement st = new StatementProxy(this, conn.createStatement(resultSetType, resultSetConcurrency));
			addStatement(st);
			return st;
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		try {
			PreparedStatement pst = new PreparedStatementProxy(this, conn.prepareStatement(sql, resultSetType, resultSetConcurrency));
			addStatement(pst);
			return pst;
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		try {
			CallableStatement cst = new CallableStatementProxy(this, conn.prepareCall(sql, resultSetType, resultSetConcurrency));
			addStatement(cst);
			return cst;
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public Map<String, Class<?>> getTypeMap() throws SQLException {
		try {
			return conn.getTypeMap();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		try {
			conn.setTypeMap(map);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public void setHoldability(int holdability) throws SQLException {
		try {
			conn.setHoldability(holdability);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public int getHoldability() throws SQLException {
		try {
			return conn.getHoldability();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public Savepoint setSavepoint() throws SQLException {
		try {
			return conn.setSavepoint();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public Savepoint setSavepoint(String name) throws SQLException {
		try {
			return conn.setSavepoint(name);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public void rollback(Savepoint savepoint) throws SQLException {
		try {
			conn.rollback(savepoint);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		try {
			conn.releaseSavepoint(savepoint);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public Statement createStatement(int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		try {
			Statement st = new StatementProxy(this, conn.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability));
			addStatement(st);
			return st;
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		try {
			PreparedStatement pst = new PreparedStatementProxy(this, conn.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability));
			addStatement(pst);
			return pst;
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		try {
			CallableStatement cst = new CallableStatementProxy(this, conn.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability));
			addStatement(cst);
			return cst;
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
			throws SQLException {
		try {
			PreparedStatement pst = new PreparedStatementProxy(this, conn.prepareStatement(sql, autoGeneratedKeys));
			addStatement(pst);
			return pst;
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public PreparedStatement prepareStatement(String sql, int[] columnIndexes)
			throws SQLException {
		try {
			PreparedStatement pst = new PreparedStatementProxy(this, conn.prepareStatement(sql, columnIndexes));
			addStatement(pst);
			return pst;
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public PreparedStatement prepareStatement(String sql, String[] columnNames)
			throws SQLException {
		try {
			PreparedStatement pst = new PreparedStatementProxy(this, conn.prepareStatement(sql, columnNames));
			addStatement(pst);
			return pst;
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public Clob createClob() throws SQLException {
		try {
			return conn.createClob();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public Blob createBlob() throws SQLException {
		try {
			return conn.createBlob();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public NClob createNClob() throws SQLException {
		try {
			return conn.createNClob();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public SQLXML createSQLXML() throws SQLException {
		try {
			return conn.createSQLXML();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public boolean isValid(int timeout) throws SQLException {
		try {
			return conn.isValid(timeout);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public void setClientInfo(String name, String value)
			throws SQLClientInfoException {
		conn.setClientInfo(name, value);
	}

	public void setClientInfo(Properties properties)
			throws SQLClientInfoException {
		conn.setClientInfo(properties);
	}

	public String getClientInfo(String name) throws SQLException {
		try {
			return conn.getClientInfo(name);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public Properties getClientInfo() throws SQLException {
		try {
			return conn.getClientInfo();
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public Array createArrayOf(String typeName, Object[] elements)
			throws SQLException {
		try {
			return conn.createArrayOf(typeName, elements);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public Struct createStruct(String typeName, Object[] attributes)
			throws SQLException {
		try {
			return conn.createStruct(typeName, attributes);
		} catch (SQLException e) {
			processSqlException(e);
			throw e;
		}
	}

	public void releaseRealResource() throws ResourceException {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new ResourceException(e);
		}
	}

	public boolean testResource() throws ResourceException {
		return true;
	}
}
