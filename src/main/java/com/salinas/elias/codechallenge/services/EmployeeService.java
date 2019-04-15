package com.salinas.elias.codechallenge.services;

import com.salinas.elias.codechallenge.models.SchedulePoint;
import com.salinas.elias.codechallenge.models.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAllEmployees();
    public List<SchedulePoint> findEmployeesAvailable(int hourStart, int hourEnd, int flag, int cantEmpleados);
}
