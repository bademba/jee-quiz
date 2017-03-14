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

@Api(value = "GetEmployee", description = "the GetEmployee API")
public interface GetEmployeeApi {

    @ApiOperation(value = "Returns a single emloyee", notes = "An endpoint that returns a single employee", response = Object.class, tags={ "GetEmployee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The employee with the provided email address", response = Object.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Object.class) })
    @RequestMapping(value = "/GetEmployee",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> getEmployeeGet( @NotNull @ApiParam(value = "Email address of the employee", required = true) @RequestParam(value = "employeeemail", required = true) String employeeemail);

}
