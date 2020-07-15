package site.part.ms.util;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

public class OrginDealSqlReturn {
	
	public void getMetaData(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd=rs.getMetaData();
		int columnCount=rsmd.getColumnCount();
		for(int i=0;i<columnCount;i++) {
			String columnName=rsmd.getColumnName(i+1).toLowerCase();//字段名
			int fieldType=rsmd.getColumnType(i+1);
			Object obj=getObject(rs, i, fieldType);//字段值
		}
	}
	public Object getObject(ResultSet rs,int index,int sqlType) throws SQLException {
		Object value;
		long longVal;
		int intVal;
		boolean boolVal;
		double doubleVal;
		float floatVal;
		short shortVal;
		byte byteVal = 0;
		switch(sqlType) {
		case Types.CHAR:
		case Types.VARCHAR:
		case Types.LONGVARCHAR:
			return rs.getString(index);
		case Types.DECIMAL:
		case Types.NUMERIC:
			return rs.getBigDecimal(index);
		case Types.INTEGER:
			intVal=rs.getInt(index);
			return (rs.wasNull()?null:new Integer(intVal));
		case Types.TIME:
			return rs.getTime(index);
		case Types.DATE:
			return rs.getDate(index);
		case Types.TIMESTAMP:
			return rs.getTimestamp(index);
		case Types.FLOAT:
		case Types.DOUBLE:
			doubleVal=rs.getDouble(index);
			return (rs.wasNull()?null:new Double(doubleVal));
		case Types.REAL:
			floatVal=rs.getFloat(index);
			return (rs.wasNull()?null:new Float(floatVal));
		case Types.SMALLINT:
			shortVal=rs.getShort(index);
			return (rs.wasNull()?null:new Short(shortVal));
		case Types.TINYINT:
			byteVal=rs.getByte(index);
			return (rs.wasNull()?null:new Byte(byteVal));
		case Types.LONGVARBINARY:
		case Types.VARBINARY:
		case Types.BINARY:
			return rs.getByte(index);
		case Types.BLOB:
			Blob blob=rs.getBlob(index);
			return (rs.wasNull()?null:blob.getBinaryStream());
		case Types.CLOB:
			return rs.getClob(index);
		case Types.BIGINT:
			longVal=rs.getLong(index);
			return (rs.wasNull()?null:new Long(longVal));
		case Types.BIT:
			boolVal=rs.getBoolean(index);
			return (rs.wasNull()?null:new Boolean(boolVal));
		default:
			value=rs.getObject(index);
			return (rs.wasNull()?null:value);
		}
	}
}
