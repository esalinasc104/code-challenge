package com.salinas.elias.codechallenge.services.impl;

import com.salinas.elias.codechallenge.models.SchedulePoint;
import com.salinas.elias.codechallenge.models.Employee;
import com.salinas.elias.codechallenge.repositories.EmployeeRepository;
import com.salinas.elias.codechallenge.services.EmployeeService;
import com.salinas.elias.codechallenge.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Servicio para Empleados / Employees
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Value("${launch.begin}")
    Integer launch_begin;

    @Value("${launch.duration}")
    Integer launch_duration;


    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * Consultar todos los empleados
     *
     * @return regresa un listado de empleados con su nombre y reuniones programadas
     */
    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Consulta y ordena los empleados en un horario de acuerdo a su disponibilidad
     *
     * @param hourStart entero que indica la hora de inicio desde la que se desea construir el horario
     * @param hourEnd   entero que indica la hora hasta la que se quiere que se orden el horario
     * @param flag      entero que le indica al proceso si debe o no, considerar la horar de almuerzo: 0 - No considerar, 1: considerar
     * @param cantEmpleados cantidad de empleados limite para considerar "Disponible" un punto de agenda
     * @return regresa un listado de puntos de horario (Schedule Point) los cuales contienen los empleados disponibles para cada horario
     */
    @Override
    public List<SchedulePoint> findEmployeesAvailable(int hourStart, int hourEnd, int flag, int cantEmpleados) {
        List<SchedulePoint> reuniones = new ArrayList<>();
        Date horaEval = ConstantUtil.getDate(hourStart, 0, 0);
        Date horaInicioLaunch = ConstantUtil.getDate(launch_begin, 0, 0);
        Date finJornada = ConstantUtil.getDate(hourEnd, 0, 1);
        while (horaEval.before(finJornada)) {
            List<String> resultado = new ArrayList();

            //Recorremos todos los empleados
            for (Employee m : this.employeeRepository.findAll()) {
                Date finalHoraEval = horaEval;

                //Buscamos con lambda si el empleado tiene una reunion en la hora que el ciclo while va
                int cantidad = m.getMeetings().stream().filter(hora -> hora.compareTo(finalHoraEval) == 0).toArray().length;

                //Si la cantidad es cero, guardamos el nombre de la persona disponible
                if (cantidad == 0) {
                    resultado.add(m.getName());
                }
            }

            //Si la cantidad de empleados disponibles son mayor o igual a 3 guardamos este punto de agenda porque tiene empleados dispobles
            if (resultado.size() >= cantEmpleados)
                reuniones.add(new SchedulePoint(horaEval, resultado));

            horaEval = ConstantUtil.addMinutes(horaEval, 30);

            //Si la flag de considerar el almuerzo esta activa nos saltamos la cantidad de tiempo que dura el almuerzo
            if(flag==1 && horaEval.compareTo(horaInicioLaunch)==0){
                horaEval = ConstantUtil.addMinutes(horaEval, launch_duration);
            }
        }

        return reuniones;
    }
}
