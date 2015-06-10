
package com.siri.model;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class MonitoredCall {

    @Expose
    private com.siri.model.Extensions Extensions;
    @Expose
    private String StopPointRef;
    @Expose
    private int VisitNumber;
    @Expose
    private String StopPointName;

    /**
     * 
     * @return
     *     The Extensions
     */
    public com.siri.model.Extensions getExtensions() {
        return Extensions;
    }

    /**
     * 
     * @param Extensions
     *     The Extensions
     */
    public void setExtensions(com.siri.model.Extensions Extensions) {
        this.Extensions = Extensions;
    }

    /**
     * 
     * @return
     *     The StopPointRef
     */
    public String getStopPointRef() {
        return StopPointRef;
    }

    /**
     * 
     * @param StopPointRef
     *     The StopPointRef
     */
    public void setStopPointRef(String StopPointRef) {
        this.StopPointRef = StopPointRef;
    }

    /**
     * 
     * @return
     *     The VisitNumber
     */
    public int getVisitNumber() {
        return VisitNumber;
    }

    /**
     * 
     * @param VisitNumber
     *     The VisitNumber
     */
    public void setVisitNumber(int VisitNumber) {
        this.VisitNumber = VisitNumber;
    }

    /**
     * 
     * @return
     *     The StopPointName
     */
    public String getStopPointName() {
        return StopPointName;
    }

    /**
     * 
     * @param StopPointName
     *     The StopPointName
     */
    public void setStopPointName(String StopPointName) {
        this.StopPointName = StopPointName;
    }

}
