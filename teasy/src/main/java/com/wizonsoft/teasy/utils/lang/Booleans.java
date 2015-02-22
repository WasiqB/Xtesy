package com.wizonsoft.teasy.utils.lang;

/**
 * @author Wasiq B
 * @since 21-Nov-2014 9:51:11 pm
 */
public class Booleans {
	/**
	 * @author Wasiq B
	 * @since 21-Nov-2014 9:53:19 pm
	 * @param value
	 * @return
	 */
	public static boolean parseBoolean (final String value) {
		return value.equalsIgnoreCase ("y") || value.equalsIgnoreCase ("yes")
				|| Boolean.parseBoolean (value);
	}

	/**
	 * @author Wasiq B
	 * @since 21-Nov-2014 9:52:07 pm
	 * @param value
	 * @return
	 */
	public static String toStringFromBoolean (final boolean value) {
		return Boolean.toString (value);
	}
}