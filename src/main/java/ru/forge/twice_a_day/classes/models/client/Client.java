package ru.forge.twice_a_day.classes.models.client;


import ru.forge.twice_a_day.classes.models.tort_order.TortOrder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name= "client")
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="")
    private Long id;
    @Version
    @Column(name="version")
    private int version;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="address")
    private String address;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="mail_box")
    private String mailBox;
    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<TortOrder> tortOrders;

    public Client() {
    }

    public Client(int version, String firstName) {
        this.version = version;
        this.firstName = firstName;
    }

    public Client(int version, String firstName, String lastName, String address, String phoneNumber, String mailBox, String description) {
        this.version = version;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mailBox = mailBox;
        this.description = description;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMailBox() {
        return mailBox;
    }

    public void setMailBox(String mailBox) {
        this.mailBox = mailBox;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Transient
    String testNotNull(String str){
        if(str!=null){return str;}
        return "не указана";
    }

    @Override
    public String toString() {

        return "Client{" +
                "firstName='" + testNotNull(firstName) + '\'' +
                ", lastName='" + testNotNull(lastName) + '\'' +
                ", address='" + testNotNull(address) + '\'' +
                ", phoneNumber='" + testNotNull(phoneNumber) + '\'' +
                ", mailBox='" + testNotNull(mailBox) + '\'' +
                ", description='" + testNotNull(description) + '\'' +
                '}';
    }
}
