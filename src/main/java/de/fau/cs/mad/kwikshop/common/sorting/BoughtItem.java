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

    @Transient
    private String supermarketPlaceId;

    @Transient
    private String supermarketName;

    public BoughtItem() {

    }

    public BoughtItem(String name) {
        this.name = name;
    }

    public BoughtItem(String name, String supermarketPlaceId, String supermarketName) {
        this.name = name;
        this.supermarketPlaceId = supermarketPlaceId;
        this.supermarketName = supermarketName;
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

    @JsonProperty
    public String getSupermarketName() {
        return supermarketName;
    }

    public void setSupermarketName(String supermarketName) {
        this.supermarketName = supermarketName;
    }

    @JsonProperty
    public String getSupermarketPlaceId() {
        return supermarketPlaceId;
    }

    public void setSupermarketPlaceId(String supermarketPlaceId) {
        this.supermarketPlaceId = supermarketPlaceId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;

        BoughtItem boughtItem = (BoughtItem) obj;
        return boughtItem.getName().equals(this.getName());

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
