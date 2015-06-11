
package com.obanyc.api.siri;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class MonitoredStopVisit {

    @Expose
    private com.obanyc.api.siri.MonitoredVehicleJourney MonitoredVehicleJourney;
    @Expose
    private String RecordedAtTime;

    /**
     * 
     * @return
     *     The MonitoredVehicleJourney
     */
    public com.obanyc.api.siri.MonitoredVehicleJourney getMonitoredVehicleJourney() {
        return MonitoredVehicleJourney;
    }

    /**
     * 
     * @param MonitoredVehicleJourney
     *     The MonitoredVehicleJourney
     */
    public void setMonitoredVehicleJourney(com.obanyc.api.siri.MonitoredVehicleJourney MonitoredVehicleJourney) {
        this.MonitoredVehicleJourney = MonitoredVehicleJourney;
    }

    public MonitoredStopVisit withMonitoredVehicleJourney(com.obanyc.api.siri.MonitoredVehicleJourney MonitoredVehicleJourney) {
        this.MonitoredVehicleJourney = MonitoredVehicleJourney;
        return this;
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

    public MonitoredStopVisit withRecordedAtTime(String RecordedAtTime) {
        this.RecordedAtTime = RecordedAtTime;
        return this;
    }

}
