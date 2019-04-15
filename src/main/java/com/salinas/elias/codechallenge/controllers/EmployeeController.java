package com.salinas.elias.codechallenge.controllers;

import com.salinas.elias.codechallenge.models.SchedulePoint;
import com.salinas.elias.codechallenge.models.Employee;
import com.salinas.elias.codechallenge.services.EmployeeService;
import com.salinas.elias.codechallenge.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    public EmployeeController() {

    }

    @GetMapping("")
    public List<Employee> getAllMeeting() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/schedule/{hora_inicio}/{hora_fin}/{flag}/{cant_empleados}")
    public HashMap filteredMeeting(
            @PathVariable("hora_inicio") int hora_inicio,
            @PathVariable("hora_fin") int hora_fin,
            @PathVariable("flag") int flag,
            @PathVariable("cant_empleados") int cant_empleados
    ) {
        HashMap<String, Object> map = new HashMap();
        try {
            map.put(ConstantUtil.CODE_KEY, ConstantUtil.CODE_VALUE_SUCCESS);
            map.put(ConstantUtil.MESSAGE_KEY, ConstantUtil.MESSAGE_VALUE_SUCCESS);
            map.put(ConstantUtil.RESPONSE_KEY, employeeService.findEmployeesAvailable(hora_inicio, hora_fin, flag, cant_empleados));
        } catch (Exception e) {
            map.put(ConstantUtil.CODE_KEY, ConstantUtil.CODE_VALUE_ERROR);
            map.put(ConstantUtil.MESSAGE_KEY, ConstantUtil.MESSAGE_VALUE_ERROR);
            map.put(ConstantUtil.RESPONSE_KEY, null);
        }
        return map;
    }
}
