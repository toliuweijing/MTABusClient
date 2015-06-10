
package com.siri.model;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class MonitoredStopVisit {

    @Expose
    private com.siri.model.MonitoredVehicleJourney MonitoredVehicleJourney;
    @Expose
    private String RecordedAtTime;

    /**
     * 
     * @return
     *     The MonitoredVehicleJourney
     */
    public com.siri.model.MonitoredVehicleJourney getMonitoredVehicleJourney() {
        return MonitoredVehicleJourney;
    }

    /**
     * 
     * @param MonitoredVehicleJourney
     *     The MonitoredVehicleJourney
     */
    public void setMonitoredVehicleJourney(com.siri.model.MonitoredVehicleJourney MonitoredVehicleJourney) {
        this.MonitoredVehicleJourney = MonitoredVehicleJourney;
    }

    /**
     * 
     * @return
     *     The RecordedAtTime
     */
    public String getRecordedAtTime() {
        return RecordedAtTime;
    }

    /**
     * 
     * @param RecordedAtTime
     *     The RecordedAtTime
     */
    public void setRecordedAtTime(String RecordedAtTime) {
        this.RecordedAtTime = RecordedAtTime;
    }

}
