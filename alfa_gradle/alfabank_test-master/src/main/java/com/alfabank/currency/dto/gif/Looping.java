package com.alfabank.currency.dto.gif;

import java.util.HashMap;
import java.util.Map;

public class Looping {

    private String mp4Size;
    private String mp4;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getMp4Size() {
        return mp4Size;
    }

    public void setMp4Size(String mp4Size) {
        this.mp4Size = mp4Size;
    }

    public String getMp4() {
        return mp4;
    }

    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
