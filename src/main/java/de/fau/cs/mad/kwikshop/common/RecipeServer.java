package de.fau.cs.mad.kwikshop.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import de.fau.cs.mad.kwikshop.common.interfaces.DomainListObject;

import javax.persistence.*;
import java.util.*;


//Hibernate
@Entity(name ="Recipe")
public class RecipeServer implements DomainListObject {

    //Hibernate
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    //Hibernate
    @Column(name = "name")
    private String name;

    //Hibernate
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    private Collection<Item> items;

    //Hibernate
    @Column(name = "scaleFactor")
    private int scaleFactor = 1;

    //Hibernate
    @Column(name = "scaleName")
    private String scaleName;

    //Hibernate
    @Column(name = "lastModifiedDate")
    private Date lastModifiedDate;

    /**
     * Id of the user that owns this list (server side)
     */
    //Hibernate
    @ManyToOne
    @JoinColumn(name="userId")
    private User owner;


    public RecipeServer(int id) {
        this.id = id;
    }

    public RecipeServer() {
        // Default no-arg constructor for generating Items, required for ORMLite

    }


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
    public Collection<Item> getItems() {

        if(this.items == null) {
            return Collections.unmodifiableCollection(new ArrayList<Item>());
        } else {
            return Collections.unmodifiableCollection(this.items);
        }

    }

    @JsonIgnore
    public Item getItem(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        //TODO: returning null is a bad idea
        return null;
    }


    public void addItem(Item item) {
        this.items.add(item);
    }

    public boolean removeItem(int id) {
        Iterator<Item> iterator = items.iterator();

        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            if (currentItem.getId() == id) {
                items.remove(currentItem);
                return true;
            }
        }
        return false;
    }

    public boolean removeItem(Item item) {
        return removeItem(item.getId());
    }

    public int size() {
        return items.size();
    }


}
