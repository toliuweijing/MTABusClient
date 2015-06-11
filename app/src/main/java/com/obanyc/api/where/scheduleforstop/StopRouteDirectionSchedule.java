
package com.obanyc.api.where.scheduleforstop;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class StopRouteDirectionSchedule {

    @Expose
    private List<Object> scheduleFrequencies = new ArrayList<Object>();
    @Expose
    private List<ScheduleStopTime> scheduleStopTimes = new ArrayList<ScheduleStopTime>();
    @Expose
    private String tripHeadsign;

    /**
     * 
     * @return
     *     The scheduleFrequencies
     */
    public List<Object> getScheduleFrequencies() {
        return scheduleFrequencies;
    }

    /**
     * 
     * @param scheduleFrequencies
     *     The scheduleFrequencies
     */
    public void setScheduleFrequencies(List<Object> scheduleFrequencies) {
        this.scheduleFrequencies = scheduleFrequencies;
    }

    public StopRouteDirectionSchedule withScheduleFrequencies(List<Object> scheduleFrequencies) {
        this.scheduleFrequencies = scheduleFrequencies;
        return this;
    }

    /**
     * 
     * @return
     *     The scheduleStopTimes
     */
    public List<ScheduleStopTime> getScheduleStopTimes() {
        return scheduleStopTimes;
    }

    /**
     * 
     * @param scheduleStopTimes
     *     The scheduleStopTimes
     */
    public void setScheduleStopTimes(List<ScheduleStopTime> scheduleStopTimes) {
        this.scheduleStopTimes = scheduleStopTimes;
    }

    public StopRouteDirectionSchedule withScheduleStopTimes(List<ScheduleStopTime> scheduleStopTimes) {
        this.scheduleStopTimes = scheduleStopTimes;
        return this;
    }

    /**
     * 
     * @return
     *     The tripHeadsign
     */
    public String getTripHeadsign() {
        return tripHeadsign;
    }

    /**
     * 
     * @param tripHeadsign
     *     The tripHeadsign
     */
    public void setTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
    }

    public StopRouteDirectionSchedule withTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
        return this;
    }

}
