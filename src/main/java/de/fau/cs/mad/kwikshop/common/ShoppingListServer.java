package de.fau.cs.mad.kwikshop.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.*;

import de.fau.cs.mad.kwikshop.common.interfaces.DomainListObjectServer;
import de.fau.cs.mad.kwikshop.common.serialization.DateDeserializer;
import de.fau.cs.mad.kwikshop.common.serialization.DateSerializer;
import de.fau.cs.mad.kwikshop.common.util.NamedQueryConstants;

import javax.persistence.*;

//Hibernate annotations (server side)
@Entity
@NamedQueries({
        @NamedQuery(
                name = NamedQueryConstants.SHOPPINGLIST_GET_ALL_FOR_USER,
                query = "SELECT s FROM ShoppingListServer s WHERE s.ownerId = :" + NamedQueryConstants.USER_ID +
                        " AND s.deleted = false"
        ),
        @NamedQuery(
                name = NamedQueryConstants.SHOPPINGLIST_GET_BY_LISTID,
                query = "SELECT s FROM ShoppingListServer s WHERE s.ownerId = :" + NamedQueryConstants.USER_ID  +
                        " AND s.id = :" + NamedQueryConstants.LIST_ID +
                        " AND s.deleted = false"
        ),
        @NamedQuery(
                name = NamedQueryConstants.SHOPPINGLIST_GET_DELETED_LISTS,
                query = "SELECT s FROM ShoppingListServer s WHERE s.ownerId = :" + NamedQueryConstants.USER_ID +
                        " AND s.deleted = true"
        ),
        @NamedQuery(
                name = NamedQueryConstants.SHOPPINGLIST_GET_BY_SHARINGCODE,
                query = "SELECT s FROM ShoppingListServer s WHERE s.sharingCode = :" + NamedQueryConstants.SHARING_CODE  +
                        " AND s.deleted = false"
        ),
})
public class ShoppingListServer implements DomainListObjectServer {

    /**
     * unique id generated by storage
     */
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    /**
     * not unique, can be set by user
     */
    @Column(name = "name")
    private String name;

    @Column(name = "sortTypeInt")
    private int sortTypeInt;




    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    private Collection<Item> items;

    /**
     * last shopping location
     */
    @ManyToOne
    @JoinColumn(name = "locationId")
    private LastLocation location;

    //Hibernate
    @Column(name ="lastModifiedDate")
    private Date lastModifiedDate;

    /**
     * Id of the user that owns this list (server side)
     */
    @Column(name = "ownerId")
    private String ownerId;

    @Column(name = "version")
    private int version;


    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "sharingCode")
    private String sharingCode;

    @Column(name = "predefinedId")
    private int predefinedId;

    @Column(name = "leaseId")
    private int leaseId;



    public ShoppingListServer(int id) {
        this.id = id;
    }

    public ShoppingListServer(int id, Collection<Item> items) {
        this.id = id;
        this.items = items;
    }


    public ShoppingListServer() {
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
    public LastLocation getLocation(){ return this.location;}

    public void setLocation(LastLocation location){this.location = location;}

    @Override
    @JsonProperty
    @JsonSerialize(using = DateSerializer.class)
    public Date getLastModifiedDate() {
        return lastModifiedDate != null ? lastModifiedDate : new Date(0);
    }

    @Override
    @JsonDeserialize(using = DateDeserializer.class)
    public void setLastModifiedDate(Date value) {
        lastModifiedDate = value;
    }

    @JsonIgnore
    public int getSortTypeInt(){
        return this.sortTypeInt;
    }

    public void setSortTypeInt(int sortTypeInt){
        this.sortTypeInt = sortTypeInt;
    }

    @JsonIgnore
    public Collection<Item> getItems() {
        if(this.items == null) {
            return Collections.unmodifiableCollection(new ArrayList<Item>());
        } else {
            return Collections.unmodifiableCollection(this.items);
        }
    }

    @JsonProperty
    @Override
    public int getVersion() {
        return this.version;
    }

    @Override
    public void setVersion(int value) {
        this.version = value;
    }

    @JsonIgnore
    public boolean getDeleted() {
       return this.deleted;
    }

    @Override
    public void setDeleted(boolean value) {
       this.deleted = value;
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

    @JsonProperty
    @Override
    public int getPredefinedId() {
        return this.predefinedId;
    }

    public void setPredefinedId(int value) {
        this.predefinedId = value;
    }


    @Override
    @JsonIgnore
    public int getLeaseId() {
        return this.leaseId;
    }

    @Override
    @JsonIgnore
    public void setLeaseId(int value) {
        this.leaseId = value;
    }



    @Override
    public void setOwnerId(String value) {
        this.ownerId = value;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public boolean removeItem(int id) {
        Iterator<Item> iterator = items.iterator(); // TODO: again: I hope a normal Iterator instead of a ListIterator is fine for everyone

        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            if (currentItem.getServerId() == id) {
                items.remove(currentItem);
                return true;
            }
        }
        return false;
    }

    @JsonIgnore
    public String getSharingCode() {
        if(sharingCode == null)
            sharingCode = UUID.randomUUID().toString();

        return sharingCode;
    }

    @ManyToMany(
            targetEntity=User.class,
            cascade={CascadeType.ALL}
    )
    private Set<User> sharedWith = new HashSet<User>();

    @JsonIgnore
    public Collection getSharedWith() {
        return sharedWith;
    }

    public void shareWith(User user) {
        sharedWith.add(user);
    }

    public int size() {
        return items.size();
    }


}
