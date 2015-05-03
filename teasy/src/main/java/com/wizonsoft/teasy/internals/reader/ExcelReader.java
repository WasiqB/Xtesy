package com.wizonsoft.teasy.internals.reader;

import java.io.*;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Wasiq B
 * @since 23-Nov-2014 7:28:50 pm
 */
public final class ExcelReader {
	private static Map <Integer, String>	header;
	private static FileInputStream			reader;
	private static Workbook					workbook;

	/**
	 * @author Wasiq B
	 * @since 13-Dec-2014 6:06:20 pm
	 */
	private ExcelReader () {
		header = new HashMap <Integer, String> ();
	}

	/**
	 * @author Wasiq B
	 * @since 23-Nov-2014 7:35:36 pm
	 * @param path
	 * @throws IOException
	 */
	private ExcelReader (final String path) throws IOException {
		this ();
		final File file = new File (path);
		reader = new FileInputStream (file);
		final String extension = path.substring (path.lastIndexOf ("."));
		if (extension.equalsIgnoreCase (".xlsx")) {
			workbook = new XSSFWorkbook (reader);
		}
		else {
			workbook = new HSSFWorkbook (reader);
		}
	}

	/**
	 * @author Wasiq B
	 * @since 23-Nov-2014 7:36:31 pm
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static ExcelReader parseReader (final String path) throws IOException {
		return new ExcelReader (path);
	}

	/**
	 * @author Wasiq B
	 * @since 14-Dec-2014 5:19:20 pm
	 * @param rowData
	 */
	private void loadHeader (final Row rowData) {
		for (final Cell cell : rowData) {
			header.put (cell.getColumnIndex (), cell.getStringCellValue ());
		}
	}

	/**
	 * @author Wasiq B
	 * @since 14-Dec-2014 5:25:50 pm
	 * @param row
	 * @param sheet
	 * @param condition
	 * @return
	 */
	private ProviderParams parseRow (final Row row, final Sheet sheet,
			final ProviderParams condition) {
		final ProviderParams param = new ProviderParams ();
		for (final Cell cell : row)
			if (!sheet.isColumnHidden (cell.getColumnIndex ())) {
				final String column = header.get (cell.getColumnIndex ());
				final String value = cell.getStringCellValue ();
				if (condition != null && condition.size () > 0) {
					if (condition.hasField (column)) {
						final String condValue = condition.getFieldValue (column);
						if (value.equalsIgnoreCase (condValue)) {
							param.setFieldValue (column, value);
						}
					}
				}
				else param.setFieldValue (column, value);
			}
		return param;
	}

	/**
	 * @author Wasiq B
	 * @since 29-Nov-2014 7:22:30 pm
	 */
	public void dispose () {
		try {
			reader.close ();
			workbook = null;
		}
		catch (final IOException e) {
			e.printStackTrace ();
		}
	}

	/**
	 * @author Wasiq B
	 * @since 29-Nov-2014 7:35:45 pm
	 * @param sheetName
	 * @return
	 */
	public Iterator <Object []> getDataProvider (final String sheetName) {
		return getDataProvider (sheetName, null);
	}

	/**
	 * @author Wasiq B
	 * @since 23-Nov-2014 7:55:49 pm
	 * @param sheetName
	 * @param range
	 * @return
	 */
	public Iterator <Object []> getDataProvider (final String sheetName,
			final ProviderParams condition) {
		final Sheet sheet = getSheet (sheetName);
		final List <Object []> data = new ArrayList <Object []> ();
		if (sheet != null) {
			for (final Iterator <Row> row = sheet.rowIterator (); row.hasNext ();) {
				final Row rowData = row.next ();
				if (rowData != null && !rowData.getZeroHeight ()) {
					if (sheet.getFirstRowNum () == rowData.getRowNum ()) {
						loadHeader (rowData);
						continue;
					}
					final ProviderParams params = parseRow (rowData, sheet, condition);
					data.add (new Object [] { params });
				}
			}
		}
		return data.iterator ();
	}

	/**
	 * @author Wasiq B
	 * @since 23-Nov-2014 7:37:38 pm
	 * @param sheetName
	 * @return
	 */
	public Sheet getSheet (final String sheetName) {
		return workbook.getSheet (sheetName);
	}
}