
package com.obanyc.api.siri;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class VehicleLocation {

    @Expose
    private double Longitude;
    @Expose
    private double Latitude;

    /**
     * 
     * @return
     *     The Longitude
     */
    public double getLongitude() {
        return Longitude;
    }

    /**
     * 
     * @param Longitude
     *     The Longitude
     */
    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }

    public VehicleLocation withLongitude(double Longitude) {
        this.Longitude = Longitude;
        return this;
    }

    /**
     * 
     * @return
     *     The Latitude
     */
    public double getLatitude() {
        return Latitude;
    }

    /**
     * 
     * @param Latitude
     *     The Latitude
     */
    public void setLatitude(double Latitude) {
        this.Latitude = Latitude;
    }

    public VehicleLocation withLatitude(double Latitude) {
        this.Latitude = Latitude;
        return this;
    }

}
