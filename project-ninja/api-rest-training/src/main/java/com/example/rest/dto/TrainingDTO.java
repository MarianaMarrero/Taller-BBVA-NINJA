package com.example.rest.dto;

import java.io.Serializable;

public class TrainingDTO implements Serializable {

    private Long id;
    private String name;
    private String program;
    private Long points;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(final String program) {
        this.program = program;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(final Long points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "TrainingDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", program='" + program + '\'' +
                ", points=" + points +
                '}';
    }
}
