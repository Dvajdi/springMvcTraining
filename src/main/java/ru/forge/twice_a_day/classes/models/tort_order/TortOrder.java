package ru.forge.twice_a_day.classes.models.tort_order;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import ru.forge.twice_a_day.classes.models.client.Client;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tort_order")
public class TortOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


    @Column(name="order_date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private DateTime orderDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(DateTime orderDate) {
        this.orderDate = orderDate;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "TortOrder{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                '}';
    }
}
