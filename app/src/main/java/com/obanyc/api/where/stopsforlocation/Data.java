
package com.obanyc.api.where.stopsforlocation;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Data {

    @Expose
    private boolean limitExceeded;
    @Expose
    private List<Stop> stops = new ArrayList<Stop>();

    /**
     * 
     * @return
     *     The limitExceeded
     */
    public boolean isLimitExceeded() {
        return limitExceeded;
    }

    /**
     * 
     * @param limitExceeded
     *     The limitExceeded
     */
    public void setLimitExceeded(boolean limitExceeded) {
        this.limitExceeded = limitExceeded;
    }

    public Data withLimitExceeded(boolean limitExceeded) {
        this.limitExceeded = limitExceeded;
        return this;
    }

    /**
     * 
     * @return
     *     The stops
     */
    public List<Stop> getStops() {
        return stops;
    }

    /**
     * 
     * @param stops
     *     The stops
     */
    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public Data withStops(List<Stop> stops) {
        this.stops = stops;
        return this;
    }

}
