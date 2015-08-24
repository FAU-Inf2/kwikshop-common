package de.fau.cs.mad.kwikshop.common.sorting;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import de.fau.cs.mad.kwikshop.common.util.NamedQueryConstants;

@Entity
@NamedQueries({
        @NamedQuery(
                name = NamedQueryConstants.BOUGHTITEM_GET_BY_NAME,
                query = "SELECT i FROM BoughtItem i WHERE i.name = :" + NamedQueryConstants.BOUGHTITEM_NAME
        )
})
public class BoughtItem {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="name", unique=true, nullable=false)
    private String name;

    public BoughtItem() {

    }

    public BoughtItem(String name) {
        setName(name);
    }

    @JsonIgnore
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

}
