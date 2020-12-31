package com.bittle.urbandictionary;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class UrbanDictionary {
    private static final String UD_DEFID_URL = "https://api.urbandictionary.com/v0/define?defid=";
    private static final String UD_DEFINE_URL = "https://api.urbandictionary.com/v0/define?term=";
    private static final String UD_RANDOM_URL = "https://api.urbandictionary.com/v0/random";

    private static final GsonBuilder gsonBuilder = new GsonBuilder();

    private static Definition[] fetchDefinitionEndpoint(String endpoint) {
        try {
            InputStreamReader reader = new InputStreamReader(new URL(endpoint).openStream());
            return gsonBuilder.create().fromJson(reader, DefinitionList.class).list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Definition[] define(String term) {
        return fetchDefinitionEndpoint(UD_DEFINE_URL + term);
    }

    public static Definition[] defineByID(long id) {
        return fetchDefinitionEndpoint(UD_DEFID_URL+id);
    }

    public static Definition[] random() {
        return fetchDefinitionEndpoint(UD_RANDOM_URL);
    }
}

// just holds the list, so no reason to make it public
class DefinitionList {
    public Definition[] list;
}