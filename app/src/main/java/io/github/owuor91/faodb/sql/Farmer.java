package io.github.owuor91.faodb.sql;

/**
 * Created by johnowuor on 19/03/2018.
 */

public class Farmer {
  private int id;
  private String name;
  private int age;
  private float acres;
  private String location;

  public Farmer() {
  }

  public Farmer(int id, String name, int age, float acres, String location) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.acres = acres;
    this.location = location;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public float getAcres() {
    return acres;
  }

  public void setAcres(float acres) {
    this.acres = acres;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
