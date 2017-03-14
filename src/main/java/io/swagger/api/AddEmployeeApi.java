package io.swagger.api;

import io.swagger.model.Error;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-14T15:48:44.629Z")

@Api(value = "AddEmployee", description = "the AddEmployee API")
public interface AddEmployeeApi {

    @ApiOperation(value = "Adds a new employee", notes = "Adds a new employee ", response = Object.class, tags={ "AddEmployees", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Employee added", response = Object.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Object.class) })
    @RequestMapping(value = "/AddEmployee",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Object> addEmployeePost( @NotNull @ApiParam(value = "Name of employee", required = true) @RequestParam(value = "employeename", required = true) String employeename,
         @NotNull @ApiParam(value = "Email of employee", required = true) @RequestParam(value = "emailaddress", required = true) String emailaddress,
         @NotNull @ApiParam(value = "Age of employee", required = true) @RequestParam(value = "age", required = true) Integer age,
         @NotNull @ApiParam(value = "Department of the employee", required = true) @RequestParam(value = "department", required = true) String department,
         @NotNull @ApiParam(value = "Reporting date of the employee", required = true) @RequestParam(value = "reportingdate", required = true) String reportingdate);

}
