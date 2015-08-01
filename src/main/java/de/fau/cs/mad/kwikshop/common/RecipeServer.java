package de.fau.cs.mad.kwikshop.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import de.fau.cs.mad.kwikshop.common.interfaces.DomainListObject;
import de.fau.cs.mad.kwikshop.common.interfaces.DomainListObjectServer;
import de.fau.cs.mad.kwikshop.common.util.NamedQueryConstants;

import javax.persistence.*;
import java.util.*;


@Entity
@NamedQueries({
        @NamedQuery(
                name = NamedQueryConstants.RECIPE_GET_ALL_FOR_USER,
                query = "SELECT r FROM RecipeServer r WHERE r.ownerId = :" + NamedQueryConstants.USER_ID +
                        " AND r.deleted = false"
        ),
        @NamedQuery(
                name = NamedQueryConstants.RECIPE_GET_BY_LISTID,
                query = "SELECT r FROM RecipeServer r WHERE r.ownerId = :" + NamedQueryConstants.USER_ID  +
                        " AND r.id = :" + NamedQueryConstants.LIST_ID +
                        " AND r.deleted = false"
        ),
        @NamedQuery(
                name = NamedQueryConstants.RECIPE_GET_DELETED_LISTS,
                query = "SELECT r FROM RecipeServer r WHERE r.ownerId = :" + NamedQueryConstants.USER_ID +
                        " AND r.deleted = true"
        )
})
public class RecipeServer implements DomainListObjectServer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    private Collection<Item> items;

    @Column(name = "scaleFactor")
    private int scaleFactor = 1;

    @Column(name = "scaleName")
    private String scaleName;

    @Column(name = "lastModifiedDate")
    private Date lastModifiedDate;

    /**
     * Id of the user that owns this list (server side)
     */
    @Column(name="ownerId")
    private String ownerId;

    @Column(name = "version")
    private int version;

    @Column(name = "deleted")
    private boolean deleted;

    public RecipeServer(int id) {
        this.id = id;
    }

    public RecipeServer() {
        // Default no-arg constructor for generating Items, required for ORMLite

    }


    @Override
    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public int getScaleFactor(){ return scaleFactor; }

    public void setScaleFactor(int scaleFactor){
        this.scaleFactor = scaleFactor;
    }

    @JsonProperty
    public String getScaleName(){
        return scaleName;
    }

    public void setScaleName( String scaleName){
        this.scaleName = scaleName;
    }

    @JsonProperty
    @Override
    public Date getLastModifiedDate() {
        return lastModifiedDate != null ? lastModifiedDate : new Date(0);
    }

    @Override
    public void setLastModifiedDate(Date value) {
        lastModifiedDate = value;
    }


    @JsonProperty
    public int getVersion() {
        return this.version;
    }

    public void setVersion(int value) {
        this.version = value;
    }

    @JsonIgnore
    @Override
    public boolean getDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(boolean value) {
        this.deleted = value;
    }


    @JsonProperty
    public Collection<Item> getItems() {

        if(this.items == null) {
            return Collections.unmodifiableCollection(new ArrayList<Item>());
        } else {
            return Collections.unmodifiableCollection(this.items);
        }

    }

    @Override
    @JsonIgnore
    public Item getItem(int id) {
        for (Item item : items) {
            if (item.getServerId() == id) {
                return item;
            }
        }
        //TODO: returning null is a bad idea
        return null;
    }

    @Override
    @JsonProperty
    public String getOwnerId() {
        return this.ownerId;
    }

    @Override
    public void setOwnerId(String value) {
        this.ownerId = value;
    }


    public void addItem(Item item) {
        this.items.add(item);
    }

    public boolean removeItem(int id) {
        Iterator<Item> iterator = items.iterator();

        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            if (currentItem.getServerId() == id) {
                items.remove(currentItem);
                return true;
            }
        }
        return false;
    }

    public boolean removeItem(Item item) {
        return removeItem(item.getServerId());
    }

    public int size() {
        return items.size();
    }


}
