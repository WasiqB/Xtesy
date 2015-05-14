package com.wizonsoft.xtesy.core.data;

/**
 * @author Wasiq B
 * @since 17-Jan-2015 8:00:56 pm
 */
public interface IDataTable extends IDataTableMetaData {
	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 8:02:43 pm
	 * @param rowNumber
	 * @return
	 */
	IDataRow getRow (int rowNumber);

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 8:04:15 pm
	 * @return
	 */
	int getRowCount ();

	/**
	 * @author Wasiq B
	 * @since 24-Jan-2015 7:57:28 pm
	 * @return
	 */
	IDataRowIterator getRowIterator ();
}