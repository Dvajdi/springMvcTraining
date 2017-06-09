package ru.forge.twice_a_day.classes.models.cat;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by twice on 09.06.17.
 */
@Entity
@Table(name="cats")
public class Cat implements Serializable {
    private Long id;
    private String name;

    @Id
    @Column(name="name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
