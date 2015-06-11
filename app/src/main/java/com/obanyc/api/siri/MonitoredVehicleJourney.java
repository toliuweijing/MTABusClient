
package com.obanyc.api.siri;

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
    private com.obanyc.api.siri.FramedVehicleJourneyRef FramedVehicleJourneyRef;
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
    private com.obanyc.api.siri.VehicleLocation VehicleLocation;
    @Expose
    private double Bearing;
    @Expose
    private String ProgressRate;
    @Expose
    private String ProgressStatus;
    @Expose
    private String BlockRef;
    @Expose
    private String VehicleRef;
    @Expose
    private com.obanyc.api.siri.MonitoredCall MonitoredCall;
    @Expose
    private com.obanyc.api.siri.OnwardCalls OnwardCalls;

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

    public MonitoredVehicleJourney withLineRef(String LineRef) {
        this.LineRef = LineRef;
        return this;
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

    public MonitoredVehicleJourney withDirectionRef(String DirectionRef) {
        this.DirectionRef = DirectionRef;
        return this;
    }

    /**
     * 
     * @return
     *     The FramedVehicleJourneyRef
     */
    public com.obanyc.api.siri.FramedVehicleJourneyRef getFramedVehicleJourneyRef() {
        return FramedVehicleJourneyRef;
    }

    /**
     * 
     * @param FramedVehicleJourneyRef
     *     The FramedVehicleJourneyRef
     */
    public void setFramedVehicleJourneyRef(com.obanyc.api.siri.FramedVehicleJourneyRef FramedVehicleJourneyRef) {
        this.FramedVehicleJourneyRef = FramedVehicleJourneyRef;
    }

    public MonitoredVehicleJourney withFramedVehicleJourneyRef(com.obanyc.api.siri.FramedVehicleJourneyRef FramedVehicleJourneyRef) {
        this.FramedVehicleJourneyRef = FramedVehicleJourneyRef;
        return this;
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

    public MonitoredVehicleJourney withJourneyPatternRef(String JourneyPatternRef) {
        this.JourneyPatternRef = JourneyPatternRef;
        return this;
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

    public MonitoredVehicleJourney withPublishedLineName(String PublishedLineName) {
        this.PublishedLineName = PublishedLineName;
        return this;
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

    public MonitoredVehicleJourney withOperatorRef(String OperatorRef) {
        this.OperatorRef = OperatorRef;
        return this;
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

    public MonitoredVehicleJourney withOriginRef(String OriginRef) {
        this.OriginRef = OriginRef;
        return this;
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

    public MonitoredVehicleJourney withDestinationRef(String DestinationRef) {
        this.DestinationRef = DestinationRef;
        return this;
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

    public MonitoredVehicleJourney withDestinationName(String DestinationName) {
        this.DestinationName = DestinationName;
        return this;
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

    public MonitoredVehicleJourney withOriginAimedDepartureTime(String OriginAimedDepartureTime) {
        this.OriginAimedDepartureTime = OriginAimedDepartureTime;
        return this;
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

    public MonitoredVehicleJourney withSituationRef(List<Object> SituationRef) {
        this.SituationRef = SituationRef;
        return this;
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

    public MonitoredVehicleJourney withMonitored(boolean Monitored) {
        this.Monitored = Monitored;
        return this;
    }

    /**
     * 
     * @return
     *     The VehicleLocation
     */
    public com.obanyc.api.siri.VehicleLocation getVehicleLocation() {
        return VehicleLocation;
    }

    /**
     * 
     * @param VehicleLocation
     *     The VehicleLocation
     */
    public void setVehicleLocation(com.obanyc.api.siri.VehicleLocation VehicleLocation) {
        this.VehicleLocation = VehicleLocation;
    }

    public MonitoredVehicleJourney withVehicleLocation(com.obanyc.api.siri.VehicleLocation VehicleLocation) {
        this.VehicleLocation = VehicleLocation;
        return this;
    }

    /**
     * 
     * @return
     *     The Bearing
     */
    public double getBearing() {
        return Bearing;
    }

    /**
     * 
     * @param Bearing
     *     The Bearing
     */
    public void setBearing(double Bearing) {
        this.Bearing = Bearing;
    }

    public MonitoredVehicleJourney withBearing(double Bearing) {
        this.Bearing = Bearing;
        return this;
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

    public MonitoredVehicleJourney withProgressRate(String ProgressRate) {
        this.ProgressRate = ProgressRate;
        return this;
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

    public MonitoredVehicleJourney withProgressStatus(String ProgressStatus) {
        this.ProgressStatus = ProgressStatus;
        return this;
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

    public MonitoredVehicleJourney withBlockRef(String BlockRef) {
        this.BlockRef = BlockRef;
        return this;
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

    public MonitoredVehicleJourney withVehicleRef(String VehicleRef) {
        this.VehicleRef = VehicleRef;
        return this;
    }

    /**
     * 
     * @return
     *     The MonitoredCall
     */
    public com.obanyc.api.siri.MonitoredCall getMonitoredCall() {
        return MonitoredCall;
    }

    /**
     * 
     * @param MonitoredCall
     *     The MonitoredCall
     */
    public void setMonitoredCall(com.obanyc.api.siri.MonitoredCall MonitoredCall) {
        this.MonitoredCall = MonitoredCall;
    }

    public MonitoredVehicleJourney withMonitoredCall(com.obanyc.api.siri.MonitoredCall MonitoredCall) {
        this.MonitoredCall = MonitoredCall;
        return this;
    }

    /**
     * 
     * @return
     *     The OnwardCalls
     */
    public com.obanyc.api.siri.OnwardCalls getOnwardCalls() {
        return OnwardCalls;
    }

    /**
     * 
     * @param OnwardCalls
     *     The OnwardCalls
     */
    public void setOnwardCalls(com.obanyc.api.siri.OnwardCalls OnwardCalls) {
        this.OnwardCalls = OnwardCalls;
    }

    public MonitoredVehicleJourney withOnwardCalls(com.obanyc.api.siri.OnwardCalls OnwardCalls) {
        this.OnwardCalls = OnwardCalls;
        return this;
    }

}
