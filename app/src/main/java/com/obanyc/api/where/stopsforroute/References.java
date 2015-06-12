
package com.obanyc.api.where.stopsforroute;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class References {

    @Expose
    private List<Agency> agencies = new ArrayList<Agency>();
    @Expose
    private List<Route> routes = new ArrayList<Route>();
    @Expose
    private List<Object> situations = new ArrayList<Object>();
    @Expose
    private List<Stop> stops = new ArrayList<Stop>();
    @Expose
    private List<Object> trips = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The agencies
     */
    public List<Agency> getAgencies() {
        return agencies;
    }

    /**
     * 
     * @param agencies
     *     The agencies
     */
    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

    public References withAgencies(List<Agency> agencies) {
        this.agencies = agencies;
        return this;
    }

    /**
     * 
     * @return
     *     The routes
     */
    public List<Route> getRoutes() {
        return routes;
    }

    /**
     * 
     * @param routes
     *     The routes
     */
    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public References withRoutes(List<Route> routes) {
        this.routes = routes;
        return this;
    }

    /**
     * 
     * @return
     *     The situations
     */
    public List<Object> getSituations() {
        return situations;
    }

    /**
     * 
     * @param situations
     *     The situations
     */
    public void setSituations(List<Object> situations) {
        this.situations = situations;
    }

    public References withSituations(List<Object> situations) {
        this.situations = situations;
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

    public References withStops(List<Stop> stops) {
        this.stops = stops;
        return this;
    }

    /**
     * 
     * @return
     *     The trips
     */
    public List<Object> getTrips() {
        return trips;
    }

    /**
     * 
     * @param trips
     *     The trips
     */
    public void setTrips(List<Object> trips) {
        this.trips = trips;
    }

    public References withTrips(List<Object> trips) {
        this.trips = trips;
        return this;
    }

}
