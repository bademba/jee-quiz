package io.swagger.api;

import io.swagger.model.Employee;
import io.swagger.model.Error;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-14T15:48:44.629Z")

@Controller
public class SetReportingDateApiController implements SetReportingDateApi {


    public ResponseEntity<String> setReportingDatePut(@NotNull @ApiParam(value = "Email address of the employee", required = true) @RequestParam(value = "employeeemail", required = true) String employeeemail,
                                                      @NotNull @ApiParam(value = "The reporting days of the employee", required = true) @RequestParam(value = "days", required = true) String days) {

        ResponseEntity<Object> employeeGet = new GetEmployeeApiController().getEmployeeGet(employeeemail);

        int reportingDate = Integer.parseInt(days);

        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
