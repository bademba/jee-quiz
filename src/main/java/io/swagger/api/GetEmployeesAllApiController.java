package io.swagger.api;

import com.safinterview.database.crud.employee.EmployeeTransactions;
import com.safinterview.database.models.employee.EmployeeInfo;
import io.swagger.model.Employee;
import io.swagger.model.Error;

import io.swagger.annotations.*;

import org.json.simple.JSONArray;
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
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-14T15:48:44.629Z")

@Controller
public class GetEmployeesAllApiController implements GetEmployeesAllApi {


    public ResponseEntity<List<Employee>> getEmployeesAllGet() {
        EmployeeTransactions employeeTransactions = new EmployeeTransactions();
        List<EmployeeInfo> employeeInfos = new ArrayList<>();
        try {
            employeeInfos = employeeTransactions.getEmployeeInfoAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray = new JSONArray();
        int i = 0;
        for (EmployeeInfo employee : employeeInfos) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("employeename", employee.getEmployeeName());
            jsonObject.put("emailaddress", employee.getEmailAddress());
            jsonObject.put("department", employee.getDepartment());
            jsonObject.put("age", employee.getAge());
            jsonObject.put("reportingdate", employee.getReportingDate());
            jsonArray.add(i, jsonObject);
            i++;
        }

        return new ResponseEntity<List<Employee>>(jsonArray, HttpStatus.OK);
    }

}
