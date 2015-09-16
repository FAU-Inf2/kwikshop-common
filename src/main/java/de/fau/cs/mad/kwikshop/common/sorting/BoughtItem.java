package de.fau.cs.mad.kwikshop.common.sorting;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

import javax.persistence.*;

import de.fau.cs.mad.kwikshop.common.util.NamedQueryConstants;

//Hibernate annotations (server side)
@Entity
@NamedQueries({
        @NamedQuery(
                name = NamedQueryConstants.BOUGHTITEM_GET_BY_NAME,
                query = "SELECT i FROM BoughtItem i WHERE i.name = :" + NamedQueryConstants.BOUGHTITEM_NAME
        )
})
//ORMLite annotations (android client)
@DatabaseTable(tableName = "boughtItem")
public class BoughtItem implements Comparable<BoughtItem> {

    //Hibernate
    @Id
    @GeneratedValue
    //ORMLite
    @DatabaseField(generatedId = true)
    private int id;

    //Hibernate
    @Column(name="name", unique=true, nullable=false)
    //ORMLite
    @DatabaseField
    private String name;

    //Hibernate
    @Transient
    //ORMLite
    @DatabaseField
    private String supermarketPlaceId;

    //Hibernate
    @Transient
    //ORMLite
    @DatabaseField
    private String supermarketName;

    //Hibernate
    @Transient
    //ORMLite
    @DatabaseField
    private int itemId;

    //Hibernate
    @Transient
    //ORMLite
    @DatabaseField
    private int shoppingListId;

    //Hibernate
    @Transient
    //ORMLite
    @DatabaseField
    private Date date;

    //Hibernate
    @Transient
    //ORMLite
    @DatabaseField
    private boolean sync = false;

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

    @JsonIgnore
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @JsonIgnore
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JsonIgnore
    public int getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(int shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    @JsonIgnore
    public boolean isSync() {
        return sync;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
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

    @Override
    public int compareTo(BoughtItem boughtItem) {
        return this.getDate().compareTo(boughtItem.getDate());
    }
}
