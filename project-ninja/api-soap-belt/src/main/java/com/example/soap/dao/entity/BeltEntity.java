package com.example.soap.dao.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name= "belt")
public class BeltEntity  implements Serializable{

    @Id
    @GeneratedValue(generator = "points_generator")
    @SequenceGenerator(name = "points_generator")
    @Column (nullable = false)
    private Long id;

    @Column(name= "name", length = 100)
    private String name;


    @Column(name= "points")
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

    public Long getPoints() {
        return points;
    }

    public void setPoints(final Long points) {
        this.points = points;
    }
}
