package com.safinterview.database.schemas;

/**
* Table Schemas
*
* Contains all the schemas for the tables in the database
*
* This source code is auto-generated
* Victor Mwenda
* @author vmwenda.vm@gmail.com
* 
*/
public class TableSchemas {

    public static final String[] TABLES_SQL = {
            Employee.SQL
    };

	    /**
    *	Schemas for the table employee
    *
    */
    
    public static class Employee {

        public static final String TABLE_NAME = "employee";

        
        public static final String EMPLOYEE_UUID = "employee_uuid";
public static final String EMPLOYEE_NAME = "employee_name";
public static final String EMAIL_ADDRESS = "email_address";
public static final String REPORTING_DATE = "reporting_date";
public static final String AGE = "age";

        
        public static final String SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
	+ " (" 
		+EMPLOYEE_UUID +" varchar  NOT NULL   " +","
+EMPLOYEE_NAME +" varchar  NOT NULL   " +","
+EMAIL_ADDRESS +" varchar  NOT NULL   " +","
+REPORTING_DATE +" date  NOT NULL   " +","
+AGE +" int  NOT NULL   " +""

    +");";


    }

}
