package br.com.gilsouza.androidarchitetctures.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

public class Country {
    @SerializedName("name")
    @JsonAdapter(CountryNameDeserializer.class)
    public String countryName;

    public static class CountryNameDeserializer implements JsonDeserializer<String> {
        @Override
        public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            return json.getAsJsonObject().get("common").getAsString();
        }
    }
}
