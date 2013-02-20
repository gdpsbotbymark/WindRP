package org.jinghouyu.wind.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

public class PreparedStatementProxy extends StatementProxy implements
		PreparedStatement {

	private PreparedStatement preparedStatement = null;

	public PreparedStatementProxy(ConnectionProxy conn,
			Statement preparedStatement) {
		super(conn, preparedStatement);
		this.preparedStatement = (PreparedStatement) preparedStatement;
	}

	public ResultSet executeQuery() throws SQLException {
		try {
			return preparedStatement.executeQuery();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public int executeUpdate() throws SQLException {
		try {
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		try {
			preparedStatement.setNull(parameterIndex, sqlType);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		try {
			preparedStatement.setBoolean(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setByte(int parameterIndex, byte x) throws SQLException {
		try {
			preparedStatement.setByte(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setShort(int parameterIndex, short x) throws SQLException {
		try {
			preparedStatement.setShort(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setInt(int parameterIndex, int x) throws SQLException {
		try {
			preparedStatement.setInt(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setLong(int parameterIndex, long x) throws SQLException {
		try {
			preparedStatement.setLong(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setFloat(int parameterIndex, float x) throws SQLException {
		try {
			preparedStatement.setFloat(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setDouble(int parameterIndex, double x) throws SQLException {
		try {
			preparedStatement.setDouble(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setBigDecimal(int parameterIndex, BigDecimal x)
			throws SQLException {
		try {
			preparedStatement.setBigDecimal(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setString(int parameterIndex, String x) throws SQLException {
		try {
			preparedStatement.setString(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		try {
			preparedStatement.setBytes(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}

	}

	public void setDate(int parameterIndex, Date x) throws SQLException {
		try {
			preparedStatement.setDate(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}

	}

	public void setTime(int parameterIndex, Time x) throws SQLException {
		try {
			preparedStatement.setTime(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setTimestamp(int parameterIndex, Timestamp x)
			throws SQLException {
		try {
			preparedStatement.setTimestamp(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}

	}

	public void setAsciiStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		try {
			preparedStatement.setAsciiStream(parameterIndex, x, length);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}

	}

	@SuppressWarnings("deprecation")
	public void setUnicodeStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		try {
			preparedStatement.setUnicodeStream(parameterIndex, x, length);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setBinaryStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		try {
			preparedStatement.setBinaryStream(parameterIndex, x, length);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void clearParameters() throws SQLException {
		try {
			preparedStatement.clearParameters();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setObject(int parameterIndex, Object x, int targetSqlType)
			throws SQLException {
		try {
			preparedStatement.setObject(parameterIndex, x, targetSqlType);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setObject(int parameterIndex, Object x) throws SQLException {
		try {
			preparedStatement.setObject(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public boolean execute() throws SQLException {
		try {
			return preparedStatement.execute();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void addBatch() throws SQLException {
		try {
			preparedStatement.addBatch();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setCharacterStream(int parameterIndex, Reader reader, int length)
			throws SQLException {
		try {
			preparedStatement
					.setCharacterStream(parameterIndex, reader, length);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setRef(int parameterIndex, Ref x) throws SQLException {
		try {
			preparedStatement.setRef(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setBlob(int parameterIndex, Blob x) throws SQLException {
		try {
			preparedStatement.setBlob(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setClob(int parameterIndex, Clob x) throws SQLException {
		try {
			preparedStatement.setClob(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setArray(int parameterIndex, Array x) throws SQLException {
		try {
			preparedStatement.setArray(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public ResultSetMetaData getMetaData() throws SQLException {
		try {
			return preparedStatement.getMetaData();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setDate(int parameterIndex, Date x, Calendar cal)
			throws SQLException {
		try {
			preparedStatement.setDate(parameterIndex, x, cal);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setTime(int parameterIndex, Time x, Calendar cal)
			throws SQLException {
		try {
			preparedStatement.setTime(parameterIndex, x, cal);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal)
			throws SQLException {
		try {
			preparedStatement.setTimestamp(parameterIndex, x, cal);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setNull(int parameterIndex, int sqlType, String typeName)
			throws SQLException {
		try {
			preparedStatement.setNull(parameterIndex, sqlType, typeName);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setURL(int parameterIndex, URL x) throws SQLException {
		try {
			preparedStatement.setURL(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public ParameterMetaData getParameterMetaData() throws SQLException {
		try {
			return preparedStatement.getParameterMetaData();
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setRowId(int parameterIndex, RowId x) throws SQLException {
		try {
			preparedStatement.setRowId(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setNString(int parameterIndex, String value)
			throws SQLException {
		try {
			preparedStatement.setNString(parameterIndex, value);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setNCharacterStream(int parameterIndex, Reader value,
			long length) throws SQLException {
		try {
			preparedStatement.setNCharacterStream(parameterIndex, value);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		try {
			preparedStatement.setNClob(parameterIndex, value);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setClob(int parameterIndex, Reader reader, long length)
			throws SQLException {
		try {
			preparedStatement.setClob(parameterIndex, reader, length);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setBlob(int parameterIndex, InputStream inputStream, long length)
			throws SQLException {
		try {
			preparedStatement.setBlob(parameterIndex, inputStream, length);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setNClob(int parameterIndex, Reader reader, long length)
			throws SQLException {
		try {
			preparedStatement.setNClob(parameterIndex, reader, length);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setSQLXML(int parameterIndex, SQLXML xmlObject)
			throws SQLException {
		try {
			preparedStatement.setSQLXML(parameterIndex, xmlObject);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setObject(int parameterIndex, Object x, int targetSqlType,
			int scaleOrLength) throws SQLException {
		try {
			preparedStatement.setObject(parameterIndex, x, targetSqlType,
					scaleOrLength);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setAsciiStream(int parameterIndex, InputStream x, long length)
			throws SQLException {
		try {
			preparedStatement.setAsciiStream(parameterIndex, x, length);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setBinaryStream(int parameterIndex, InputStream x, long length)
			throws SQLException {
		try {
			preparedStatement.setBinaryStream(parameterIndex, x, length);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setCharacterStream(int parameterIndex, Reader reader,
			long length) throws SQLException {
		try {
			preparedStatement
					.setCharacterStream(parameterIndex, reader, length);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setAsciiStream(int parameterIndex, InputStream x)
			throws SQLException {
		try {
			preparedStatement.setAsciiStream(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setBinaryStream(int parameterIndex, InputStream x)
			throws SQLException {
		try {
			preparedStatement.setBinaryStream(parameterIndex, x);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setCharacterStream(int parameterIndex, Reader reader)
			throws SQLException {
		try {
			preparedStatement.setCharacterStream(parameterIndex, reader);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setNCharacterStream(int parameterIndex, Reader value)
			throws SQLException {
		try {
			preparedStatement.setNCharacterStream(parameterIndex, value);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		try {
			preparedStatement.setClob(parameterIndex, reader);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setBlob(int parameterIndex, InputStream inputStream)
			throws SQLException {
		try {
			preparedStatement.setBlob(parameterIndex, inputStream);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		try {
			preparedStatement.setNClob(parameterIndex, reader);
		} catch (SQLException e) {
			connection.processSqlException(e);
			throw e;
		}
	}

}
