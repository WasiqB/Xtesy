package com.wizonsoft.teasy.data;

/**
 * @author Wasiq B
 * @since 17-Jan-2015 8:54:25 pm
 */
public interface IDataTableIterator {
	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 9:13:22 pm
	 * @return
	 */
	IDataTable current ();

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 8:55:09 pm
	 * @return
	 */
	boolean hasNext ();

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 8:54:58 pm
	 * @return
	 */
	void next ();

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 9:11:17 pm
	 */
	void reset ();
}