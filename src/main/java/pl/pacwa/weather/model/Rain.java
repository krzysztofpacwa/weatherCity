
package pl.pacwa.weather.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "1h"
})
public class Rain {

    @JsonProperty("1h")
    private Double _1h;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Rain(Double _1h, Map<String, Object> additionalProperties) {
        this._1h = _1h;
        this.additionalProperties = additionalProperties;
    }

    public Rain() {
    }

    @JsonProperty("1h")
    public Double get1h() {
        return _1h;
    }

    @JsonProperty("1h")
    public void set1h(Double _1h) {
        this._1h = _1h;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Rain{" +
                "_1h=" + _1h +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
