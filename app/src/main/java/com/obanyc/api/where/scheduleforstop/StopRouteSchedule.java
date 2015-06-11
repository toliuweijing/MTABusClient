
package com.obanyc.api.where.scheduleforstop;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class StopRouteSchedule {

    @Expose
    private String routeId;
    @Expose
    private List<StopRouteDirectionSchedule> stopRouteDirectionSchedules = new ArrayList<StopRouteDirectionSchedule>();

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

    public StopRouteSchedule withRouteId(String routeId) {
        this.routeId = routeId;
        return this;
    }

    /**
     * 
     * @return
     *     The stopRouteDirectionSchedules
     */
    public List<StopRouteDirectionSchedule> getStopRouteDirectionSchedules() {
        return stopRouteDirectionSchedules;
    }

    /**
     * 
     * @param stopRouteDirectionSchedules
     *     The stopRouteDirectionSchedules
     */
    public void setStopRouteDirectionSchedules(List<StopRouteDirectionSchedule> stopRouteDirectionSchedules) {
        this.stopRouteDirectionSchedules = stopRouteDirectionSchedules;
    }

    public StopRouteSchedule withStopRouteDirectionSchedules(List<StopRouteDirectionSchedule> stopRouteDirectionSchedules) {
        this.stopRouteDirectionSchedules = stopRouteDirectionSchedules;
        return this;
    }

}
