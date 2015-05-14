package com.wizonsoft.xtesy.data;

/**
 * @author Wasiq B
 * @since 17-Jan-2015 7:39:50 pm
 */
public interface IDataColumn {
	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 7:46:56 pm
	 * @return
	 */
	<T> T getValue ();

	/**
	 * @author Wasiq B
	 * @since 17-Jan-2015 7:52:29 pm
	 * @return
	 */
	IDataVariable getVariable ();
}