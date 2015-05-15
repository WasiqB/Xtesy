package com.wizonsoft.xtesy.core.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wizonsoft.xtesy.core.interfaces.IKey;

/**
 * @author Wasiq B
 * @since 09-May-2015 12:44:14 pm
 */
public enum Key implements IKey {
	XTESY_DB_PASSWORD ("xtesy.db.password"),
	XTESY_DB_URL ("xtesy.db.url"),
	XTESY_DB_USERNAME ("xtesy.db.userName"),

	XTESY_ENVIRONMENT ("xtesy.env"),

	XTESY_LOGGER_SHOULD_LOG ("xtesy.logger.shouldLog"),
	XTESY_SERVICE_URL ("xtesy.service.url");

	private final String	key;
	private final Logger	log;

	/**
	 * @author Wasiq B
	 * @since 09-May-2015 12:43:16 pm
	 */
	private Key (final String key) {
		this.log = LogManager.getLogger (Key.class);
		this.log.entry ();
		this.key = key;
		this.log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.xtesy.core.config.IConfiguration.IKey#getKey()
	 */
	@Override
	public String getKey () {
		this.log.entry ();
		return this.log.exit (this.key);
	}
}