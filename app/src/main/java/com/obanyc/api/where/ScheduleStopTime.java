
package com.obanyc.api.where;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ScheduleStopTime {

    @Expose
    private boolean arrivalEnabled;
    @Expose
    private long arrivalTime;
    @Expose
    private boolean departureEnabled;
    @Expose
    private long departureTime;
    @Expose
    private String serviceId;
    @Expose
    private String stopHeadsign;
    @Expose
    private String tripId;

    /**
     * 
     * @return
     *     The arrivalEnabled
     */
    public boolean isArrivalEnabled() {
        return arrivalEnabled;
    }

    /**
     * 
     * @param arrivalEnabled
     *     The arrivalEnabled
     */
    public void setArrivalEnabled(boolean arrivalEnabled) {
        this.arrivalEnabled = arrivalEnabled;
    }

    public ScheduleStopTime withArrivalEnabled(boolean arrivalEnabled) {
        this.arrivalEnabled = arrivalEnabled;
        return this;
    }

    /**
     * 
     * @return
     *     The arrivalTime
     */
    public long getArrivalTime() {
        return arrivalTime;
    }

    /**
     * 
     * @param arrivalTime
     *     The arrivalTime
     */
    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public ScheduleStopTime withArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    /**
     * 
     * @return
     *     The departureEnabled
     */
    public boolean isDepartureEnabled() {
        return departureEnabled;
    }

    /**
     * 
     * @param departureEnabled
     *     The departureEnabled
     */
    public void setDepartureEnabled(boolean departureEnabled) {
        this.departureEnabled = departureEnabled;
    }

    public ScheduleStopTime withDepartureEnabled(boolean departureEnabled) {
        this.departureEnabled = departureEnabled;
        return this;
    }

    /**
     * 
     * @return
     *     The departureTime
     */
    public long getDepartureTime() {
        return departureTime;
    }

    /**
     * 
     * @param departureTime
     *     The departureTime
     */
    public void setDepartureTime(long departureTime) {
        this.departureTime = departureTime;
    }

    public ScheduleStopTime withDepartureTime(long departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    /**
     * 
     * @return
     *     The serviceId
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * 
     * @param serviceId
     *     The serviceId
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public ScheduleStopTime withServiceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    /**
     * 
     * @return
     *     The stopHeadsign
     */
    public String getStopHeadsign() {
        return stopHeadsign;
    }

    /**
     * 
     * @param stopHeadsign
     *     The stopHeadsign
     */
    public void setStopHeadsign(String stopHeadsign) {
        this.stopHeadsign = stopHeadsign;
    }

    public ScheduleStopTime withStopHeadsign(String stopHeadsign) {
        this.stopHeadsign = stopHeadsign;
        return this;
    }

    /**
     * 
     * @return
     *     The tripId
     */
    public String getTripId() {
        return tripId;
    }

    /**
     * 
     * @param tripId
     *     The tripId
     */
    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public ScheduleStopTime withTripId(String tripId) {
        this.tripId = tripId;
        return this;
    }

}
