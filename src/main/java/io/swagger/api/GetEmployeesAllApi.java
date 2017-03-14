package io.swagger.api;

import io.swagger.model.Employee;
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

@Api(value = "GetEmployeesAll", description = "the GetEmployeesAll API")
public interface GetEmployeesAllApi {

    @ApiOperation(value = "Returns every single emloyee", notes = "An endpoint that returns every single employee", response = Employee.class, responseContainer = "List", tags={ "GetEmployees", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of employees", response = Employee.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Employee.class) })
    @RequestMapping(value = "/GetEmployeesAll",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Employee>> getEmployeesAllGet();

}
