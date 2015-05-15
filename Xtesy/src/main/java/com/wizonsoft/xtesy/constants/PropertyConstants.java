package com.wizonsoft.xtesy.constants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wizonsoft.xtesy.core.config.TeasyConfiguration;

/**
 * @author Wasiq B
 * @since 08-Mar-2015 9:56:23 pm
 */
public enum PropertyConstants {
	DATABASE_DRIVER ("teasy.db.driver"),
	DATABASE_PASSWORD ("teasy.db.password"),
	DATABASE_URL ("teasy.db.url"),
	DATABASE_USERNAME ("teasy.db.userName"),
	LOGGER_LOG_EVENTS ("teasy.logger.logEvents"),

	LOGGER_LOG_PATH ("teasy.logger.logPath"),
	PROPERTIES_FILE ("teasy.propertiesFile"),

	SEED_DATA_FILE ("teasy.seed.file"),
	SERVICES_URL ("teasy.services.url"),

	TESTNG_LOG_PATH ("teasy.testNg.logPath"),
	TESTNG_LOG_TYPE ("teasy.testNg.logType");

	private static Logger	log	= LogManager.getLogger (PropertyConstants.class);
	private final String	name;

	/**
	 * @author Wasiq B
	 * @since 01-Apr-2015 8:18:02 pm
	 * @param name
	 */
	private PropertyConstants (final String name) {
		this.name = name;
	}

	/**
	 * @author Wasiq B
	 * @since 05-Apr-2015 1:32:14 pm
	 * @return
	 */
	public String getProperty () {
		log.entry ();
		final String prop = TeasyConfiguration.getProperty (this);
		return log.exit (prop);
	}

	/**
	 * @author Wasiq B
	 * @since 01-Apr-2015 8:18:38 pm
	 */
	public String getPropertyKey () {
		log.entry ();
		return log.exit (this.name);
	}
}