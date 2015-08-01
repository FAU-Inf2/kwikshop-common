package de.fau.cs.mad.kwikshop.common;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.*;

import de.fau.cs.mad.kwikshop.common.interfaces.DomainListObject;



//ORMLite
@DatabaseTable (tableName = "recipe")
public class Recipe implements DomainListObject {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int serverId;

    @DatabaseField
    private String name;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<Item> items;

    @DatabaseField
    private int scaleFactor = 1;

    @DatabaseField
    private String scaleName;

    @DatabaseField (canBeNull = true)
    private Date lastModifiedDate;


    public Recipe(int id) {
        this.id = id;
    }

    public Recipe() {
        // Default no-arg constructor for generating Items, required for ORMLite

    }


    public int getId() {
        return id;
    }

    public int getServerId() {
        return this.serverId;
    }

    public void setServerId(int value) {
        this.serverId = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScaleFactor(){ return scaleFactor; }

    public void setScaleFactor(int scaleFactor){
        this.scaleFactor = scaleFactor;
    }

    public String getScaleName(){
        return scaleName;
    }

    public void setScaleName( String scaleName){
        this.scaleName = scaleName;
    }

    @Override
    public Date getLastModifiedDate() {
        return lastModifiedDate != null ? lastModifiedDate : new Date(0);
    }

    @Override
    public void setLastModifiedDate(Date value) {
        lastModifiedDate = value;
    }

    public Collection<Item> getItems() {

        if(this.items == null) {
            return Collections.unmodifiableCollection(new ArrayList<Item>());
        } else {
            return Collections.unmodifiableCollection(this.items);
        }

    }

    @Override
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
