package de.fau.cs.mad.kwikshop.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import de.fau.cs.mad.kwikshop.common.localization.ResourceId;
import de.fau.cs.mad.kwikshop.common.serialization.ResourceIdDeserializer;
import de.fau.cs.mad.kwikshop.common.serialization.ResourceIdSerializer;
import de.fau.cs.mad.kwikshop.common.util.NamedQueryConstants;

import javax.persistence.*;


//Hibernate
@Entity(name = "Group")
@Table(name = "productGroup")
@NamedQueries({
        @NamedQuery(
                name = NamedQueryConstants.GROUP_GET_BY_ID,
                query = "SELECT g FROM Group g WHERE g.ownerId = :" + NamedQueryConstants.USER_ID +
                        " AND g.serverId = :" + NamedQueryConstants.GROUP_ID
        )
})
//ORMLite
@DatabaseTable(tableName = "group")
public class Group {

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

  //Hibernate
  @Column(name = "name")
  //ORMLite
  @DatabaseField(canBeNull = false)
  private String name;

  @Column
  @Enumerated(EnumType.STRING)
  @DatabaseField(dataType = DataType.ENUM_STRING)
  private ResourceId resourceId;

  @Column(name="ownerId")
  private String ownerId;


  public Group() {
      // Default no-arg constructor for generating Groups, required for ORMLite
  }

  public Group(String name, ResourceId resourceId) {
    setName(name);
    setResourceId(resourceId);
  }


  @JsonIgnore
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
    return getName().hashCode();
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }

    if (other instanceof Group) {
      return equals((Group) other);
    } else {
      return false;
    }
  }

  public boolean equals(Group other) {
    if (other == null) {
      return false;
    }

    //TODO: How can this work on server?
    return other.getId() == this.getId() && other.getName().equals(this.getName());
  }

  @Override
  public String toString() {
    if (name == null) {
      return "null";
    }
    return name.toString();
  }

}
