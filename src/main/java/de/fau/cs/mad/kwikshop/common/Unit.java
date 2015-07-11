package de.fau.cs.mad.kwikshop.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.*;

//Hibernate
@Entity(name = "Unit")
//ORMLite
@DatabaseTable(tableName = "unit")
public class Unit {

  //Hibernate
  @Id
  @GeneratedValue
  @Column(name = "id")
  //ORMLite
  @DatabaseField(generatedId = true)
  private int id;

  /**
   * Language-neutral name of the unit (= english)
   */
  //Hibernate
  @Column(name = "name", nullable = false)
  //ORMLite
  @DatabaseField(canBeNull = false)
  private String name;

  /**
   * The name of the string resource for the localized name of the unit
   */
  //Hibernate : currently not mapped => localization of items needs to be refactored first so it supports both server and client
  //ORMLite
  @DatabaseField(canBeNull = true)
  private String displayNameResourceName;

  /**
   * The name of the string resource for the localized short name of the unit
   */
  //Hibernate : currently not mapped => localization of items needs to be refactored first so it supports both server and client
  //ORMLite
  @DatabaseField(canBeNull = true)
  private String shortDisplayNameResourceName;


  public Unit(){
      // Default no-arg constructor for generating Units, required for ORMLite
  }


  @JsonProperty
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @JsonProperty
  public String getName() {
    return this.name;
  }

  public void setName(String value) {
    this.name = value;
  }

  @JsonIgnore
  public String getDisplayNameResourceName() {
    return displayNameResourceName;
  }

  public void setDisplayNameResourceName(String value) {
    this.displayNameResourceName = value;
  }

  @JsonIgnore
  public String getShortDisplayNameResourceName() {
    return shortDisplayNameResourceName;
  }

  public void setShortDisplayNameResourceName(String value) {
    this.shortDisplayNameResourceName = value;
  }


  @Override
  public int hashCode() {
    return id;
  }

  @Override
  public boolean equals(Object other) {

    if (other == null) {
      return false;
    }

    if (!(other instanceof Unit)) {
      return false;
    }

    return equals((Unit) other);

  }

  public boolean equals(Unit other) {
    return other.getId() == this.getId() && other.getName().equals(this.getName());
  }


}
