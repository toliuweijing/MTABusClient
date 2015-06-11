
package com.obanyc.api.where;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Entry {

    @Expose
    private long date;
    @Expose
    private String stopId;
    @Expose
    private List<StopRouteSchedule> stopRouteSchedules = new ArrayList<StopRouteSchedule>();

    /**
     * 
     * @return
     *     The date
     */
    public long getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(long date) {
        this.date = date;
    }

    public Entry withDate(long date) {
        this.date = date;
        return this;
    }

    /**
     * 
     * @return
     *     The stopId
     */
    public String getStopId() {
        return stopId;
    }

    /**
     * 
     * @param stopId
     *     The stopId
     */
    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public Entry withStopId(String stopId) {
        this.stopId = stopId;
        return this;
    }

    /**
     * 
     * @return
     *     The stopRouteSchedules
     */
    public List<StopRouteSchedule> getStopRouteSchedules() {
        return stopRouteSchedules;
    }

    /**
     * 
     * @param stopRouteSchedules
     *     The stopRouteSchedules
     */
    public void setStopRouteSchedules(List<StopRouteSchedule> stopRouteSchedules) {
        this.stopRouteSchedules = stopRouteSchedules;
    }

    public Entry withStopRouteSchedules(List<StopRouteSchedule> stopRouteSchedules) {
        this.stopRouteSchedules = stopRouteSchedules;
        return this;
    }

}
