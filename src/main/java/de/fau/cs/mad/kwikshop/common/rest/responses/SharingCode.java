package de.fau.cs.mad.kwikshop.common.rest.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SharingCode {

    private String sharingCode;

    @JsonProperty
    public String getSharingCode() {
        return sharingCode;
    }

    public void setSharingCode(String sharingCode) {
        this.sharingCode = sharingCode;
    }

}
