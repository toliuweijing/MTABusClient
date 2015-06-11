
package com.obanyc.api.siri;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class MonitoredCall {

    @Expose
    private com.obanyc.api.siri.Extensions Extensions;
    @Expose
    private String StopPointRef;
    @Expose
    private long VisitNumber;
    @Expose
    private String StopPointName;

    /**
     * 
     * @return
     *     The Extensions
     */
    public com.obanyc.api.siri.Extensions getExtensions() {
        return Extensions;
    }

    /**
     * 
     * @param Extensions
     *     The Extensions
     */
    public void setExtensions(com.obanyc.api.siri.Extensions Extensions) {
        this.Extensions = Extensions;
    }

    public MonitoredCall withExtensions(com.obanyc.api.siri.Extensions Extensions) {
        this.Extensions = Extensions;
        return this;
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

    public MonitoredCall withStopPointRef(String StopPointRef) {
        this.StopPointRef = StopPointRef;
        return this;
    }

    /**
     * 
     * @return
     *     The VisitNumber
     */
    public long getVisitNumber() {
        return VisitNumber;
    }

    /**
     * 
     * @param VisitNumber
     *     The VisitNumber
     */
    public void setVisitNumber(long VisitNumber) {
        this.VisitNumber = VisitNumber;
    }

    public MonitoredCall withVisitNumber(long VisitNumber) {
        this.VisitNumber = VisitNumber;
        return this;
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

    public MonitoredCall withStopPointName(String StopPointName) {
        this.StopPointName = StopPointName;
        return this;
    }

}
