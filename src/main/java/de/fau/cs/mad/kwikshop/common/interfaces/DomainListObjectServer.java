package de.fau.cs.mad.kwikshop.common.interfaces;


import java.util.Collection;
import java.util.Date;

import de.fau.cs.mad.kwikshop.common.Item;

public interface DomainListObjectServer extends DomainObject {

    Collection<Item> getItems();

    Item getItem(int id);

    void addItem(Item item);

    boolean removeItem(int itemId);

    Date getLastModifiedDate();

    void setLastModifiedDate(Date value);

    int getId();

    String getOwnerId();

    void setOwnerId(String value);

    boolean getDeleted();

    void setDeleted(boolean value);

    int getVersion();

    void setVersion(int value);

    int getLeaseId();

    void setLeaseId(int value);

}
