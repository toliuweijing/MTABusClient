
package com.siri.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ServiceDelivery {

    @Expose
    private String ResponseTimestamp;
    @Expose
    private List<com.siri.model.StopMonitoringDelivery> StopMonitoringDelivery = new ArrayList<com.siri.model.StopMonitoringDelivery>();
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

    /**
     * 
     * @return
     *     The StopMonitoringDelivery
     */
    public List<com.siri.model.StopMonitoringDelivery> getStopMonitoringDelivery() {
        return StopMonitoringDelivery;
    }

    /**
     * 
     * @param StopMonitoringDelivery
     *     The StopMonitoringDelivery
     */
    public void setStopMonitoringDelivery(List<com.siri.model.StopMonitoringDelivery> StopMonitoringDelivery) {
        this.StopMonitoringDelivery = StopMonitoringDelivery;
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

}
