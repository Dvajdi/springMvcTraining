package ru.forge.twice_a_day.classes.models.order;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="order")
public class Order implements Serializable {
private Long id;
private String someString;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="some_string")
    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", someString='" + someString + '\'' +
                '}';
    }
}
