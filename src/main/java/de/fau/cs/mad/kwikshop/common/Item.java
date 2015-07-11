package de.fau.cs.mad.kwikshop.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@DatabaseTable(tableName = "item")
public class Item {

    public static final String FOREIGN_SHOPPINGLIST_FIELD_NAME = "shoppingList";
    public static final String FOREIGN_RECIPE_FIELD_NAME = "recipe";


    @DatabaseField(generatedId = true)
    private int id;

    // Order of this Item in the ShoppingList
    @DatabaseField
    private int order = -1;

    @DatabaseField
    private Boolean bought = false;

    @DatabaseField(canBeNull = false)
    private String name = "";

    @DatabaseField
    private int amount = 1;

    @DatabaseField
    private Boolean highlight = false;

    @DatabaseField(canBeNull = true)
    private String brand;

    @DatabaseField(canBeNull = true)
    private String comment;

    @DatabaseField(foreign = true)
    private Group group;

    @DatabaseField(foreign = true)
    private Unit unit;

    /**
     * the ShoppingList, that contains this Item.
     * (Required for ORMLite)
     */
    @DatabaseField(foreign = true, columnName = FOREIGN_SHOPPINGLIST_FIELD_NAME)
    private ShoppingList shoppingList;

    @DatabaseField(foreign = true, columnName = FOREIGN_RECIPE_FIELD_NAME)
    private Recipe recipe;

    @DatabaseField(canBeNull = true)
    private Date lastBought;

    @DatabaseField
    private boolean regularlyRepeatItem;

    @DatabaseField
    private TimePeriodsEnum periodType;

    @DatabaseField
    private int selectedRepeatTime;

    @DatabaseField
    private boolean remindFromNextPurchaseOn;

    @DatabaseField(canBeNull = true)
    private Date remindAtDate;

    @DatabaseField(foreign = true, canBeNull = true)
    private LastLocation location;


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
    }


    @JsonProperty
    public int getId() {
        return id;
    }

    // TODO: REMOVE THIS, only for testing. IDs should be read only
    public void setID(int id) {
        this.id = id;
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
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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
    public boolean isRegularlyRepeatItem() {
        return regularlyRepeatItem;
    }

    public void setRegularlyRepeatItem(boolean regularlyRepeatItem) {
        this.regularlyRepeatItem = regularlyRepeatItem;
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

    @JsonIgnore
    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    //TODO: REMOVE THIS, only for testing. The shoppingList should only be changed by ORM
    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
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

}
