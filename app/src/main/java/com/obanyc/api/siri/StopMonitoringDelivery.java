
package com.obanyc.api.siri;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class StopMonitoringDelivery {

    @Expose
    private List<com.obanyc.api.siri.MonitoredStopVisit> MonitoredStopVisit = new ArrayList<com.obanyc.api.siri.MonitoredStopVisit>();
    @Expose
    private String ResponseTimestamp;
    @Expose
    private String ValidUntil;

    /**
     * 
     * @return
     *     The MonitoredStopVisit
     */
    public List<com.obanyc.api.siri.MonitoredStopVisit> getMonitoredStopVisit() {
        return MonitoredStopVisit;
    }

    /**
     * 
     * @param MonitoredStopVisit
     *     The MonitoredStopVisit
     */
    public void setMonitoredStopVisit(List<com.obanyc.api.siri.MonitoredStopVisit> MonitoredStopVisit) {
        this.MonitoredStopVisit = MonitoredStopVisit;
    }

    public StopMonitoringDelivery withMonitoredStopVisit(List<com.obanyc.api.siri.MonitoredStopVisit> MonitoredStopVisit) {
        this.MonitoredStopVisit = MonitoredStopVisit;
        return this;
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

    public StopMonitoringDelivery withResponseTimestamp(String ResponseTimestamp) {
        this.ResponseTimestamp = ResponseTimestamp;
        return this;
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

    public StopMonitoringDelivery withValidUntil(String ValidUntil) {
        this.ValidUntil = ValidUntil;
        return this;
    }

}
