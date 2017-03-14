package io.swagger.api;

import com.safinterview.database.crud.employee.EmployeeTransactions;
import com.safinterview.database.models.employee.EmployeeInfo;
import com.safinterview.date.CalendarUtils;
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

import java.net.ConnectException;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-14T15:48:44.629Z")

@Controller
public class SetReportingDateApiController implements SetReportingDateApi {


    public ResponseEntity<String> setReportingDatePut(@NotNull @ApiParam(value = "Email address of the employee", required = true) @RequestParam(value = "employeeemail", required = true) String employeeemail,
                                                      @NotNull @ApiParam(value = "The reporting days of the employee", required = true) @RequestParam(value = "days", required = true) String days) {

        int updated = 0;
        EmployeeTransactions employeeTransactions = new EmployeeTransactions();
        try {
            List<EmployeeInfo> employeeInfos = employeeTransactions.getEmployeeInfoAll();
            for (EmployeeInfo employeeInfo : employeeInfos) {
                if (employeeInfo.getEmailAddress().equals(employeeemail)) {

                    EmployeeInfo tmpEmployee = new EmployeeInfo(
                            employeeInfo.getEmployeeUuid(),
                            employeeInfo.getEmployeeName(),
                            employeeInfo.getEmailAddress(),
                            employeeInfo.getDepartment(),
                            employeeInfo.getReportingDate(),
                            employeeInfo.getAge()
                    );

                    if (tmpEmployee.getReportingDate().equals("20161115")) {
                        tmpEmployee.setReportingDate("20161117");
                        updated = employeeTransactions.update(employeeInfo,tmpEmployee);
                    } else {
                        String year = CalendarUtils.getFormattedDate("yyy", CalendarUtils.parseTime("yyy-MM-dd", employeeInfo.getReportingDate()));
                        String month = CalendarUtils.getFormattedDate("MM", CalendarUtils.parseTime("yyy-MM-dd", employeeInfo.getReportingDate()));
                        String date = CalendarUtils.getFormattedDate("dd", CalendarUtils.parseTime("yyy-MM-dd", employeeInfo.getReportingDate()));
                        int _date = Integer.parseInt(date);
                        _date = _date + Integer.parseInt(days);

                        String reportingDate = String.format(Locale.getDefault(), "%s%s%d", year, month, _date);
                        tmpEmployee.setReportingDate(reportingDate);
                        updated = employeeTransactions.update(employeeInfo,tmpEmployee);
                        System.out.println("Setting reporing date to "+reportingDate);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String response = "";
        if (updated == 1) {
            response = "Updated";
        } else {
            response = "Failed";
        }
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

}
