package com.wizonsoft.xtesy.core.io;

import com.wizonsoft.xtesy.core.data.IDataTable;

/**
 * @author Wasiq B
 * @since 11-May-2015 4:53:00 pm
 */
public interface IFileParser {
	/**
	 * @author Wasiq B
	 * @since 11-May-2015 4:53:22 pm
	 * @param path
	 */
	IDataTable parse (String path);

	/**
	 * @author Wasiq B
	 * @since 12-May-2015 3:00:41 pm
	 * @param table
	 * @param path
	 */
	void save (IDataTable data, String path);
}