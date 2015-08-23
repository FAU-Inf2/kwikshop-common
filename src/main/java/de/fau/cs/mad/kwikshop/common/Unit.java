package de.fau.cs.mad.kwikshop.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.*;

import de.fau.cs.mad.kwikshop.common.interfaces.DomainObject;
import de.fau.cs.mad.kwikshop.common.localization.ResourceId;
import de.fau.cs.mad.kwikshop.common.serialization.ResourceIdDeserializer;
import de.fau.cs.mad.kwikshop.common.serialization.ResourceIdSerializer;
import de.fau.cs.mad.kwikshop.common.util.NamedQueryConstants;

//Hibernate
@Entity(name = "Unit")
@NamedQueries({
        @NamedQuery(
                name = NamedQueryConstants.UNIT_GET_BY_ID,
                query = "SELECT u FROM Unit u WHERE u.ownerId = :" + NamedQueryConstants.USER_ID +
                        " AND u.serverId = :" + NamedQueryConstants.UNIT_ID
        )
})
//ORMLite
@DatabaseTable(tableName = "unit")
public class Unit implements DomainObject{

  //Hibernate: ignore client id
  @Transient
  //ORMLite
  @DatabaseField(generatedId = true)
  private int id;


  //Hibernate
  @Id
  @GeneratedValue
  @Column(name = "id")
  //ORMLite
  @DatabaseField
  private int serverId;

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

  //@Column(name="ownerId")
  private String ownerId;

  //Hibernate
  @Column(name = "predefinedId")
  //ORMLite
  @DatabaseField(columnName = "predefinedId")
  private int predefinedId;



  public Unit(){
      // Default no-arg constructor for generating Units, required for ORMLite
  }


  public Unit(String name, ResourceId resourceId, PredefinedId predefinedId) {
    this(name, resourceId, null, predefinedId);
  }

  public Unit(String name, ResourceId resourceId, ResourceId shortNameResourceId, PredefinedId predefinedId) {
    setName(name);
    setResourceId(resourceId);
    setShortNameResourceId(shortNameResourceId);
    setPredefinedId(predefinedId.toInt());
  }

  @JsonIgnore
  @Override
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  @JsonProperty
  public int getPredefinedId() {
    return this.predefinedId;
  }

  public void setPredefinedId(int value) {
    this.predefinedId = value;
  }

  @JsonProperty("id")
  public int getServerId() {
    return this.serverId;
  }

  @JsonProperty("id")
  public void setServerId(int value) {
    this.serverId = value;
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


  @JsonIgnore
  public String getOwnerId() {
    return this.ownerId;
  }

  @JsonIgnore
  public void setOwnerId(String value) {
    this.ownerId = value;
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

    if(other == null) {
      return false;
    }

    //TODO: Figure out how this can work on server
    return other.getId() == this.getId() && other.getName().equals(this.getName());
  }


}
