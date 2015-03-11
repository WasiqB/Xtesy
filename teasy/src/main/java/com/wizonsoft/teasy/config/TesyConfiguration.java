package com.wizonsoft.teasy.config;

import static com.wizonsoft.teasy.constants.PropertyConstants.PROPERTIES_FILE;

import java.io.*;
import java.util.Properties;

/**
 * @author Wasiq B
 * @since 08-Mar-2015 9:38:10 pm
 */
public class TesyConfiguration {
	private static Properties	prop;

	/**
	 * @author Wasiq B
	 * @since 08-Mar-2015 9:38:14 pm
	 */
	private TesyConfiguration () {
		prop = new Properties ();
	}

	/**
	 * @author Wasiq B
	 * @since 08-Mar-2015 9:46:18 pm
	 * @param property
	 * @return
	 */
	public static String getProperty (final String property) {
		return prop.getProperty (property);
	}

	/**
	 * @author Wasiq B
	 * @since 08-Mar-2015 9:44:58 pm
	 * @param property
	 * @param defaultValue
	 */
	public static String getProperty (final String property, final String defaultValue) {
		return prop.getProperty (property, defaultValue);
	}

	/**
	 * @author Wasiq B
	 * @since 08-Mar-2015 9:48:53 pm
	 */
	public static void load () {
		try (FileInputStream file = new FileInputStream (System.getProperty (PROPERTIES_FILE))) {
			prop.loadFromXML (file);
		}
		catch (final IOException e) {
			// TODO Exception handling.
		}
	}
}