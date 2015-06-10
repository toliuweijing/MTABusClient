
package com.siri.model;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Distances {

    @Expose
    private int StopsFromCall;
    @Expose
    private float CallDistanceAlongRoute;
    @Expose
    private float DistanceFromCall;
    @Expose
    private String PresentableDistance;

    /**
     * 
     * @return
     *     The StopsFromCall
     */
    public int getStopsFromCall() {
        return StopsFromCall;
    }

    /**
     * 
     * @param StopsFromCall
     *     The StopsFromCall
     */
    public void setStopsFromCall(int StopsFromCall) {
        this.StopsFromCall = StopsFromCall;
    }

    /**
     * 
     * @return
     *     The CallDistanceAlongRoute
     */
    public float getCallDistanceAlongRoute() {
        return CallDistanceAlongRoute;
    }

    /**
     * 
     * @param CallDistanceAlongRoute
     *     The CallDistanceAlongRoute
     */
    public void setCallDistanceAlongRoute(float CallDistanceAlongRoute) {
        this.CallDistanceAlongRoute = CallDistanceAlongRoute;
    }

    /**
     * 
     * @return
     *     The DistanceFromCall
     */
    public float getDistanceFromCall() {
        return DistanceFromCall;
    }

    /**
     * 
     * @param DistanceFromCall
     *     The DistanceFromCall
     */
    public void setDistanceFromCall(float DistanceFromCall) {
        this.DistanceFromCall = DistanceFromCall;
    }

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

}
