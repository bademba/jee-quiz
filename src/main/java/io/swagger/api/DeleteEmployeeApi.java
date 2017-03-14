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

@Api(value = "DeleteEmployee", description = "the DeleteEmployee API")
public interface DeleteEmployeeApi {

    @ApiOperation(value = "Returns a boolean of delete operation result", notes = "An endpoint that returns a deletes employee", response = Boolean.class, tags={ "DeleteEmployee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Return true if deleted false otherwise", response = Boolean.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Boolean.class) })
    @RequestMapping(value = "/DeleteEmployee",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Boolean> deleteEmployeePost( @NotNull @ApiParam(value = "Email address of the employee", required = true) @RequestParam(value = "employeeemail", required = true) String employeeemail);

}
