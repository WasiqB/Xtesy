package com.wizonsoft.xtesy.core.data;

import static com.wizonsoft.xtesy.utils.lang.Strings.isNullOrEmpty;
import static java.sql.DriverManager.getConnection;

import java.sql.*;

import com.wizonsoft.xtesy.internals.data.ResultSetHelper;

/**
 * @author Wasiq B
 * @since 18-Jan-2015 7:02:57 pm
 */
public class ConnectionHelper {
	private Connection				conn;
	private final ConnectionDetails	details;
	private IDataSet				ds;
	private int						rowsUpdated;

	/**
	 * @author Wasiq B
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @since 18-Jan-2015 7:02:57 pm
	 */
	private ConnectionHelper (final ConnectionDetails details) throws SQLException,
			InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.details = details;
		initializeDriver ();
	}

	/**
	 * @author Wasiq B
	 * @since 10-Feb-2015 8:55:43 pm
	 * @param details
	 * @return
	 */
	public static ConnectionHelper initialize (final ConnectionDetails details) {
		return initialize (details);
	}

	/**
	 * @author Wasiq B
	 * @throws SQLException
	 * @since 10-Feb-2015 8:55:38 pm
	 */
	private void initializeConnection () throws SQLException {
		if (isNullOrEmpty (this.details.getUserId ()))
			this.conn = getConnection (this.details.getUrl ());
		else {
			this.conn = getConnection (this.details.getUrl (), this.details.getUserId (),
					this.details.getPassword ());
		}
	}

	/**
	 * @author Wasiq B
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SQLException
	 * @since 10-Feb-2015 8:53:12 pm
	 */
	private void initializeDriver () throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		final Driver driver = (Driver) Class.forName (this.details.getDriver ()).newInstance ();
		DriverManager.registerDriver (driver);
	}

	/**
	 * @author Wasiq B
	 * @since 10-Feb-2015 9:10:39 pm
	 * @throws SQLException
	 */
	public void commit () throws SQLException {
		if (isConnected ()) this.conn.commit ();
	}

	/**
	 * @author Wasiq B
	 * @throws SQLException
	 * @since 10-Feb-2015 9:02:06 pm
	 */
	public void connect () throws SQLException {
		if (!isConnected ()) initializeConnection ();
	}

	/**
	 * @author Wasiq B
	 * @throws SQLException
	 * @since 10-Feb-2015 9:08:16 pm
	 */
	public void disconnect () throws SQLException {
		if (isConnected ()) {
			this.conn.close ();
			this.conn = null;
		}
	}

	/**
	 * @author Wasiq B
	 * @since 10-Feb-2015 9:16:42 pm
	 * @param query
	 * @throws SQLException
	 */
	public void execute (final String query) throws SQLException {
		if (!isConnected ()) return;
		final ResultSetHelper rsh = new ResultSetHelper ();
		try (Statement stmt = this.conn.createStatement ()) {
			if (stmt.execute (query)) {
				while (stmt.getMoreResults ()) {
					try (ResultSet rs = stmt.getResultSet ()) {
						rsh.addResultSet (rs);
						rs.close ();
					}
					catch (final SQLException e) {
						throw e;
					}
				}
			}
			else {
				this.rowsUpdated = stmt.getUpdateCount ();
			}
			stmt.close ();
		}
		catch (final SQLException e) {
			throw e;
		}
		this.ds = rsh.getDataSet ();
	}

	/**
	 * @author Wasiq B
	 * @since 10-Feb-2015 9:32:59 pm
	 * @return the ds
	 */
	public IDataSet getDataSet () {
		return this.ds;
	}

	/**
	 * @author Wasiq B
	 * @since 10-Feb-2015 9:32:59 pm
	 * @return the rowsUpdated
	 */
	public int getRowsUpdated () {
		return this.rowsUpdated;
	}

	/**
	 * @author Wasiq B
	 * @since 10-Feb-2015 9:05:22 pm
	 * @return
	 * @throws SQLException
	 */
	public boolean isConnected () throws SQLException {
		return this.conn != null && !this.conn.isClosed ();
	}

	/**
	 * @author Wasiq B
	 * @throws SQLException
	 * @since 10-Feb-2015 9:12:37 pm
	 */
	public void rollback () throws SQLException {
		if (isConnected ()) this.conn.rollback ();
	}

	/**
	 * @author Wasiq B
	 * @since 10-Feb-2015 9:11:42 pm
	 * @param autoCommit
	 * @throws SQLException
	 */
	public void setAutoCommit (final boolean autoCommit) throws SQLException {
		if (isConnected ()) this.conn.setAutoCommit (autoCommit);
	}
}