
package com.obanyc.api.where.stopsforroute;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class StopGroup {

    @Expose
    private String id;
    @Expose
    private Name name;
    @Expose
    private List<Object> polylines = new ArrayList<Object>();
    @Expose
    private List<String> stopIds = new ArrayList<String>();
    @Expose
    private List<Object> subGroups = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public StopGroup withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The name
     */
    public Name getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(Name name) {
        this.name = name;
    }

    public StopGroup withName(Name name) {
        this.name = name;
        return this;
    }

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

    public StopGroup withPolylines(List<Object> polylines) {
        this.polylines = polylines;
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

    public StopGroup withStopIds(List<String> stopIds) {
        this.stopIds = stopIds;
        return this;
    }

    /**
     * 
     * @return
     *     The subGroups
     */
    public List<Object> getSubGroups() {
        return subGroups;
    }

    /**
     * 
     * @param subGroups
     *     The subGroups
     */
    public void setSubGroups(List<Object> subGroups) {
        this.subGroups = subGroups;
    }

    public StopGroup withSubGroups(List<Object> subGroups) {
        this.subGroups = subGroups;
        return this;
    }

}
