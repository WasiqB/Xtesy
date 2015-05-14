package com.wizonsoft.xtesy.core.config;

import static com.wizonsoft.xtesy.constants.PropertyConstants.PROPERTIES_FILE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wizonsoft.xtesy.constants.PropertyConstants;
import com.wizonsoft.xtesy.core.utils.Strings;

/**
 * @author Wasiq B
 * @since 08-Mar-2015 9:38:10 pm
 */
@Deprecated
public class TeasyConfiguration {
	private static Logger		log;
	private static Properties	prop;

	/**
	 * @author Wasiq B
	 * @since 08-Mar-2015 9:38:14 pm
	 */
	static {
		log.entry ();
		prop = new Properties ();
		log = LogManager.getLogger (TeasyConfiguration.class);
		load ();
		log.exit ();
	}

	/**
	 * @author Wasiq B
	 * @since 01-Apr-2015 8:19:33 pm
	 * @param config
	 */
	private static void createConfig (final File config) {
		log.entry ();
		try (FileOutputStream out = new FileOutputStream (config)) {
			for (final PropertyConstants property : PropertyConstants.values ()) {
				prop.setProperty (property.getPropertyKey (), Strings.EMPTY);
			}
			prop.storeToXML (out, null);
			log.info ("Default Property saved.");
		}
		catch (final IOException e) {
			log.error (e.getStackTrace ());
		}
		log.exit ();
	}

	/**
	 * @author Wasiq B
	 * @since 08-Mar-2015 9:48:53 pm
	 */
	private static void load () {
		log.entry ();
		final String path = System.getProperty (PROPERTIES_FILE.getPropertyKey ());
		final File config = new File (path);
		if (config.exists ()) {
			log.info ("Loading properties " + path);
			loadConfig (config);
		}
		else {
			log.info ("Creating default properties " + path);
			createConfig (config);
		}
		log.exit ();
	}

	/**
	 * @author Wasiq B
	 * @since 01-Apr-2015 8:16:13 pm
	 * @param config
	 */
	private static void loadConfig (final File config) {
		log.entry ();
		try (FileInputStream file = new FileInputStream (config)) {
			prop.loadFromXML (file);
		}
		catch (final IOException e) {
			log.error (e);
		}
		log.exit ();
	}

	/**
	 * @author Wasiq B
	 * @since 08-Mar-2015 9:46:18 pm
	 * @param property
	 * @return
	 */
	public static String getProperty (final PropertyConstants property) {
		log.entry ();
		final String value = prop.getProperty (property.getPropertyKey ());
		return log.exit (value);
	}

	/**
	 * @author Wasiq B
	 * @since 08-Mar-2015 9:44:58 pm
	 * @param property
	 * @param defaultValue
	 */
	public static String getProperty (final PropertyConstants property, final String defaultValue) {
		log.entry ();
		final String value = prop.getProperty (property.getPropertyKey (), defaultValue);
		return log.exit (value);
	}
}