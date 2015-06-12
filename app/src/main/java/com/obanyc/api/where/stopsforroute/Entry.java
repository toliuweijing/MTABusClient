
package com.obanyc.api.where.stopsforroute;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Entry {

    @Expose
    private List<Object> polylines = new ArrayList<Object>();
    @Expose
    private String routeId;
    @Expose
    private List<StopGrouping> stopGroupings = new ArrayList<StopGrouping>();
    @Expose
    private List<String> stopIds = new ArrayList<String>();

    /**
     * 
     * @return
     *     The polylines
     */
    public List<Object> getPolylines() {
        return polylines;
    }

    /**
     * 
     * @param polylines
     *     The polylines
     */
    public void setPolylines(List<Object> polylines) {
        this.polylines = polylines;
    }

    public Entry withPolylines(List<Object> polylines) {
        this.polylines = polylines;
        return this;
    }

    /**
     * 
     * @return
     *     The routeId
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * 
     * @param routeId
     *     The routeId
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public Entry withRouteId(String routeId) {
        this.routeId = routeId;
        return this;
    }

    /**
     * 
     * @return
     *     The stopGroupings
     */
    public List<StopGrouping> getStopGroupings() {
        return stopGroupings;
    }

    /**
     * 
     * @param stopGroupings
     *     The stopGroupings
     */
    public void setStopGroupings(List<StopGrouping> stopGroupings) {
        this.stopGroupings = stopGroupings;
    }

    public Entry withStopGroupings(List<StopGrouping> stopGroupings) {
        this.stopGroupings = stopGroupings;
        return this;
    }

    /**
     * 
     * @return
     *     The stopIds
     */
    public List<String> getStopIds() {
        return stopIds;
    }

    /**
     * 
     * @param stopIds
     *     The stopIds
     */
    public void setStopIds(List<String> stopIds) {
        this.stopIds = stopIds;
    }

    public Entry withStopIds(List<String> stopIds) {
        this.stopIds = stopIds;
        return this;
    }

}
