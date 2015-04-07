package com.wizonsoft.teasy.internals.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wizonsoft.teasy.data.IDataRow;
import com.wizonsoft.teasy.data.IDataRowIterator;

/**
 * @author Wasiq B
 * @since 24-Jan-2015 7:53:45 pm
 */
public class DataRowIterator implements IDataRowIterator {
	private static Logger		log;
	private int					index;
	private final IDataRow []	rows;

	static {
		log = LogManager.getLogger (DataRowIterator.class);
	}

	/**
	 * @author Wasiq B
	 * @since 24-Jan-2015 7:53:45 pm
	 */
	public DataRowIterator (final IDataRow [] rows) {
		log.entry ();
		this.rows = rows;
		reset ();
		log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRowIterator#current()
	 */
	@Override
	public IDataRow current () {
		log.entry ();
		return log.exit (this.rows [this.index]);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRowIterator#getValue(int)
	 */
	@Override
	public <T> T getValue (final int variableIndex) {
		log.entry ();
		return log.exit (current ().getColumn (variableIndex).getValue ());
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRowIterator#getValue(java.lang.String)
	 */
	@Override
	public <T> T getValue (final String variableName) {
		log.entry ();
		return log.exit (current ().getColumn (variableName).getValue ());
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRowIterator#hasNext()
	 */
	@Override
	public boolean hasNext () {
		log.entry ();
		return log.exit (this.index < this.rows.length - 1);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRowIterator#next()
	 */
	@Override
	public void next () {
		log.entry ();
		this.index++;
		log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.teasy.data.IDataRowIterator#reset()
	 */
	@Override
	public void reset () {
		log.entry ();
		this.index = 0;
		log.exit ();
	}
}