package io.swagger.api;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.safinterview.database.crud.employee.EmployeeTransactions;
import com.safinterview.database.models.employee.EmployeeInfo;
import io.swagger.model.Employee;
import io.swagger.model.Error;

import io.swagger.annotations.*;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Entity;


import java.sql.SQLException;
import java.util.List;

import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-14T15:48:44.629Z")

@Controller
public class GetEmployeeApiController implements GetEmployeeApi {


    public ResponseEntity<Object> getEmployeeGet(@NotNull @ApiParam(value = "Email address of the employee", required = true) @RequestParam(value = "employeeemail", required = true) String employeeemail) {
        EmployeeTransactions employeeTransactions = new EmployeeTransactions();
        EmployeeInfo employee = null;
        try {
            List<EmployeeInfo> employeeInfos = employeeTransactions.getEmployeeInfoAll();
            for (EmployeeInfo employeeInfo : employeeInfos) {
                if (employeeInfo.getEmailAddress().equals(employeeemail)) {
                    employee = employeeInfo;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject();
        if (employee != null) {
            jsonObject.put("employeename", employee.getEmployeeName());
            jsonObject.put("emailaddress", employee.getEmailAddress());
            jsonObject.put("department", employee.getDepartment());
            jsonObject.put("age", employee.getAge());
            jsonObject.put("reportingdate", employee.getReportingDate());
        }

        return new ResponseEntity<Object>(jsonObject, HttpStatus.OK);
    }

}
