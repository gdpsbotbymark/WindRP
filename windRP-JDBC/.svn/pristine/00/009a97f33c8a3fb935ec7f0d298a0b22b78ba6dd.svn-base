package com.jinghouyu.wind.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

public class StatementProxy implements Statement {

	private Statement statement = null;

	protected ConnectionProxy connection = null;

	public StatementProxy(ConnectionProxy conn, Statement statement) {
		this.statement = statement;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		try {
			return statement.unwrap(iface);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		try {
			return statement.isWrapperFor(iface);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		try {
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public int executeUpdate(String sql) throws SQLException {
		try {
			return statement.executeUpdate(sql);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void close() throws SQLException {
		statement.close();
	}

	public int getMaxFieldSize() throws SQLException {
		try {
			return statement.getMaxFieldSize();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setMaxFieldSize(int max) throws SQLException {
		try {
			statement.setMaxFieldSize(max);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public int getMaxRows() throws SQLException {
		try {
			return statement.getMaxRows();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setMaxRows(int max) throws SQLException {
		try {
			statement.setMaxRows(max);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setEscapeProcessing(boolean enable) throws SQLException {
		try {
			statement.setEscapeProcessing(enable);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public int getQueryTimeout() throws SQLException {
		try {
			return statement.getQueryTimeout();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setQueryTimeout(int seconds) throws SQLException {
		try {
			statement.setQueryTimeout(seconds);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void cancel() throws SQLException {
		try {
			statement.cancel();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public SQLWarning getWarnings() throws SQLException {
		try {
			return statement.getWarnings();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void clearWarnings() throws SQLException {
		try {
			statement.clearWarnings();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setCursorName(String name) throws SQLException {
		try {
			statement.setCursorName(name);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public boolean execute(String sql) throws SQLException {
		try {
			return statement.execute(sql);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public ResultSet getResultSet() throws SQLException {
		try {
			return statement.getResultSet();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public int getUpdateCount() throws SQLException {
		try {
			return statement.getUpdateCount();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public boolean getMoreResults() throws SQLException {
		try {
			return statement.getMoreResults();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setFetchDirection(int direction) throws SQLException {
		try {
			statement.setFetchDirection(direction);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public int getFetchDirection() throws SQLException {
		try {
			return statement.getFetchDirection();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setFetchSize(int rows) throws SQLException {
		try {
			statement.setFetchSize(rows);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}

	}

	public int getFetchSize() throws SQLException {
		try {
			return statement.getFetchSize();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public int getResultSetConcurrency() throws SQLException {
		try {
			return statement.getResultSetConcurrency();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public int getResultSetType() throws SQLException {
		try {
			return statement.getResultSetType();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void addBatch(String sql) throws SQLException {
		try {
			statement.addBatch(sql);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}

	}

	public void clearBatch() throws SQLException {
		try {
			statement.clearBatch();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}

	}

	public int[] executeBatch() throws SQLException {
		try {
			return statement.executeBatch();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public Connection getConnection() throws SQLException {
		return this.connection;
	}

	public boolean getMoreResults(int current) throws SQLException {
		try {
			return statement.getMoreResults(current);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public ResultSet getGeneratedKeys() throws SQLException {
		try {
			return statement.getGeneratedKeys();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public int executeUpdate(String sql, int autoGeneratedKeys)
			throws SQLException {
		try {
			return statement.executeUpdate(sql, autoGeneratedKeys);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public int executeUpdate(String sql, int[] columnIndexes)
			throws SQLException {
		try {
			return statement.executeUpdate(sql, columnIndexes);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public int executeUpdate(String sql, String[] columnNames)
			throws SQLException {
		try {
			return statement.executeUpdate(sql, columnNames);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public boolean execute(String sql, int autoGeneratedKeys)
			throws SQLException {
		try {
			return statement.execute(sql, autoGeneratedKeys);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		try {
			return statement.execute(sql, columnIndexes);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public boolean execute(String sql, String[] columnNames)
			throws SQLException {
		try {
			return statement.execute(sql, columnNames);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public int getResultSetHoldability() throws SQLException {
		try {
			return statement.getResultSetHoldability();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public boolean isClosed() throws SQLException {
		try {
			return statement.isClosed();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setPoolable(boolean poolable) throws SQLException {
		try {
			statement.setPoolable(poolable);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}

	}

	public boolean isPoolable() throws SQLException {
		try {
			return statement.isPoolable();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

}
