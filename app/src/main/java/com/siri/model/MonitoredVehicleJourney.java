
package com.siri.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class MonitoredVehicleJourney {

    @Expose
    private String LineRef;
    @Expose
    private String DirectionRef;
    @Expose
    private com.siri.model.FramedVehicleJourneyRef FramedVehicleJourneyRef;
    @Expose
    private String JourneyPatternRef;
    @Expose
    private String PublishedLineName;
    @Expose
    private String OperatorRef;
    @Expose
    private String OriginRef;
    @Expose
    private String DestinationRef;
    @Expose
    private String DestinationName;
    @Expose
    private String OriginAimedDepartureTime;
    @Expose
    private List<Object> SituationRef = new ArrayList<Object>();
    @Expose
    private boolean Monitored;
    @Expose
    private com.siri.model.VehicleLocation VehicleLocation;
    @Expose
    private float Bearing;
    @Expose
    private String ProgressRate;
    @Expose
    private String ProgressStatus;
    @Expose
    private String BlockRef;
    @Expose
    private String VehicleRef;
    @Expose
    private com.siri.model.MonitoredCall MonitoredCall;
    @Expose
    private com.siri.model.OnwardCalls OnwardCalls;

    /**
     * 
     * @return
     *     The LineRef
     */
    public String getLineRef() {
        return LineRef;
    }

    /**
     * 
     * @param LineRef
     *     The LineRef
     */
    public void setLineRef(String LineRef) {
        this.LineRef = LineRef;
    }

    /**
     * 
     * @return
     *     The DirectionRef
     */
    public String getDirectionRef() {
        return DirectionRef;
    }

    /**
     * 
     * @param DirectionRef
     *     The DirectionRef
     */
    public void setDirectionRef(String DirectionRef) {
        this.DirectionRef = DirectionRef;
    }

    /**
     * 
     * @return
     *     The FramedVehicleJourneyRef
     */
    public com.siri.model.FramedVehicleJourneyRef getFramedVehicleJourneyRef() {
        return FramedVehicleJourneyRef;
    }

    /**
     * 
     * @param FramedVehicleJourneyRef
     *     The FramedVehicleJourneyRef
     */
    public void setFramedVehicleJourneyRef(com.siri.model.FramedVehicleJourneyRef FramedVehicleJourneyRef) {
        this.FramedVehicleJourneyRef = FramedVehicleJourneyRef;
    }

    /**
     * 
     * @return
     *     The JourneyPatternRef
     */
    public String getJourneyPatternRef() {
        return JourneyPatternRef;
    }

    /**
     * 
     * @param JourneyPatternRef
     *     The JourneyPatternRef
     */
    public void setJourneyPatternRef(String JourneyPatternRef) {
        this.JourneyPatternRef = JourneyPatternRef;
    }

    /**
     * 
     * @return
     *     The PublishedLineName
     */
    public String getPublishedLineName() {
        return PublishedLineName;
    }

    /**
     * 
     * @param PublishedLineName
     *     The PublishedLineName
     */
    public void setPublishedLineName(String PublishedLineName) {
        this.PublishedLineName = PublishedLineName;
    }

    /**
     * 
     * @return
     *     The OperatorRef
     */
    public String getOperatorRef() {
        return OperatorRef;
    }

    /**
     * 
     * @param OperatorRef
     *     The OperatorRef
     */
    public void setOperatorRef(String OperatorRef) {
        this.OperatorRef = OperatorRef;
    }

    /**
     * 
     * @return
     *     The OriginRef
     */
    public String getOriginRef() {
        return OriginRef;
    }

    /**
     * 
     * @param OriginRef
     *     The OriginRef
     */
    public void setOriginRef(String OriginRef) {
        this.OriginRef = OriginRef;
    }

    /**
     * 
     * @return
     *     The DestinationRef
     */
    public String getDestinationRef() {
        return DestinationRef;
    }

    /**
     * 
     * @param DestinationRef
     *     The DestinationRef
     */
    public void setDestinationRef(String DestinationRef) {
        this.DestinationRef = DestinationRef;
    }

    /**
     * 
     * @return
     *     The DestinationName
     */
    public String getDestinationName() {
        return DestinationName;
    }

    /**
     * 
     * @param DestinationName
     *     The DestinationName
     */
    public void setDestinationName(String DestinationName) {
        this.DestinationName = DestinationName;
    }

    /**
     * 
     * @return
     *     The OriginAimedDepartureTime
     */
    public String getOriginAimedDepartureTime() {
        return OriginAimedDepartureTime;
    }

    /**
     * 
     * @param OriginAimedDepartureTime
     *     The OriginAimedDepartureTime
     */
    public void setOriginAimedDepartureTime(String OriginAimedDepartureTime) {
        this.OriginAimedDepartureTime = OriginAimedDepartureTime;
    }

    /**
     * 
     * @return
     *     The SituationRef
     */
    public List<Object> getSituationRef() {
        return SituationRef;
    }

    /**
     * 
     * @param SituationRef
     *     The SituationRef
     */
    public void setSituationRef(List<Object> SituationRef) {
        this.SituationRef = SituationRef;
    }

    /**
     * 
     * @return
     *     The Monitored
     */
    public boolean isMonitored() {
        return Monitored;
    }

    /**
     * 
     * @param Monitored
     *     The Monitored
     */
    public void setMonitored(boolean Monitored) {
        this.Monitored = Monitored;
    }

    /**
     * 
     * @return
     *     The VehicleLocation
     */
    public com.siri.model.VehicleLocation getVehicleLocation() {
        return VehicleLocation;
    }

    /**
     * 
     * @param VehicleLocation
     *     The VehicleLocation
     */
    public void setVehicleLocation(com.siri.model.VehicleLocation VehicleLocation) {
        this.VehicleLocation = VehicleLocation;
    }

    /**
     * 
     * @return
     *     The Bearing
     */
    public float getBearing() {
        return Bearing;
    }

    /**
     * 
     * @param Bearing
     *     The Bearing
     */
    public void setBearing(float Bearing) {
        this.Bearing = Bearing;
    }

    /**
     * 
     * @return
     *     The ProgressRate
     */
    public String getProgressRate() {
        return ProgressRate;
    }

    /**
     * 
     * @param ProgressRate
     *     The ProgressRate
     */
    public void setProgressRate(String ProgressRate) {
        this.ProgressRate = ProgressRate;
    }

    /**
     * 
     * @return
     *     The ProgressStatus
     */
    public String getProgressStatus() {
        return ProgressStatus;
    }

    /**
     * 
     * @param ProgressStatus
     *     The ProgressStatus
     */
    public void setProgressStatus(String ProgressStatus) {
        this.ProgressStatus = ProgressStatus;
    }

    /**
     * 
     * @return
     *     The BlockRef
     */
    public String getBlockRef() {
        return BlockRef;
    }

    /**
     * 
     * @param BlockRef
     *     The BlockRef
     */
    public void setBlockRef(String BlockRef) {
        this.BlockRef = BlockRef;
    }

    /**
     * 
     * @return
     *     The VehicleRef
     */
    public String getVehicleRef() {
        return VehicleRef;
    }

    /**
     * 
     * @param VehicleRef
     *     The VehicleRef
     */
    public void setVehicleRef(String VehicleRef) {
        this.VehicleRef = VehicleRef;
    }

    /**
     * 
     * @return
     *     The MonitoredCall
     */
    public com.siri.model.MonitoredCall getMonitoredCall() {
        return MonitoredCall;
    }

    /**
     * 
     * @param MonitoredCall
     *     The MonitoredCall
     */
    public void setMonitoredCall(com.siri.model.MonitoredCall MonitoredCall) {
        this.MonitoredCall = MonitoredCall;
    }

    /**
     * 
     * @return
     *     The OnwardCalls
     */
    public com.siri.model.OnwardCalls getOnwardCalls() {
        return OnwardCalls;
    }

    /**
     * 
     * @param OnwardCalls
     *     The OnwardCalls
     */
    public void setOnwardCalls(com.siri.model.OnwardCalls OnwardCalls) {
        this.OnwardCalls = OnwardCalls;
    }

}
