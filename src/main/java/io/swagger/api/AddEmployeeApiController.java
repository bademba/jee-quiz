package io.swagger.api;

import com.safinterview.database.crud.employee.EmployeeTransactions;
import com.safinterview.database.models.employee.EmployeeInfo;
import io.swagger.model.Error;

import io.swagger.annotations.*;

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

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-14T15:48:44.629Z")

@Controller
public class AddEmployeeApiController implements AddEmployeeApi {


    public ResponseEntity<Object> addEmployeePost(@NotNull @ApiParam(value = "Name of employee", required = true) @RequestParam(value = "employeename", required = true) String employeename,
                                                  @NotNull @ApiParam(value = "Email of employee", required = true) @RequestParam(value = "emailaddress", required = true) String emailaddress,
                                                  @NotNull @ApiParam(value = "Age of employee", required = true) @RequestParam(value = "age", required = true) Integer age,
                                                  @NotNull @ApiParam(value = "Department of the employee", required = true) @RequestParam(value = "department", required = true) String department,
                                                  @NotNull @ApiParam(value = "Reporting date of the employee", required = true) @RequestParam(value = "reportingdate", required = true) String reportingdate) {

        String randomUUID = UUID.randomUUID().toString();
        EmployeeInfo employeeInfo = new EmployeeInfo(randomUUID, employeename, emailaddress, department, reportingdate, age);

        boolean add = false;

        EmployeeTransactions employeeTransactions = new EmployeeTransactions();
        try {
            add = employeeTransactions.insert(employeeInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject();
        if (add) {
            jsonObject.put("result", "successful");
            jsonObject.put("employee", employeeInfo);
        } else {
            jsonObject.put("result", "failed");
        }
        return new ResponseEntity<Object>(jsonObject, HttpStatus.OK);
    }

}
