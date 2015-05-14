package com.wizonsoft.xtesy.core.internals.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wizonsoft.xtesy.core.data.IDataVariable;

/**
 * @author Wasiq B
 * @since 18-Jan-2015 8:01:01 pm
 */
public class DataVariable implements IDataVariable {
	private static Logger	log;
	private final int		index;
	private final String	name;

	static {
		log = LogManager.getLogger (DataVariable.class);
	}

	/**
	 * @author Wasiq B
	 * @since 18-Jan-2015 8:01:44 pm
	 * @param name
	 * @param index
	 */
	public DataVariable (final String name, final int index) {
		log.entry ();
		this.name = name;
		this.index = index;
		log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataVariable#getIndex()
	 */
	@Override
	public int getIndex () {
		log.entry ();
		return log.exit (this.index);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataVariable#getName()
	 */
	@Override
	public String getName () {
		log.entry ();
		return log.exit (this.name);
	}
}