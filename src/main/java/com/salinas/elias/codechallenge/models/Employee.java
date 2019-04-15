package com.salinas.elias.codechallenge.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Modelo de datos que que representa la abstraccion de un Empleado
 */
public class Employee {
    String name;
    @JsonFormat(locale = "es_SV", shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss",timezone = "America/El_Salvador")
    List<Date> meetings;

    public Employee(){
        meetings= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Date> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Date> meetings) {
        this.meetings = meetings;
    }
}

