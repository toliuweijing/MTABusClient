
package com.obanyc.api.siri;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Distances {

    @Expose
    private String PresentableDistance;
    @Expose
    private double DistanceFromCall;
    @Expose
    private long StopsFromCall;
    @Expose
    private double CallDistanceAlongRoute;

    /**
     * 
     * @return
     *     The PresentableDistance
     */
    public String getPresentableDistance() {
        return PresentableDistance;
    }

    /**
     * 
     * @param PresentableDistance
     *     The PresentableDistance
     */
    public void setPresentableDistance(String PresentableDistance) {
        this.PresentableDistance = PresentableDistance;
    }

    public Distances withPresentableDistance(String PresentableDistance) {
        this.PresentableDistance = PresentableDistance;
        return this;
    }

    /**
     * 
     * @return
     *     The DistanceFromCall
     */
    public double getDistanceFromCall() {
        return DistanceFromCall;
    }

    /**
     * 
     * @param DistanceFromCall
     *     The DistanceFromCall
     */
    public void setDistanceFromCall(double DistanceFromCall) {
        this.DistanceFromCall = DistanceFromCall;
    }

    public Distances withDistanceFromCall(double DistanceFromCall) {
        this.DistanceFromCall = DistanceFromCall;
        return this;
    }

    /**
     * 
     * @return
     *     The StopsFromCall
     */
    public long getStopsFromCall() {
        return StopsFromCall;
    }

    /**
     * 
     * @param StopsFromCall
     *     The StopsFromCall
     */
    public void setStopsFromCall(long StopsFromCall) {
        this.StopsFromCall = StopsFromCall;
    }

    public Distances withStopsFromCall(long StopsFromCall) {
        this.StopsFromCall = StopsFromCall;
        return this;
    }

    /**
     * 
     * @return
     *     The CallDistanceAlongRoute
     */
    public double getCallDistanceAlongRoute() {
        return CallDistanceAlongRoute;
    }

    /**
     * 
     * @param CallDistanceAlongRoute
     *     The CallDistanceAlongRoute
     */
    public void setCallDistanceAlongRoute(double CallDistanceAlongRoute) {
        this.CallDistanceAlongRoute = CallDistanceAlongRoute;
    }

    public Distances withCallDistanceAlongRoute(double CallDistanceAlongRoute) {
        this.CallDistanceAlongRoute = CallDistanceAlongRoute;
        return this;
    }

}
