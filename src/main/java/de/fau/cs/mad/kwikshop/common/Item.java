package de.fau.cs.mad.kwikshop.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.*;

import java.util.Date;

import de.fau.cs.mad.kwikshop.common.interfaces.DomainObject;


//Hibernate annotations (server side)
@Entity(name = "Item")
//ORMLite annotations (android client)
@DatabaseTable(tableName = "item")
public class Item implements DomainObject, Comparable<Item> {

    public static final String FOREIGN_SHOPPINGLIST_FIELD_NAME = "shoppingList";/*///*/
    public static final String FOREIGN_RECIPE_FIELD_NAME = "recipe";


    //Hibernate: Ignore  client Id
    @Transient
    //ORMLite
    @DatabaseField(generatedId = true)
    private int id;

    @Id
    @GeneratedValue
    @Column(name = "id")
    //ORMLite
    @DatabaseField
    private int serverId;

    /**
     * Order of this Item in the ShoppingList
     */
    //Hibernate
    @Column(name="itemOrder")
    //ORMLite
    @DatabaseField
    private int order = Integer.MAX_VALUE;

    //Hibernate
    @Column(name="isBought")
    //ORMLite
    @DatabaseField
    private Boolean bought = false;

    //Hibernate
    @Column(name = "name")
    //ORMLite
    @DatabaseField(canBeNull = false)
    private String name = "";

    //Hibernate
    @Column(name = "amount")
    //ORMLite
    @DatabaseField
    private double amount = 1;

    //Hibernate
    @Column(name = "isHighlighted")
    //ORMLite
    @DatabaseField
    private Boolean highlight = false;

    //Hibernate
    @Column(name ="brand")
    //ORMLite
    @DatabaseField(canBeNull = true)
    private String brand;

    //Hibernate
    @Column(name="comment")
    //ORMLite
    @DatabaseField(canBeNull = true)
    private String comment;

    //Hibernate
    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(name = "groupId")
    //ORMLite
    @DatabaseField(foreign = true)
    private Group group;

    //Hibernate
    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(name = "unitId")
    //ORMLite
    @DatabaseField(foreign = true)
    private Unit unit;

    /**
     * The ShoppingList, that contains this Item.
     * (Required for ORMLite)
     */
    //Hibernate: not mapped
    @Transient
    //ORMLite
    @DatabaseField(foreign = true, columnName = FOREIGN_SHOPPINGLIST_FIELD_NAME)
    private ShoppingList shoppingList;

    /**
     * The Recipe, that contains this Item.
     * (Required for ORMLite)
     */
    //Hibernate: not mapped
    @Transient
    //ORMLite
    @DatabaseField(foreign = true, columnName = FOREIGN_RECIPE_FIELD_NAME)
    @SuppressWarnings("unused")
    private Recipe recipe;

    //Hibernate
    @Column(name = "lastBought")
    //ORMLite
    @DatabaseField(canBeNull = true)
    private Date lastBought;


    //Hibernate
    @Column(name = "repeatType")
    @Enumerated(EnumType.STRING)
    //ORMLite
    @DatabaseField(canBeNull = true) //TODO: do not allow null
    private RepeatType repeatType;

    //Hibernate
    @Column(name = "repeatScheduleType")
    @Enumerated(EnumType.STRING)
    //ORMLite
    @DatabaseField
    private TimePeriodsEnum periodType;

    //Hibernate
    @Column(name ="selectedRepeatTime")
    //ORMLite
    @DatabaseField
    private int selectedRepeatTime;

    //Hibernate
    @Column(name = "remindFromNextPurchaseOn")
    //ORMLite
    @DatabaseField
    private boolean remindFromNextPurchaseOn;

    //Hibernate
    @Column(name = "remindAtDate")
    //ORMLite
    @DatabaseField(canBeNull = true)
    private Date remindAtDate;

    //Hibernate
    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(name = "locationId")
    //ORMLite
    @DatabaseField(foreign = true, canBeNull = true)
    private LastLocation location;

    //Hibernate
    @Column(name = "imageItem")
    //ORMLite
    @DatabaseField(canBeNull = true)
    private String imageItem;

    //Hibernate
    @Column(name = "version")
    //ORMlite
    @DatabaseField
    private int version;

    //Indicates whether this item has been deleted
    @Column(name = "deleted")
    // Ignore on client
    private boolean deleted;

    //Hibernate: Ignore field, only relevant for client
    @Transient
    //ORMLite
    @DatabaseField
    private boolean modifiedSinceLastSync;

    //Hibernate
    @Column(name = "predefinedId")
    //ORMLite
    @DatabaseField(columnName = "predefinedId")
    private int predefinedId;

    public Item() {
        // Default no-arg constructor for generating Items, required for ORMLite
    }

    /**
     * Copies an other item. Most fields are copied, but not order, recipe, shoppingList, id and all repeat-related fields
     * @param item The item to copy
     */
    public Item(Item item) {
        this.amount = item.amount;
        this.name = item.name;
        this.highlight = item.highlight;
        this.brand = item.brand;
        this.comment = item.comment;
        this.group = item.group;
        this.unit = item.unit;
        this.location = item.location;
        this.imageItem = item.imageItem;
    }



    @JsonIgnore
    @Override
    public int getId() {
        return id;
    }

    @JsonProperty
    @Override
    public int getPredefinedId() {
        return this.predefinedId;
    }

    public void setPredefinedId(int value) {
        this.predefinedId = value;
    }

    // TODO: REMOVE THIS, only for testing. IDs should be read only
    public void setID(int id) {
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
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @JsonProperty
    public Boolean isBought() {
        return bought;
    }

    public void setBought(Boolean bought) {
        this.bought = bought;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @JsonProperty
    public Boolean isHighlight() {
        return highlight;
    }

    public void setHighlight(Boolean highlight) {
        this.highlight = highlight;
    }

    @JsonProperty
    public String getBrand() {
        return (brand == null ? "" : brand);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @JsonProperty
    public String getComment() {
        return (comment == null ? "" : comment);
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @JsonProperty
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @JsonProperty
    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @JsonProperty
    public Date getLastBought() {
        return lastBought;
    }

    public void setLastBought(Date lastBought) {
        this.lastBought = lastBought;
    }

    @JsonProperty
    public RepeatType getRepeatType() {
        return this.repeatType == null
                ? RepeatType.None
                : this.repeatType;
    }

    public void setRepeatType(RepeatType value) {
        this.repeatType = value;
    }

    @JsonProperty
    public TimePeriodsEnum getPeriodType() {
        return periodType;
    }

    public void setPeriodType(TimePeriodsEnum periodType) {
        this.periodType = periodType;
    }

    @JsonProperty
    public int getSelectedRepeatTime() {
        return selectedRepeatTime;
    }

    public void setSelectedRepeatTime(int selectedRepeatTime) {
        this.selectedRepeatTime = selectedRepeatTime;
    }

    @JsonProperty
    public Date getRemindAtDate() {
        return remindAtDate;
    }

    public void setRemindAtDate(Date remindAtDate) {
        this.remindAtDate = remindAtDate;
    }

    @JsonProperty
    public boolean isRemindFromNextPurchaseOn() {
        return remindFromNextPurchaseOn;
    }


    public void setRemindFromNextPurchaseOn(boolean remindFromNextPurchaseOn) {
        this.remindFromNextPurchaseOn = remindFromNextPurchaseOn;
    }

    @JsonProperty
    public boolean isRemindFromNowOn() {
        return !remindFromNextPurchaseOn;
    }

    public void setRemindFromNowOn(boolean remindFromNowOn) {
        this.remindFromNextPurchaseOn = !remindFromNowOn;
    }

    @JsonProperty
    public LastLocation getLocation() {
        return location;
    }

    public void setLocation(LastLocation location) {
        this.location = location;
    }

    @JsonProperty
    public String getImageItem() {
        return imageItem;
    }

    public void setImageItem(String imageItem) {

            this.imageItem = imageItem;
    }
    public void removeImageItem(){
        this.imageItem = null;
    }

    @JsonProperty
    public int getVersion() {
        return this.version;
    }

    public void setVersion(int value) {
        this.version = value;
    }


    @JsonIgnore
    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    //TODO: REMOVE THIS, only for testing. The shoppingList should only be changed by ORM
    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }


    @JsonIgnore
    public boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(boolean value) {
        this.deleted = value;
    }


    @JsonIgnore
    public boolean getModifiedSinceLastSync() {
        return modifiedSinceLastSync;
    }

    public void setModifiedSinceLastSync(boolean value) {
        this.modifiedSinceLastSync = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return item.id == this.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(Item o) {
        return (order - o.getOrder());
    }
}
