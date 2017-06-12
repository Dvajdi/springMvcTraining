package ru.forge.twice_a_day.classes.models.tort;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tort")
public class Tort implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
    @Version
    @Column(name="version")
  int version;
    @Column(name="name")
  String Name;
    @Column(name = "description")
  String Description;

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

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public String getDescription() {
    return Description;
  }

  public void setDescription(String description) {
    Description = description;
  }

  @Override
  public String toString() {
    return "Tort{" +
      "id=" + id +
      ", version=" + version +
      ", Name='" + Name + '\'' +
      ", Description='" + Description + '\'' +
      '}';
  }
}
