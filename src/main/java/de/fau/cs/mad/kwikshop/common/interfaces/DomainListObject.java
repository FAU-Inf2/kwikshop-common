package de.fau.cs.mad.kwikshop.common.interfaces;

import java.util.Collection;
import java.util.Date;

import de.fau.cs.mad.kwikshop.android.viewmodel.ItemViewModel;
import de.fau.cs.mad.kwikshop.common.Item;

//TODO: Find better name for this interface
public interface DomainListObject extends DomainObject {

    Collection<Item> getItems();

    Item getItem(int id);

    void addItem(Item item);

    boolean removeItem(int itemId);

    Date getLastModifiedDate();

    void setLastModifiedDate(Date value);

    boolean getModifiedSinceLastSync();

    void setModifiedSinceLastSync(boolean value);

    int getServerVersion();

    void setServerVersion(int value);

    int getServerId();

    void setServerId(int value);
}
