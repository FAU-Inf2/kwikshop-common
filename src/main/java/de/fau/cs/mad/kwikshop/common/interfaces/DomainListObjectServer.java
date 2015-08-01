package de.fau.cs.mad.kwikshop.common.interfaces;


public interface DomainListObjectServer extends DomainListObject {

    int getId();

    String getOwnerId();

    void setOwnerId(String value);

}
