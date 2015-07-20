package de.fau.cs.mad.kwikshop.common.interfaces;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.fau.cs.mad.kwikshop.common.User;

public interface DomainListObjectServer extends DomainListObject {

    String getOwnerId();

    void setOwner(User value);

}
