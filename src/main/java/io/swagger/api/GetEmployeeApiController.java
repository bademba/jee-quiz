package io.swagger.api;

import com.fasterxml.jackson.databind.util.JSONPObject;
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


import java.util.List;

import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-14T15:48:44.629Z")

@Controller
public class GetEmployeeApiController implements GetEmployeeApi {


    public ResponseEntity<Object> getEmployeeGet(@NotNull @ApiParam(value = "Email address of the employee", required = true) @RequestParam(value = "employeeemail", required = true) String employeeemail) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("employeeemail", employeeemail);
        return new ResponseEntity<Object>(jsonObject, HttpStatus.OK);
    }

}
