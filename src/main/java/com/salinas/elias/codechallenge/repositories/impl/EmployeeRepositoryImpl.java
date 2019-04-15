package com.salinas.elias.codechallenge.repositories.impl;

import com.salinas.elias.codechallenge.models.Employee;
import com.salinas.elias.codechallenge.repositories.EmployeeRepository;
import com.salinas.elias.codechallenge.util.ConstantUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulacion de un repositories
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    List<Employee> employees = new ArrayList<>();

    public EmployeeRepositoryImpl() {
        Employee Kyle = new Employee();
        Kyle.setName("Kyle");
        Kyle.getMeetings().add(ConstantUtil.getDate(13, 30, 0));
        Kyle.getMeetings().add(ConstantUtil.getDate(14, 30, 0));
        Kyle.getMeetings().add(ConstantUtil.getDate(18, 0, 0));

        employees.add(Kyle);

        Employee paul = new Employee();
        paul.setName("Paul");
        paul.getMeetings().add(ConstantUtil.getDate(7, 0, 0));
        paul.getMeetings().add(ConstantUtil.getDate(9, 0, 0));
        paul.getMeetings().add(ConstantUtil.getDate(13, 30, 0));
        paul.getMeetings().add(ConstantUtil.getDate(15, 0, 0));
        paul.getMeetings().add(ConstantUtil.getDate(15, 30, 0));

        employees.add(paul);

        Employee alex = new Employee();
        alex.setName("Alex");
        alex.getMeetings().add(ConstantUtil.getDate(8, 0, 0));
        alex.getMeetings().add(ConstantUtil.getDate(9, 30, 0));
        alex.getMeetings().add(ConstantUtil.getDate(12, 30, 0));
        alex.getMeetings().add(ConstantUtil.getDate(15, 0, 0));

        employees.add(alex);

        Employee luis = new Employee();
        luis.setName("Luis");
        luis.getMeetings().add(ConstantUtil.getDate(9, 0, 0));
        luis.getMeetings().add(ConstantUtil.getDate(13, 30, 0));
        luis.getMeetings().add(ConstantUtil.getDate(15, 0, 0));
        luis.getMeetings().add(ConstantUtil.getDate(15, 30, 0));

        employees.add(luis);

        Employee jairo = new Employee();
        jairo.setName("Jairo");
        jairo.getMeetings().add(ConstantUtil.getDate(8, 0, 0));
        jairo.getMeetings().add(ConstantUtil.getDate(9, 0, 0));
        jairo.getMeetings().add(ConstantUtil.getDate(18, 0, 0));

        employees.add(jairo);

        Employee sonya = new Employee();
        sonya.setName("Sonya");
        sonya.getMeetings().add(ConstantUtil.getDate(8, 0, 0));
        sonya.getMeetings().add(ConstantUtil.getDate(12, 30, 0));
        sonya.getMeetings().add(ConstantUtil.getDate(13, 30, 0));
        sonya.getMeetings().add(ConstantUtil.getDate(15, 30, 0));

        employees.add(sonya);


    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }
}
