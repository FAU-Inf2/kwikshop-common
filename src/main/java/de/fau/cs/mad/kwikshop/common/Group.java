package de.fau.cs.mad.kwikshop.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.Entity;

@Entity
@DatabaseTable(tableName = "group")
public class Group {

  @DatabaseField(generatedId = true)
  private int id;

  @DatabaseField(canBeNull = false)
  private String name;

  @DatabaseField(canBeNull = true)
  private String displayNameResourceName;


  public Group() {
      // Default no-arg constructor for generating Groups, required for ORMLite
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
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonIgnore
  public String getDisplayNameResourceName() {
    return displayNameResourceName;
  }

  @JsonIgnore
  public void setDisplayNameResourceName(String value) {
    this.displayNameResourceName = value;
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
