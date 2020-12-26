package com.alfabank.currency.dto.gif;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gif {

    private Datum data ;
    private Pagination pagination;
    private Meta meta;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Datum getData() {
        return data;
    }

    public void setData(Datum data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
