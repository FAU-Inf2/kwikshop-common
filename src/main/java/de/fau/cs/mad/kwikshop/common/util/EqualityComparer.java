package de.fau.cs.mad.kwikshop.common.util;

import de.fau.cs.mad.kwikshop.common.*;

import java.util.Date;

public abstract class EqualityComparer {


    public boolean itemEquals(Item item1, Item item2) {

        return item1.getOrder() == item2.getOrder() &&
                item1.isBought() == item2.isBought() &&
                stringEquals(item1.getName(), item2.getName()) &&
                item1.getAmount() == item2.getAmount() &&
                item1.isHighlight() == item2.isHighlight() &&
                stringEquals(item1.getBrand(), item2.getBrand()) &&
                stringEquals(item1.getComment(), item2.getComment()) &&
                groupEquals(item1.getGroup(), item2.getGroup()) &&
                unitEquals(item1.getUnit(), item2.getUnit()) &&
                dateEquals(item1.getLastBought(), item2.getLastBought()) &&
                item1.getRepeatType() == item2.getRepeatType() &&
                item1.getPeriodType() == item2.getPeriodType() &&
                item1.getSelectedRepeatTime() == item2.getSelectedRepeatTime() &&
                item1.isRemindFromNextPurchaseOn() == item2.isRemindFromNextPurchaseOn() &&
                dateEquals(item1.getRemindAtDate(), item2.getRemindAtDate()) &&
                locationEquals(item1.getLocation(), item2.getLocation());
    }

    /**
     * String comparer function that can handle null value
     */
    public boolean stringEquals(String string1, String string2){

        if(string1 == null && string2 == null) {
            return true;
        }

        if(string1 == null || string2 == null) {
            return false;
        }

        return  string1.equals(string2);
    }

    public boolean groupEquals(Group group1, Group group2) {

        if(group1 == group2) {
            return true;
        }

        if(group1 == null || group2 == null) {
            return false;
        }

        return idEquals(group1, group2);
    }

    public boolean unitEquals(Unit unit1, Unit unit2) {

        if(unit1 == unit2) {
            return true;
        }

        if(unit1 == null || unit2 == null) {
            return false;
        }

        return idEquals(unit1, unit2);

    }

    public boolean dateEquals(Date date1, Date date2) {

        if(date1 == date2) {
            return true;
        }

        if(date1 == null || date2 == null) {
            return false;
        }

        return date1.equals(date2);
    }

    public boolean locationEquals(LastLocation location1, LastLocation location2) {

        if(location1 == location2) {
            return true;
        }

        if(location1 == null || location2 == null) {
            return false;
        }

        return idEquals(location1, location2);

    }

    public boolean recipeEquals(RecipeServer recipe1, RecipeServer recipe2) {

        return stringEquals(recipe1.getName(), recipe2.getName()) &&
                recipe1.getScaleFactor() == recipe2.getScaleFactor() &&
                stringEquals(recipe1.getScaleName(), recipe2.getScaleName()) &&
                dateEquals(recipe1.getLastModifiedDate(), recipe2.getLastModifiedDate());
    }

    public boolean recipeEquals(Recipe recipe1, Recipe recipe2) {

        return stringEquals(recipe1.getName(), recipe2.getName()) &&
                recipe1.getScaleFactor() == recipe2.getScaleFactor() &&
                stringEquals(recipe1.getScaleName(), recipe2.getScaleName()) &&
                dateEquals(recipe1.getLastModifiedDate(), recipe2.getLastModifiedDate());
    }

    public boolean shoppingListEquals(ShoppingListServer shoppingList1, ShoppingListServer shoppingList2) {

        return stringEquals(shoppingList1.getName(), shoppingList2.getName()) &&
                shoppingList1.getSortTypeInt() == shoppingList2.getSortTypeInt() &&
                locationEquals(shoppingList1.getLocation(), shoppingList2.getLocation()) &&
                dateEquals(shoppingList1.getLastModifiedDate(), shoppingList2.getLastModifiedDate());
    }

    public boolean shoppingListEquals(ShoppingList shoppingList1, ShoppingList shoppingList2) {

        return stringEquals(shoppingList1.getName(), shoppingList2.getName()) &&
                shoppingList1.getSortTypeInt() == shoppingList2.getSortTypeInt() &&
                dateEquals(shoppingList1.getLastModifiedDate(), shoppingList2.getLastModifiedDate());
    }


    protected abstract boolean idEquals(Group group1, Group group2);

    protected abstract boolean idEquals(Unit unit1, Unit unit2);

    protected abstract boolean idEquals(LastLocation location1, LastLocation location2);

}
