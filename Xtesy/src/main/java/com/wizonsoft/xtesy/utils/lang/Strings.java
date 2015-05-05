package com.wizonsoft.xtesy.utils.lang;

/**
 * @author Wasiq B
 * @since 14-Nov-2014 8:54:28 pm
 */
public final class Strings {
	public static final String	EMPTY	= "";

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 8:57:25 pm
	 * @param value
	 * @return
	 */
	public static boolean isNullOrEmpty (final String value) {
		return value == null || trim (value).isEmpty ();
	}

	/**
	 * @author Wasiq B
	 * @since 01-Mar-2015 1:57:50 pm
	 * @param value
	 * @return
	 */
	public static boolean isNumeric (final String value) {
		final char [] vals = value.toCharArray ();
		boolean valid = true;
		boolean isDot = false;
		for (int index = 0; index < vals.length && valid; index++) {
			final char c = vals [index];
			if (index == 0 && (c == '-' || c == '+')) continue;
			if (c >= '0' && c <= '9') continue;
			if (!isDot && c == '.') {
				isDot = true;
				continue;
			}
			valid = false;
		}
		return valid;
	}

	/**
	 * @author Wasiq B
	 * @since 19-Nov-2014 9:40:39 pm
	 * @param value
	 * @param position
	 * @return
	 */
	public static String left (final String value, final int position) {
		return value.substring (0, position);
	}

	/**
	 * @author Wasiq B
	 * @since 19-Nov-2014 9:44:19 pm
	 * @param value
	 * @param fromPosition
	 * @param toPosition
	 * @return
	 */
	public static String mid (final String value, final int fromPosition, final int toPosition) {
		return value.substring (fromPosition, toPosition);
	}

	/**
	 * @author Wasiq B
	 * @since 19-Nov-2014 9:42:22 pm
	 * @param value
	 * @param position
	 * @return
	 */
	public static String right (final String value, final int position) {
		return value.substring (position, value.length ());
	}

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:42:52 pm
	 * @param value
	 * @return
	 */
	public static String trim (final String value) {
		return value.trim ();
	}
}