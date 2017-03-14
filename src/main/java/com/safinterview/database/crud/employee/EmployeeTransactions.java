package com.safinterview.database.crud.employee;

import java.net.ConnectException;
import java.net.SocketException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.safinterview.database.mysql.TransactionWrapper;
import com.safinterview.database.models.employee.EmployeeInfo;
import com.safinterview.database.schemas.TableSchemas;

/**
* EmployeeTransactions
*
* Provides a super set of methods for performing the CRUD database transactions
* for the table[employee] associated with this class
* 
* The actual transaction are performed else where.
*
* DO NOT DIRECTLY EDIT THIS CLASS. MAKE SEPARATE COPY BY EXTENDING THIS CLASS AND WRITING
* CUSTOM METHODS AND OVERRIDE THE METHODS TO CUSTOMIZE 
*
* This source code is auto-generated
* Victor Mwenda
* @author vmwenda.vm@gmail.com
*
*/
public class EmployeeTransactions extends TransactionWrapper {

	/**
	* Gets the table name associated with this transaction class
	* 
	* The actual table associated with this transaction class is employee
	*
	* @return the table name
	*/
	public final String getTableName() {
		return TableSchemas.Employee.TABLE_NAME;
	}

	/**
	* Inserts a new record in the table employee
	*
	* @param employeeInfo to insert
	* @throws SQLException 
	* @return the success status of the transaction
	*/
	public boolean insert(EmployeeInfo employeeInfo) throws SQLException {
		String[] columns = { TableSchemas.Employee.EMPLOYEE_UUID,TableSchemas.Employee.EMPLOYEE_NAME,TableSchemas.Employee.EMAIL_ADDRESS,TableSchemas.Employee.REPORTING_DATE,TableSchemas.Employee.AGE };
		String[] values = { String.valueOf(employeeInfo.getEmployeeUuid()),String.valueOf(employeeInfo.getEmployeeName()),String.valueOf(employeeInfo.getEmailAddress()),String.valueOf(employeeInfo.getReportingDate()),String.valueOf(employeeInfo.getAge()) };
		return insert(getTableName(), columns, values, true);
	}

	/**
	* Deleted a record from the table employee
	*
	* @param employeeInfo to delete
	*
	* @return the success status of the transaction
	*/
	public boolean delete(EmployeeInfo employeeInfo) throws SQLException {
		String[] whereColumns = { TableSchemas.Employee.EMPLOYEE_UUID,TableSchemas.Employee.EMPLOYEE_NAME,TableSchemas.Employee.EMAIL_ADDRESS,TableSchemas.Employee.REPORTING_DATE,TableSchemas.Employee.AGE };
		String[] whereRecords = { String.valueOf(employeeInfo.getEmployeeUuid()),String.valueOf(employeeInfo.getEmployeeName()),String.valueOf(employeeInfo.getEmailAddress()),String.valueOf(employeeInfo.getReportingDate()),String.valueOf(employeeInfo.getAge()) };
		return delete(getTableName(), whereColumns, whereRecords, false);
	}

	/**
	* Updates an existing record in the table employee
	*
	* @param oldEmployeeInfo to insert
	* @param newEmployeeInfo to delete
	*
	* @throws SocketException 
	* @throws ClassNotFoundException 
	* @throws ConnectException 
	*
	*@return number of update columns
	*/
	public int update(EmployeeInfo oldEmployeeInfo, EmployeeInfo newEmployeeInfo) throws SQLException, ConnectException, ClassNotFoundException, SocketException {

		String[] newColumns = {TableSchemas.Employee.EMPLOYEE_UUID,TableSchemas.Employee.EMPLOYEE_NAME,TableSchemas.Employee.EMAIL_ADDRESS,TableSchemas.Employee.REPORTING_DATE,TableSchemas.Employee.AGE};
		String[] newRecords = {String.valueOf(newEmployeeInfo.getEmployeeUuid()),String.valueOf(newEmployeeInfo.getEmployeeName()),String.valueOf(newEmployeeInfo.getEmailAddress()),String.valueOf(newEmployeeInfo.getReportingDate()),String.valueOf(newEmployeeInfo.getAge())};
		String[] whereColumns = {TableSchemas.Employee.EMPLOYEE_UUID,TableSchemas.Employee.EMPLOYEE_NAME,TableSchemas.Employee.EMAIL_ADDRESS,TableSchemas.Employee.REPORTING_DATE,TableSchemas.Employee.AGE};
		String[] whereRecords = {String.valueOf(oldEmployeeInfo.getEmployeeUuid()),String.valueOf(oldEmployeeInfo.getEmployeeName()),String.valueOf(oldEmployeeInfo.getEmailAddress()),String.valueOf(oldEmployeeInfo.getReportingDate()),String.valueOf(oldEmployeeInfo.getAge())};
		
		return update(getTableName(), newColumns, newRecords, whereColumns, whereRecords, false);
	}

	/**
	* Searches for records in the table employee
	*
	* @param employeeInfo to search
	* @throws SQLException 
	* @return a result set of the search query
	*/
	public ResultSet searchRaw(EmployeeInfo employeeInfo) throws SQLException {
		String[] whereColumns = { TableSchemas.Employee.EMPLOYEE_UUID,TableSchemas.Employee.EMPLOYEE_NAME,TableSchemas.Employee.EMAIL_ADDRESS,TableSchemas.Employee.REPORTING_DATE,TableSchemas.Employee.AGE };
		String[] whereRecords = { String.valueOf(employeeInfo.getEmployeeUuid()),String.valueOf(employeeInfo.getEmployeeName()),String.valueOf(employeeInfo.getEmailAddress()),String.valueOf(employeeInfo.getReportingDate()),String.valueOf(employeeInfo.getAge()) };
		return query(getTableName(), whereColumns, whereRecords, false);
	}

	/**
	* Searches for records in the table employee
	*
	* @param employeeInfo to search
	* @throws SQLException 
	* @return a list of the search query results
	*/
	public List<EmployeeInfo> search(EmployeeInfo employeeInfo) throws SQLException{
		
		List<EmployeeInfo> employeeInfoList = new ArrayList<>();
		
		String[] whereColumns = { TableSchemas.Employee.EMPLOYEE_UUID,TableSchemas.Employee.EMPLOYEE_NAME,TableSchemas.Employee.EMAIL_ADDRESS,TableSchemas.Employee.REPORTING_DATE,TableSchemas.Employee.AGE };
		String[] whereRecords = { String.valueOf(employeeInfo.getEmployeeUuid()),String.valueOf(employeeInfo.getEmployeeName()),String.valueOf(employeeInfo.getEmailAddress()),String.valueOf(employeeInfo.getReportingDate()),String.valueOf(employeeInfo.getAge()) };
		 
		ResultSet resultSet = query(getTableName(), whereColumns, whereRecords, false);

		for (resultSet.first(); !resultSet.isAfterLast(); resultSet.next()) {
			
			employeeInfoList.add(getEmployeeInfo(resultSet));
		}

		return employeeInfoList;
	}


	/**
	* Returns a list of all the records in the table employee
	* @throws SQLException 
	* @return List of EmployeeInfo objects
	* 
	*/
	public List<EmployeeInfo> getEmployeeInfoAll() throws SQLException {

		List<EmployeeInfo> employeeInfo = new ArrayList<>();
		
		ResultSet resultSet = queryAll(getTableName(), false);

		for (resultSet.first(); !resultSet.isAfterLast(); resultSet.next()) {

			employeeInfo.add(getEmployeeInfo(resultSet));
		}

		return employeeInfo;
	}

	/**
	* Returns a record of from the table employee based on the value of the primary key TableSchemas.Employee.EMPLOYEE_UUID
	* @param employeeUuid the primary key
	* @throws SQLException 
	* @return an object of EmployeeInfo that represents a single record
	* 
	*/
	public EmployeeInfo getEmployeeInfo(String employeeUuid) throws SQLException{

		String[] whereColumns = {TableSchemas.Employee.EMPLOYEE_UUID};
		
		String[] whereRecords = {String.valueOf(employeeUuid)};
		
		ResultSet resultSet = query(getTableName(), whereColumns, whereRecords, false);

        if (resultSet != null) {
            resultSet.first();
            return getEmployeeInfo(resultSet);
        }
        return null;
	}

    /**
	 * Create an object of EmployeeInfo from the result set
	 * @param resultSet the result set from the executed query
	 * @return EmployeeInfo
	 * @throws SQLException
     */
    public EmployeeInfo getEmployeeInfo(ResultSet resultSet) throws SQLException{

        String employeeUuid = resultSet.getString(TableSchemas.Employee.EMPLOYEE_UUID);String employeeName = resultSet.getString(TableSchemas.Employee.EMPLOYEE_NAME);String emailAddress = resultSet.getString(TableSchemas.Employee.EMAIL_ADDRESS);String reportingDate = resultSet.getString(TableSchemas.Employee.REPORTING_DATE);int age = resultSet.getInt(TableSchemas.Employee.AGE);

        return new EmployeeInfo(employeeUuid,employeeName,emailAddress,reportingDate,age);
    }

	/**
	* Gets the first record from the table employee that appears in the result set of the
	* records after executing the custom query
	*
	*
	* @throws SQLException 
	* @return the first record that matches appears in the result set of the records
	* 
	*/
	public Object getBlindColumn(String query, String column, Class<?> mClass) throws SQLException {
        return super.getBlindColumn(query,column,mClass);
	}
}
