
package com.siri.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class StopMonitoringDelivery {

    @Expose
    private List<com.siri.model.MonitoredStopVisit> MonitoredStopVisit = new ArrayList<com.siri.model.MonitoredStopVisit>();
    @Expose
    private String ResponseTimestamp;
    @Expose
    private String ValidUntil;

    /**
     * 
     * @return
     *     The MonitoredStopVisit
     */
    public List<com.siri.model.MonitoredStopVisit> getMonitoredStopVisit() {
        return MonitoredStopVisit;
    }

    /**
     * 
     * @param MonitoredStopVisit
     *     The MonitoredStopVisit
     */
    public void setMonitoredStopVisit(List<com.siri.model.MonitoredStopVisit> MonitoredStopVisit) {
        this.MonitoredStopVisit = MonitoredStopVisit;
    }

    /**
     * 
     * @return
     *     The ResponseTimestamp
     */
    public String getResponseTimestamp() {
        return ResponseTimestamp;
    }

    /**
     * 
     * @param ResponseTimestamp
     *     The ResponseTimestamp
     */
    public void setResponseTimestamp(String ResponseTimestamp) {
        this.ResponseTimestamp = ResponseTimestamp;
    }

    /**
     * 
     * @return
     *     The ValidUntil
     */
    public String getValidUntil() {
        return ValidUntil;
    }

    /**
     * 
     * @param ValidUntil
     *     The ValidUntil
     */
    public void setValidUntil(String ValidUntil) {
        this.ValidUntil = ValidUntil;
    }

}
