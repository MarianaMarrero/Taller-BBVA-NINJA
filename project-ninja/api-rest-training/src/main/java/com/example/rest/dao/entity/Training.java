package com.example.rest.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="training")
public class Training implements Serializable {

    @Id
    @GeneratedValue(generator = "training_generator")
    @SequenceGenerator(name = "training_generator")
    @Column (nullable = false)
    private Long id;

    @Column(name= "name", length = 100)
    private String name;

    @Column(name = "program", length = 100)
    private String program;

    @Column(name = "points")
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
}
