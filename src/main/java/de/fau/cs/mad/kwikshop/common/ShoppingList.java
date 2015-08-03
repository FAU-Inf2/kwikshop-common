package de.fau.cs.mad.kwikshop.common;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.*;

import de.fau.cs.mad.kwikshop.common.interfaces.DomainListObject;


//ORMLite annotations (android client)
@DatabaseTable(tableName = "shoppingList")
public class ShoppingList implements DomainListObject {

    /**
     * unique id generated by storage
     */
    //ORMLite
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int serverId;

    /**
     * not unique, can be set by user
     */
    //ORMLite
    @DatabaseField
    private String name;

    //ORMLite
    @DatabaseField
    private int sortTypeInt;

    /**
     * Date of an Event for Calendar Usage
     */
    //ORMLite
    @DatabaseField(foreign = true, canBeNull = true)
    private CalendarEventDate eventDate = new CalendarEventDate();

    /**
     * type: Account.id
     */
    @ForeignCollectionField
    private ForeignCollection<AccountID> sharedWith;

    //ORMLite
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Item> items;

    /**
     * last shopping location
     */
    //ORMLite
    @DatabaseField(foreign = true, canBeNull = true)
    private LastLocation location;

    //ORMLite
    @DatabaseField (canBeNull = true)
    private Date lastModifiedDate;

    @DatabaseField
    private int serverVersion;

    @DatabaseField
    private boolean modifiedSinceLastSync;


    public ShoppingList(int id) {
        this.id = id;
    }

    public ShoppingList() {
        // Default no-arg constructor for generating Items, required for ORMLite
    }


    public int getId() {
        return id;
    }


    public int getServerId() {
        return this.serverId;
    }

    public void setServerId(int value) {
        this.serverId = serverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LastLocation getLocation(){ return this.location;}

    public void setLocation(LastLocation location){this.location = location;}

    @Override
    public Date getLastModifiedDate() {
        return lastModifiedDate != null ? lastModifiedDate : new Date(0);
    }

    @Override
    public void setLastModifiedDate(Date value) {
        lastModifiedDate = value;
    }

    @Override
    public int getServerVersion() {
        return this.serverVersion;
    }

    public void setServerVersion(int value) {
        this.serverVersion = value;
    }

    public int getSortTypeInt(){
        return this.sortTypeInt;
    }

    public void setSortTypeInt(int sortTypeInt){
        this.sortTypeInt = sortTypeInt;
    }

    public CalendarEventDate getCalendarEventDate() {
        return eventDate;
    }

    public void setCalendarEventDate(CalendarEventDate eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public boolean getModifiedSinceLastSync() {
        return this.modifiedSinceLastSync;
    }

    @Override
    public void setModifiedSinceLastSync(boolean value) {
        this.modifiedSinceLastSync = value;
    }

    public Collection getSharedWith() {
        return sharedWith;
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
        Iterator<Item> iterator = items.iterator(); // TODO: again: I hope a normal Iterator instead of a ListIterator is fine for everyone

        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            if (currentItem.getId() == id) {
                items.remove(currentItem);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return items.size();
    }


}
