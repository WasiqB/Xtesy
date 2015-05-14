package com.wizonsoft.xtesy.data;

import java.sql.SQLException;

/**
 * @author Wasiq B
 * @since 17-Jan-2015 8:07:01 pm
 */
public interface IDataTableMetaData {
	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 8:09:09 pm
	 * @return
	 * @throws SQLException
	 */
	String getTableName () throws SQLException;
}