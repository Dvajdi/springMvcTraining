package ru.forge.twice_a_day.classes.models.tort_order;


import lombok.Getter;
import lombok.Setter;
import ru.forge.twice_a_day.classes.models.client.Client;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tort_order")
public class TortOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Getter
    @Setter
    private Long id;

    @Column(name="ops")
    @Getter
    @Setter
    private String ops;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    @Getter
    @Setter
    private Client client;



    public TortOrder() {
    }

    public TortOrder(String ops) {
        this.ops = ops;
    }

    public TortOrder(String ops, Client client) {
        this.ops = ops;
        this.client = client;
    }





    @Override
    public String toString() {
        return "TortOrder{" +
                "id=" + id +
                ", ops='" + ops + '\'' +
                ", ";
    }
}
