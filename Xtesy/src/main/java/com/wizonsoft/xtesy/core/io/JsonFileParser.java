package com.wizonsoft.xtesy.core.io;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.wizonsoft.xtesy.core.data.IDataColumn;
import com.wizonsoft.xtesy.core.data.IDataRow;
import com.wizonsoft.xtesy.core.data.IDataTable;
import com.wizonsoft.xtesy.core.data.IDataVariable;
import com.wizonsoft.xtesy.internals.data.DataColumn;
import com.wizonsoft.xtesy.internals.data.DataRow;
import com.wizonsoft.xtesy.internals.data.DataVariable;

/**
 * @author Wasiq B
 * @since 11-May-2015 4:54:15 pm
 */
public class JsonFileParser extends AbstractFileParser {
	protected JsonFactory	factory;
	protected int			index;
	protected JsonParser	parser;
	protected IDataRow		row;

	/**
	 * @author Wasiq B
	 * @since 11-May-2015 4:54:16 pm
	 */
	public JsonFileParser () {
		super ();
		log.entry ();
		this.factory = new JsonFactory ();
		this.index = 0;
		log.exit ();
	}

	/**
	 * @author Wasiq B
	 * @since 12-May-2015 11:06:28 am
	 * @param columnName
	 * @param value
	 */
	private void addRow (String columnName, String value) {
		log.entry ();
		IDataVariable variable = new DataVariable (columnName, this.index);
		IDataColumn column = new DataColumn <> (variable, value);
		this.row.addColumn (column);
		log.exit ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.wizonsoft.xtesy.core.io.IFileParser#parse(java.lang.String)
	 */
	@Override
	public IDataTable parse (String path) {
		log.entry ();
		try {
			this.parser = this.factory.createParser (new File (path));
			parseFile ();
		}
		catch (IOException e) {
			log.catching (e);
		}
		return log.exit ((IDataTable) this.table);
	}

	/**
	 * @author Wasiq B
	 * @since 12-May-2015 11:02:31 am
	 */
	private void parseFile () throws JsonParseException, IOException {
		log.entry ();
		JsonToken token;
		while ((token = this.parser.nextToken ()) != JsonToken.END_ARRAY) {
			if (token == JsonToken.START_OBJECT) {
				this.row = new DataRow ();
				while ((token = this.parser.nextToken ()) != JsonToken.END_OBJECT) {
					this.index++;
					String columnName = this.parser.getCurrentName ();
					token = this.parser.nextToken ();
					String value = this.parser.getText ();
					addRow (columnName, value);
				}
				this.table.addRow (this.row);
			}
		}
		log.exit ();
	}
}