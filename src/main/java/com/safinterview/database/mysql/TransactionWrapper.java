package com.safinterview.database.mysql;

import java.net.ConnectException;
import java.net.SocketException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.safinterview.database.mysql.RecordsInsertException;
import com.safinterview.database.mysql.RecordsQueryException;
import com.safinterview.database.mysql.RecordsUpdateException;


/**
* TransactionWrapper
*
* TransactionWrapper - Provides API's for performing MYSQL Operations
*
* This source code is auto-generated
* Victor Mwenda
* @author vmwenda.vm@gmail.com
*
*/
public class TransactionWrapper {

	public TransactionWrapper() {

	}

	// MYSQL Query Executor
	private MYSQLTransactionsExecutor transactionsExecutor;

	/**
	 * Get MYSQL query executor - Get an handle for using to execute MYSQL
	 * queries
	 * 
	 * @return
	 */
	public MYSQLTransactionsExecutor getMYSQLTransactionsExecutor() {

		if (transactionsExecutor == null) {
			transactionsExecutor = new MYSQLTransactionsExecutor(getMYSQLDatabaseConnection());
		}
		return transactionsExecutor;
	}

	// MYSQL Database Connection
	private MYSQLDatabaseConnection databaseConnection;

	/**
	 * Get MYSQL Database Connection
	 * 
	 * @return MYSQLDatabaseConnection
	 */
	public MYSQLDatabaseConnection getMYSQLDatabaseConnection() {

		if (databaseConnection == null) {
			databaseConnection = new MYSQLDatabaseConnection(
			MYSQLDefaultConnectionProperties.DATABASE_HOST,
			MYSQLDefaultConnectionProperties.DATABASE_NAME,
			MYSQLDefaultConnectionProperties.DATABASE_USER,
			MYSQLDefaultConnectionProperties.USER_PASSWORD);
		}

		return databaseConnection;
	}

	/**
	 * Inserts the specified values in the specified columns in the specified
	 * table
	 * 
	 * @param table
	 * @param columns
	 * @param values
	 * @throws SQLException
	 */
	public boolean insert(String table, String[] columns, String[] values,boolean printSQL) throws SQLException {

		if (table.length() == 0 || table == null) {
			throw new NullPointerException("Invalid Table name ");
		}

		if (columns.length != values.length) {
			throw new RecordsUpdateException("Cannot insert records into the table [" + table + "]." + " Cannot match  "
					+ columns.length + "  table columns to " + values.length + " old records ");
		}

		String insertStatement = "INSERT INTO `" + table + "` (";

		for (int i = 0; i < columns.length; i++) {
			insertStatement += " `" + columns[i] + "`";
			if (i < columns.length - 1) {
				insertStatement += ",";
			}
		}
		insertStatement +=  ") VALUES (";

		for (int i = 0; i < columns.length; i++) {
			insertStatement += " '" + values[i] + "'";
			if (i < columns.length - 1) {
				insertStatement += ",";
			}
		}
		insertStatement += ");";
		
		if(printSQL){
			System.out.println(insertStatement);
		}
		return getMYSQLTransactionsExecutor().execute(insertStatement);
	}

	/**
	 * Updates the specified columns with the passed new records based on the
	 * where columns and the where records
	 * 
	 * @param table
	 * @param columns
	 * @param newRecords
	 * @param whereColumns
	 * @param whereRecords
	 * @param printSQL
	 * @return
	 * @throws SQLException
	 * @throws SocketException
	 * @throws ClassNotFoundException
	 * @throws ConnectException
	 */

	public int update(String table, String[] columns, String[] newRecords, String[] whereColumns, String[] whereRecords,
			boolean printSQL) throws SQLException, ConnectException, ClassNotFoundException, SocketException {

		if (table.length() == 0 || table == null) {
			throw new NullPointerException("Invalid Table name ");
		}

		if (columns.length != newRecords.length) {
			throw new RecordsUpdateException("Cannot update the table [" + table + "]." + " Cannot match  "
					+ columns.length + "  table columns to " + newRecords.length + " old records ");
		}

		if (whereColumns.length != whereRecords.length) {
			throw new RecordsUpdateException("Cannot update the table [" + table + "]." + " Cannot match "
					+ whereColumns.length + " table columns to " + whereRecords.length + " new records ");
		}

		String updateStatement = "UPDATE `" + table + "` SET ";

		for (int i = 0; i < columns.length; i++) {
			updateStatement += " `" + columns[i] + "`='" + newRecords[i] + "' ";
			if (i < columns.length - 1) {
				updateStatement += ",";
			}
		}
		updateStatement += " WHERE ";

		for (int i = 0; i < whereColumns.length; i++) {
			updateStatement += " `" + whereColumns[i] + "`='" + whereRecords[i] + "' ";
			if (i < whereColumns.length - 1) {
				updateStatement += " AND ";
			}
		}

		updateStatement += ";";

		if (printSQL) {
			System.out.println("statement.executeUpdate(" + updateStatement + ")");
		}
		return getMYSQLTransactionsExecutor().executeUpdate(updateStatement);
	}

	/**
	 * deletes the records that meet the criteria of the where columns and the
	 * where records
	 * 
	 * @param table
	 * @param whereColumns
	 * @param whereRecords
	 * @param printSQL
	 * @return
	 * @throws SQLException
	 */
	public boolean delete(String table, String[] whereColumns, String[] whereRecords, boolean printSQL)
			throws SQLException {

		if (table.length() == 0 || table == null) {
			throw new NullPointerException("Invalid Table name ");
		}

		if (whereColumns.length != whereRecords.length) {
			throw new RecordsUpdateException("Cannot delete the table [" + table + "]." + " Cannot match "
					+ whereColumns.length + " table columns to " + whereRecords.length + " new records ");
		}

		String deleteStatement = "DELETE FROM `" + table + "` WHERE";

		if(whereColumns.length ==0 &&whereRecords.length == 0 ){
			deleteStatement += " 1 ";
		}else{
			for (int i = 0; i < whereColumns.length; i++) {
				deleteStatement += " `" + whereColumns[i] + "`='" + whereRecords[i] + "' ";
				if (i < whereColumns.length - 1) {
					deleteStatement += " AND ";
				}
			}
		}
		deleteStatement += ";";

		if (printSQL) {
			System.out.println("statement.executeUpdate(" + deleteStatement + ")");
		}
		return getMYSQLTransactionsExecutor().execute(deleteStatement);
	}

	/**
	 * Performs a query on the table based from the passed columns and records
	 * 
	 * @param table
	 * @param whereColumns
	 * @param whereRecords
	 * @param printSQL
	 * @return
	 * @throws SQLException
	 */
	public ResultSet query(String table, String[] whereColumns, String[] whereRecords, boolean printSQL)
			throws SQLException {

		if (table.length() == 0 || table == null) {
			throw new NullPointerException("Invalid Table name ");
		}
		if (whereColumns.length != whereRecords.length) {
			throw new RecordsQueryException("Cannot query the table [" + table + "]." + " Cannot match "
					+ whereColumns.length + " table columns to " + whereRecords.length + " new records ");
		}

		String queryStatement = "SELECT * FROM `" + table + "` ";

		if ((whereColumns.length > 0) && (whereRecords.length > 0)) {
			queryStatement += " WHERE ";
			for (int i = 0; i < whereColumns.length; i++) {
				queryStatement += " `" + whereColumns[i] + "`='" + whereRecords[i] + "' ";
				if (i < whereColumns.length - 1) {
					queryStatement += " AND ";
				}
			}
		}

		if (printSQL) {
			System.out.println("statement.executeUpdate(" + queryStatement + ")");
		}
		return getMYSQLTransactionsExecutor().executeQuery(queryStatement);
	}

	/**
	 * Performs a query on the table and return all the rows in the table
	 * 
	 * @param table
	 * @param printSQL
	 * @return
	 * @throws SQLException
	 */
	public ResultSet queryAll(String table, boolean printSQL)
			throws SQLException {
		return query(table, new String [] {}, new String [] {}, printSQL);
	}

	/**
	 * Bulk insert the specified records into the specified columns
	 * 
	 * @param table
	 * @param columns
	 * @param records
	 * @param printSQL
	 * @return
	 * @throws SQLException
	 */
	public boolean bulkInsert(String table, String[] columns, String[] records, boolean printSQL) throws SQLException {
		if (table.length() == 0 || table == null) {
			throw new NullPointerException("Invalid Table name ");
		}

		if (columns.length != records.length) {
			throw new RecordsInsertException("Cannot update the table [" + table + "]." + " Cannot match  "
					+ columns.length + "  table columns to " + records.length + " old records ");
		}
		String query = " INSERT INTO `" + table + "` (";

		for (int i = 0; i < columns.length; i++) {
			query += " `" + columns[i] + "` ";
			if ((i < columns.length - 1)) {
				query += ",";
			}
		}
		int record_count = records.length;
		int column_count = columns.length;

		int valueset = record_count / column_count;

		if (record_count % column_count == 0) {
		} else {
			throw new RecordsInsertException("The number of columns and record count does not match");
		}
		query += ") VALUES ";

		for (int i = 0; i < valueset; i++) {
			query += "(";
			int record_set = ((i + 1) * column_count);
			for (int x = (i * column_count); x < record_set; x++) {

				query += " '" + records[x] + "' ";
				if ((x < (record_set - 1))) {
					query += ",";
				}
			}
			if ((i < valueset - 1)) {
				query += "),";
			} else {
				query += ")";
			}
		}

		if (printSQL) {
			System.out.println(query);
		}
		return getMYSQLTransactionsExecutor().execute(query);
	}
	/**
     * Gets the first record from the table  that appears in the result set of the
    	* records after executing the custom query
    	 *
    	 * @return the first record that matches appears in the result set of the records
    	 * @throws SQLException
    	 */
    public Object getBlindColumn(String query, String column, Class<?> mClass) throws SQLException {

    		ResultSet resultSet = getMYSQLTransactionsExecutor().execSQL(query);

    		if (resultSet != null) {
    			resultSet.first();

    			if (mClass == Boolean.class || mClass == Double.class ||
    					mClass == Float.class || mClass == Integer.class ||
    					mClass == Long.class || mClass == Short.class || mClass == String.class) {

    				if (mClass == Boolean.class) {
    					return (Boolean) resultSet.getBoolean(column);
    				}
    				if (mClass == Double.class) {
    					return (Double) resultSet.getDouble(column);
    				}
    				if (mClass == Float.class) {
    					return (Float) resultSet.getFloat(column);
    				}
    				if (mClass == Integer.class) {
    					return (Integer) resultSet.getInt(column);
    				}
    				if (mClass == Long.class) {
    					return (Long) resultSet.getLong(column);
    				}
    				if (mClass == Short.class) {
    					return (Short) resultSet.getShort(column);
    				}
    				if (mClass == String.class) {
    					return (String) resultSet.getString(column);
    				}
    		} else {
    			throw new IllegalArgumentException("This method only accepts the following classes [Boolean, Double, Float, Integer, Long, Short]");
    		}
    	}
    	return null;
    }
}
