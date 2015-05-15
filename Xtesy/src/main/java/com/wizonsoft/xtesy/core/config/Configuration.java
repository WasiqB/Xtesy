package com.wizonsoft.xtesy.core.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wizonsoft.xtesy.core.interfaces.IConfiguration;
import com.wizonsoft.xtesy.core.interfaces.IKey;

/**
 * @author Wasiq B
 * @since 08-May-2015 10:03:31 pm
 */
public enum Configuration implements IConfiguration {
	INSTANCE ("/config.properties");

	private final Logger		log;
	private final Properties	prop;

	/**
	 * @author Wasiq B
	 * @since 08-May-2015 10:14:41 pm
	 * @param path
	 */
	private Configuration (final String path) {
		this.log = LogManager.getLogger (Configuration.class);
		this.log.entry ();
		this.prop = new Properties ();
		final String dir = System.getProperty ("user.dir") + "/";

		try (FileInputStream in = new FileInputStream (dir + path)) {
			this.prop.load (in);
		}
		catch (final IOException e) {
			this.log.catching (e);
		}
		this.log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.wizonsoft.xtesy.core.config.IConfiguration#getValue(com.wizonsoft
	 * .xtesy.core.config.IConfiguration.IKey)
	 */
	@Override
	public String getValue (final IKey key) {
		this.log.entry ();
		return this.log.exit (this.prop.getProperty (key.getKey ()));
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.wizonsoft.xtesy.core.config.IConfiguration#getValue(com.wizonsoft
	 * .xtesy.core.config.IConfiguration.IKey, java.lang.String)
	 */
	@Override
	public String getValue (final IKey key, final String defaultValue) {
		this.log.entry ();
		return this.log.exit (this.prop.getProperty (key.getKey (), defaultValue));
	}
}