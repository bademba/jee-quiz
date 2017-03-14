package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
/**
 * Employee
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-14T15:48:44.629Z")

public class Employee   {
  @JsonProperty("employeename")
  private String employeename = null;

  @JsonProperty("emailaddress")
  private String emailaddress = null;

  @JsonProperty("department")
  private String department = null;

  @JsonProperty("age")
  private Integer age = null;

  @JsonProperty("reportingdate")
  private String reportingdate = null;

  public Employee employeename(String employeename) {
    this.employeename = employeename;
    return this;
  }

   /**
   * Name of the employee
   * @return employeename
  **/
  @ApiModelProperty(value = "Name of the employee")
  public String getEmployeename() {
    return employeename;
  }

  public void setEmployeename(String employeename) {
    this.employeename = employeename;
  }

  public Employee emailaddress(String emailaddress) {
    this.emailaddress = emailaddress;
    return this;
  }

   /**
   * Email address of the employee
   * @return emailaddress
  **/
  @ApiModelProperty(value = "Email address of the employee")
  public String getEmailaddress() {
    return emailaddress;
  }

  public void setEmailaddress(String emailaddress) {
    this.emailaddress = emailaddress;
  }

  public Employee department(String department) {
    this.department = department;
    return this;
  }

   /**
   * Department of the employee
   * @return department
  **/
  @ApiModelProperty(value = "Department of the employee")
  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public Employee age(Integer age) {
    this.age = age;
    return this;
  }

   /**
   * Age of the employee
   * @return age
  **/
  @ApiModelProperty(value = "Age of the employee")
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Employee reportingdate(String reportingdate) {
    this.reportingdate = reportingdate;
    return this;
  }

   /**
   * Reporting date of the employee
   * @return reportingdate
  **/
  @ApiModelProperty(value = "Reporting date of the employee")
  public String getReportingdate() {
    return reportingdate;
  }

  public void setReportingdate(String reportingdate) {
    this.reportingdate = reportingdate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(this.employeename, employee.employeename) &&
        Objects.equals(this.emailaddress, employee.emailaddress) &&
        Objects.equals(this.department, employee.department) &&
        Objects.equals(this.age, employee.age) &&
        Objects.equals(this.reportingdate, employee.reportingdate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeename, emailaddress, department, age, reportingdate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");
    
    sb.append("    employeename: ").append(toIndentedString(employeename)).append("\n");
    sb.append("    emailaddress: ").append(toIndentedString(emailaddress)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    reportingdate: ").append(toIndentedString(reportingdate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

