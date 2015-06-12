
package com.obanyc.api.where.stopsforroute;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class StopGrouping {

    @Expose
    private boolean ordered;
    @Expose
    private List<StopGroup> stopGroups = new ArrayList<StopGroup>();
    @Expose
    private String type;

    /**
     * 
     * @return
     *     The ordered
     */
    public boolean isOrdered() {
        return ordered;
    }

    /**
     * 
     * @param ordered
     *     The ordered
     */
    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public StopGrouping withOrdered(boolean ordered) {
        this.ordered = ordered;
        return this;
    }

    /**
     * 
     * @return
     *     The stopGroups
     */
    public List<StopGroup> getStopGroups() {
        return stopGroups;
    }

    /**
     * 
     * @param stopGroups
     *     The stopGroups
     */
    public void setStopGroups(List<StopGroup> stopGroups) {
        this.stopGroups = stopGroups;
    }

    public StopGrouping withStopGroups(List<StopGroup> stopGroups) {
        this.stopGroups = stopGroups;
        return this;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    public StopGrouping withType(String type) {
        this.type = type;
        return this;
    }

}
