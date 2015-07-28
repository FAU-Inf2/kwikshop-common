package de.fau.cs.mad.kwikshop.common.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

public class DateDeserializer extends com.fasterxml.jackson.databind.JsonDeserializer<Date> implements com.google.gson.JsonDeserializer<Date>{


    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return new Date(p.getValueAsLong());
    }

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return new Date(json.getAsLong());
    }
}
