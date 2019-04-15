package com.salinas.elias.codechallenge.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * Modelo de datos usado para construir el horario de empleados disponibles
 */
public class SchedulePoint {
    @JsonFormat(locale = "es_SV", shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss",timezone = "America/El_Salvador")
    private Date time_point;
    private List<String> employees;

    public SchedulePoint() {
    }

    public SchedulePoint(Date time_point, List<String> employees) {
        this.time_point = time_point;
        this.employees = employees;
    }

    public Date getTime_point() {
        return time_point;
    }

    public void setTime_point(Date time_point) {
        this.time_point = time_point;
    }

    public List<String> getEmployees() {
        return employees;
    }

    public void setEmployees(List<String> employees) {
        this.employees = employees;
    }
}
