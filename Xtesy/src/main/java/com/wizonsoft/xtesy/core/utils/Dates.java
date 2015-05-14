package com.wizonsoft.xtesy.core.utils;

import static java.util.Calendar.getInstance;

import java.text.*;
import java.util.*;

/**
 * @author Wasiq B
 * @since 14-Nov-2014 8:59:51 pm
 */
public final class Dates {
	private static final String	DEFAULT_FORMAT	= "dd/MM/yyyy";

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:36:35 pm
	 * @param date
	 * @param units
	 * @param amount
	 * @return
	 */
	private static Date add (final Date date, final int units, final int amount) {
		final Calendar c = getCalender ();
		c.setTime (date);
		c.add (units, amount);
		return c.getTime ();
	}

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:22:19 pm
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addDay (final Date date, final int amount) {
		return add (date, Calendar.DAY_OF_MONTH, amount);
	}

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:24:56 pm
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addMonth (final Date date, final int amount) {
		return add (date, Calendar.MONTH, amount);
	}

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:25:30 pm
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addYear (final Date date, final int amount) {
		return add (date, Calendar.YEAR, amount);
	}

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:17:26 pm
	 * @return
	 */
	public static Calendar getCalender () {
		return getInstance ();
	}

	/**
	 * @author Wasiq B
	 * @since 13-Feb-2015 11:34:42 am
	 * @return
	 */
	public static Date now () {
		return getCalender ().getTime ();
	}

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:15:26 pm
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parse (final String date) throws ParseException {
		return parse (date, DEFAULT_FORMAT);
	}

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:11:33 pm
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date parse (final String date, final String format)
			throws ParseException {
		final SimpleDateFormat sf = new SimpleDateFormat (format);
		return sf.parse (date);
	}

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:00:48 pm
	 * @param date
	 * @return
	 */
	public static String toString (final Date date) {
		return toString (date, DEFAULT_FORMAT);
	}

	/**
	 * @author Wasiq B
	 * @since 14-Nov-2014 9:10:12 pm
	 * @param date
	 * @param format
	 * @return
	 */
	public static String toString (final Date date, final String format) {
		final SimpleDateFormat sf = new SimpleDateFormat (format);
		return sf.format (date);
	}
}