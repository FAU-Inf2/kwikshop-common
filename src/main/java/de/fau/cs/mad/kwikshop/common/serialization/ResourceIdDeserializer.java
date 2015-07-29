package de.fau.cs.mad.kwikshop.common.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import de.fau.cs.mad.kwikshop.common.localization.ResourceId;

import java.io.IOException;
import java.lang.reflect.Type;


public class ResourceIdDeserializer  extends com.fasterxml.jackson.databind.JsonDeserializer<ResourceId> implements com.google.gson.JsonDeserializer<ResourceId> {

    @Override
    public ResourceId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return ResourceId.fromInt(p.getValueAsInt());
    }

    @Override
    public ResourceId deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return ResourceId.fromInt(json.getAsInt());
    }

}
