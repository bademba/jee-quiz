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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-14T15:23:43.566Z")

@Api(value = "SetReportingDate", description = "the SetReportingDate API")
public interface SetReportingDateApi {

    @ApiOperation(value = "Updates the reporting date", notes = "Updates the reporting date of the employee ", response = String.class, tags={ "SetReportingDate", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "status", response = String.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
    @RequestMapping(value = "/SetReportingDate",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<String> setReportingDatePut( @NotNull @ApiParam(value = "Email address of the employee", required = true) @RequestParam(value = "employeeemail", required = true) String employeeemail,
         @NotNull @ApiParam(value = "The reporting days of the employee", required = true) @RequestParam(value = "days", required = true) String days);

}
