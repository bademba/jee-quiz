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

import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-14T15:48:44.629Z")

@Controller
public class DeleteEmployeeApiController implements DeleteEmployeeApi {


    public ResponseEntity<Boolean> deleteEmployeePost(@NotNull @ApiParam(value = "Email address of the employee", required = true) @RequestParam(value = "employeeemail", required = true) String employeeemail) {
        boolean deleted = false;
        EmployeeTransactions employeeTransactions = new EmployeeTransactions();
        try {
            List<EmployeeInfo> employeeInfos = employeeTransactions.getEmployeeInfoAll();
            for (EmployeeInfo employeeInfo : employeeInfos) {
                if (employeeInfo.getEmailAddress().equals(employeeemail)) {
                    deleted = employeeTransactions.delete(employeeInfo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Boolean>(!deleted, HttpStatus.OK);
    }

}
