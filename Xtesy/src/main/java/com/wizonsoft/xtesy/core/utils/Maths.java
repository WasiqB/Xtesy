package com.wizonsoft.xtesy.core.utils;

import java.math.*;

/**
 * @author Wasiq B
 * @since 14-Nov-2014 9:28:07 pm
 */
public final class Maths {
	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:34:47 pm
	 * @param value
	 * @return
	 */
	public static BigDecimal toBigDecimal (final String value) {
		return new BigDecimal (value);
	}

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:33:46 pm
	 * @param value
	 * @return
	 */
	public static BigInteger toBigInteger (final String value) {
		return new BigInteger (value);
	}

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:29:42 pm
	 * @param value
	 * @return
	 */
	public static double toDouble (final String value) {
		return Double.parseDouble (value);
	}

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:28:38 pm
	 * @param value
	 * @return
	 */
	public static int toInt (final String value) {
		return Integer.parseInt (value);
	}

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:30:27 pm
	 * @param value
	 * @return
	 */
	public static long toLong (final String value) {
		return Long.parseLong (value);
	}

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:31:07 pm
	 * @param value
	 * @return
	 */
	public static short toShort (final String value) {
		return Short.parseShort (value);
	}

	/**
	 * @author Wasiq B
	 * @since 20-Nov-2014 10:20:33 pm
	 * @param value
	 * @return
	 */
	public static String toStringFromBigDecimal (final BigDecimal value) {
		return value.toString ();
	}

	/**
	 * @author Wasiq B
	 * @since 20-Nov-2014 10:19:30 pm
	 * @param value
	 * @return
	 */
	public static String toStringFromBigInteger (final BigInteger value) {
		return value.toString ();
	}

	/**
	 * @author Wasiq B
	 * @since 20-Nov-2014 10:17:56 pm
	 * @param value
	 * @return
	 */
	public static String toStringFromDouble (final double value) {
		return Double.toString (value);
	}

	/**
	 * @author Wasiq B
	 * @since 20-Nov-2014 10:16:10 pm
	 * @param value
	 * @return
	 */
	public static String toStringFromInt (final int value) {
		return Integer.toString (value);
	}

	/**
	 * @author Wasiq B
	 * @since 20-Nov-2014 10:16:53 pm
	 * @param value
	 * @return
	 */
	public static String toStringFromLong (final long value) {
		return Long.toString (value);
	}

	/**
	 * @author Wasiq B
	 * @since 20-Nov-2014 10:18:31 pm
	 * @param value
	 * @return
	 */
	public static String toStringFromShort (final short value) {
		return Short.toString (value);
	}
}