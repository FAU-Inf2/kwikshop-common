package de.fau.cs.mad.kwikshop.common.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import de.fau.cs.mad.kwikshop.common.localization.ResourceId;

import java.io.IOException;
import java.lang.reflect.Type;

public class ResourceIdSerializer extends com.fasterxml.jackson.databind.JsonSerializer<ResourceId> implements com.google.gson.JsonSerializer<ResourceId> {

    @Override
    public void serialize(ResourceId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(value.toInt());
    }

    @Override
    public JsonElement serialize(ResourceId src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toInt());
    }
}
