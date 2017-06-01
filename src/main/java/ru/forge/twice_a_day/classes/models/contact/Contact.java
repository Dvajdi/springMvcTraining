package ru.forge.twice_a_day.classes.models.contact;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.beans.*;
import java.io.Serializable;

@Entity
@Table(name="contact")
public class Contact implements Serializable{
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private DateTime birthDate;
    private String description;
    private byte [] photo;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Version
    @Column(name="version")
    public int getVersion() {
        return version;
    }

    @NotEmpty(message = "{validation.firstname.NotEmpty.message}")
    @Size(min=3,max=45, message="{validation.firstname.Size.message}")
    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "BIRTH_DATE")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    public DateTime getBirthDate() {
        return birthDate;
    }

    @javax.persistence.Transient
    public String getBirthDateString() {
        String birthDateString = "";
        if (birthDate != null)
            birthDateString = org.joda.time.format.DateTimeFormat
                    .forPattern("yyyy-MM-dd").print(birthDate);
        return birthDateString;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    @Column(name="photo")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    public byte[] getPhoto() {
        return photo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
