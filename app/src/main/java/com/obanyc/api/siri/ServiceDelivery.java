
package com.obanyc.api.siri;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ServiceDelivery {

    @Expose
    private String ResponseTimestamp;
    @Expose
    private List<com.obanyc.api.siri.StopMonitoringDelivery> StopMonitoringDelivery = new ArrayList<com.obanyc.api.siri.StopMonitoringDelivery>();
    @Expose
    private List<Object> SituationExchangeDelivery = new ArrayList<Object>();

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

    public ServiceDelivery withResponseTimestamp(String ResponseTimestamp) {
        this.ResponseTimestamp = ResponseTimestamp;
        return this;
    }

    /**
     * 
     * @return
     *     The StopMonitoringDelivery
     */
    public List<com.obanyc.api.siri.StopMonitoringDelivery> getStopMonitoringDelivery() {
        return StopMonitoringDelivery;
    }

    /**
     * 
     * @param StopMonitoringDelivery
     *     The StopMonitoringDelivery
     */
    public void setStopMonitoringDelivery(List<com.obanyc.api.siri.StopMonitoringDelivery> StopMonitoringDelivery) {
        this.StopMonitoringDelivery = StopMonitoringDelivery;
    }

    public ServiceDelivery withStopMonitoringDelivery(List<com.obanyc.api.siri.StopMonitoringDelivery> StopMonitoringDelivery) {
        this.StopMonitoringDelivery = StopMonitoringDelivery;
        return this;
    }

    /**
     * 
     * @return
     *     The SituationExchangeDelivery
     */
    public List<Object> getSituationExchangeDelivery() {
        return SituationExchangeDelivery;
    }

    /**
     * 
     * @param SituationExchangeDelivery
     *     The SituationExchangeDelivery
     */
    public void setSituationExchangeDelivery(List<Object> SituationExchangeDelivery) {
        this.SituationExchangeDelivery = SituationExchangeDelivery;
    }

    public ServiceDelivery withSituationExchangeDelivery(List<Object> SituationExchangeDelivery) {
        this.SituationExchangeDelivery = SituationExchangeDelivery;
        return this;
    }

}
