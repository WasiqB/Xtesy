package com.wizonsoft.xtesy.core.interfaces;

/**
 * @author Wasiq B
 * @since 08-May-2015 9:59:12 pm
 */
public interface IConfiguration {
	/**
	 * @author Wasiq B
	 * @since 08-May-2015 10:02:14 pm
	 * @param key
	 * @return
	 */
	String getValue (IKey key);

	/**
	 * @author Wasiq B
	 * @since 08-May-2015 10:02:46 pm
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	String getValue (IKey key, String defaultValue);
}