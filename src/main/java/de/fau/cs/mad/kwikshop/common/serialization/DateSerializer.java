package de.fau.cs.mad.kwikshop.common.serialization;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

public class DateSerializer extends com.fasterxml.jackson.databind.JsonSerializer<Date> implements com.google.gson.JsonSerializer<Date> {


    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(value.getTime());
    }

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getTime());
    }
}
