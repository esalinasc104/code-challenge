package com.salinas.elias.codechallenge.repositories;

import com.salinas.elias.codechallenge.models.Employee;

import java.util.List;

/**
 * Repositorio de Empleados
 * Interfaz para la simulacion de un repositories. En un escenario real, esta interfaz deberia de heredar de
 * Jpa Repository o Mongo Repository el que corresponda
 */
public interface EmployeeRepository {
    public List<Employee> findAll();
}
