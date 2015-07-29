package de.fau.cs.mad.kwikshop.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.*;

import de.fau.cs.mad.kwikshop.common.localization.ResourceId;
import de.fau.cs.mad.kwikshop.common.serialization.ResourceIdDeserializer;
import de.fau.cs.mad.kwikshop.common.serialization.ResourceIdSerializer;

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

  @Column
  @Enumerated(EnumType.STRING)
  @DatabaseField(dataType = DataType.ENUM_STRING)
  private ResourceId resourceId;


  @Column
  @Enumerated(EnumType.STRING)
  @DatabaseField(dataType = DataType.ENUM_STRING)
  private ResourceId shortNameResourceId;


  public Unit(){
      // Default no-arg constructor for generating Units, required for ORMLite
  }


  public Unit(String name, ResourceId resourceId) {
    this(name, resourceId, null);
  }

  public Unit(String name, ResourceId resourceId, ResourceId shortNameResourceId) {
    setName(name);
    setResourceId(resourceId);
    setShortNameResourceId(shortNameResourceId);
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



  @JsonProperty
  @JsonSerialize(using = ResourceIdSerializer.class)
  public ResourceId getResourceId() {
      return this.resourceId;
  }

  @JsonDeserialize(using = ResourceIdDeserializer.class)
  public void setResourceId(ResourceId value) {
    this.resourceId = value;
  }

  @JsonProperty
  @JsonSerialize(using = ResourceIdSerializer.class)
  public ResourceId getShortNameResourceId() {
    return this.shortNameResourceId;
  }

  @JsonDeserialize(using = ResourceIdDeserializer.class)
  public void setShortNameResourceId(ResourceId value) {
    this.shortNameResourceId = value;
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
