package com.wizonsoft.xtesy.core.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wizonsoft.xtesy.core.data.IDataTableExt;
import com.wizonsoft.xtesy.internals.data.DataTable;

/**
 * @author Wasiq B
 * @since 11-May-2015 4:58:18 pm
 */
public abstract class AbstractFileParser implements IFileParser {
	protected static Logger	log;
	protected IDataTableExt	table;
	
	static {
		log = LogManager.getLogger (AbstractFileParser.class);
	}

	/**
	 * @author Wasiq B
	 * @since 12-May-2015 10:52:41 am
	 */
	public AbstractFileParser () {
		log.entry ();
		this.table = new DataTable ();
		log.exit ();
	}
}