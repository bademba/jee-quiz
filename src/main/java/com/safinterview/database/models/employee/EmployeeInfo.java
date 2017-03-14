package com.safinterview.database.models.employee;

/**
 * EmployeeInfo
 *
 * This source code is auto-generated
 * Victor Mwenda
 * @author vmwenda.vm@gmail.com
 *
 */
public class EmployeeInfo{

 private String employeeUuid; private String employeeName; private String emailAddress; private String department; private String reportingDate; private int age;

public EmployeeInfo ( String employeeUuid, String employeeName, String emailAddress, String department, String reportingDate, int age) {
	this.employeeUuid = employeeUuid;this.employeeName = employeeName;this.emailAddress = emailAddress;this.department = department;this.reportingDate = reportingDate;this.age = age;
}

/**
* Gets the value of employeeUuid
*
* @return employeeUuid employeeUuid
*/
public String getEmployeeUuid (){
	return employeeUuid;
}

/**
* Sets the value of  employeeUuid
*
* @param  employeeUuid  employeeUuid
*/
public void setEmployeeUuid (String employeeUuid){
	this.employeeUuid = employeeUuid;
}

/**
* Sets the value of  employeeUuid
*
* @param  employeeUuid  employeeUuid
* @return an handle of this class object to enable set more params
*/
public EmployeeInfo appendEmployeeUuid (String employeeUuid){
	this.setEmployeeUuid (employeeUuid);
	return this;
}
/**
* Gets the value of employeeName
*
* @return employeeName employeeName
*/
public String getEmployeeName (){
	return employeeName;
}

/**
* Sets the value of  employeeName
*
* @param  employeeName  employeeName
*/
public void setEmployeeName (String employeeName){
	this.employeeName = employeeName;
}

/**
* Sets the value of  employeeName
*
* @param  employeeName  employeeName
* @return an handle of this class object to enable set more params
*/
public EmployeeInfo appendEmployeeName (String employeeName){
	this.setEmployeeName (employeeName);
	return this;
}
/**
* Gets the value of emailAddress
*
* @return emailAddress emailAddress
*/
public String getEmailAddress (){
	return emailAddress;
}

/**
* Sets the value of  emailAddress
*
* @param  emailAddress  emailAddress
*/
public void setEmailAddress (String emailAddress){
	this.emailAddress = emailAddress;
}

/**
* Sets the value of  emailAddress
*
* @param  emailAddress  emailAddress
* @return an handle of this class object to enable set more params
*/
public EmployeeInfo appendEmailAddress (String emailAddress){
	this.setEmailAddress (emailAddress);
	return this;
}
/**
* Gets the value of department
*
* @return department department
*/
public String getDepartment (){
	return department;
}

/**
* Sets the value of  department
*
* @param  department  department
*/
public void setDepartment (String department){
	this.department = department;
}

/**
* Sets the value of  department
*
* @param  department  department
* @return an handle of this class object to enable set more params
*/
public EmployeeInfo appendDepartment (String department){
	this.setDepartment (department);
	return this;
}
/**
* Gets the value of reportingDate
*
* @return reportingDate reportingDate
*/
public String getReportingDate (){
	return reportingDate;
}

/**
* Sets the value of  reportingDate
*
* @param  reportingDate  reportingDate
*/
public void setReportingDate (String reportingDate){
	this.reportingDate = reportingDate;
}

/**
* Sets the value of  reportingDate
*
* @param  reportingDate  reportingDate
* @return an handle of this class object to enable set more params
*/
public EmployeeInfo appendReportingDate (String reportingDate){
	this.setReportingDate (reportingDate);
	return this;
}
/**
* Gets the value of age
*
* @return age age
*/
public int getAge (){
	return age;
}

/**
* Sets the value of  age
*
* @param  age  age
*/
public void setAge (int age){
	this.age = age;
}

/**
* Sets the value of  age
*
* @param  age  age
* @return an handle of this class object to enable set more params
*/
public EmployeeInfo appendAge (int age){
	this.setAge (age);
	return this;
}


}
