
package com.obanyc.api.where.stopsforroute;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Stop {

    @Expose
    private String code;
    @Expose
    private String direction;
    @Expose
    private String id;
    @Expose
    private double lat;
    @Expose
    private long locationType;
    @Expose
    private double lon;
    @Expose
    private String name;
    @Expose
    private List<String> routeIds = new ArrayList<String>();
    @Expose
    private String wheelchairBoarding;

    /**
     * 
     * @return
     *     The code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    public Stop withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * 
     * @return
     *     The direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * 
     * @param direction
     *     The direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Stop withDirection(String direction) {
        this.direction = direction;
        return this;
    }

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

    public Stop withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    public Stop withLat(double lat) {
        this.lat = lat;
        return this;
    }

    /**
     * 
     * @return
     *     The locationType
     */
    public long getLocationType() {
        return locationType;
    }

    /**
     * 
     * @param locationType
     *     The locationType
     */
    public void setLocationType(long locationType) {
        this.locationType = locationType;
    }

    public Stop withLocationType(long locationType) {
        this.locationType = locationType;
        return this;
    }

    /**
     * 
     * @return
     *     The lon
     */
    public double getLon() {
        return lon;
    }

    /**
     * 
     * @param lon
     *     The lon
     */
    public void setLon(double lon) {
        this.lon = lon;
    }

    public Stop withLon(double lon) {
        this.lon = lon;
        return this;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Stop withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The routeIds
     */
    public List<String> getRouteIds() {
        return routeIds;
    }

    /**
     * 
     * @param routeIds
     *     The routeIds
     */
    public void setRouteIds(List<String> routeIds) {
        this.routeIds = routeIds;
    }

    public Stop withRouteIds(List<String> routeIds) {
        this.routeIds = routeIds;
        return this;
    }

    /**
     * 
     * @return
     *     The wheelchairBoarding
     */
    public String getWheelchairBoarding() {
        return wheelchairBoarding;
    }

    /**
     * 
     * @param wheelchairBoarding
     *     The wheelchairBoarding
     */
    public void setWheelchairBoarding(String wheelchairBoarding) {
        this.wheelchairBoarding = wheelchairBoarding;
    }

    public Stop withWheelchairBoarding(String wheelchairBoarding) {
        this.wheelchairBoarding = wheelchairBoarding;
        return this;
    }

}
