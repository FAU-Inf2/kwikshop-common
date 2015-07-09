package de.fau.cs.mad.kwikshop.common;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import de.fau.cs.mad.kwikshop.common.ShoppingList;

@DatabaseTable(tableName = "accountID")
public class AccountID {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private int accountID;

    /**
     * reference to the ShoppingList, that contains this accountID
     * (required for ORMLite)
     */
    @DatabaseField(foreign = true)
    private ShoppingList shoppingList;

    public AccountID() {
        // Default no-arg constructor for generating AccountIDs, required for ORMLite
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }
}
