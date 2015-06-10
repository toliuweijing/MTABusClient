
package com.siri.model;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class VehicleLocation {

    @Expose
    private float Longitude;
    @Expose
    private float Latitude;

    /**
     * 
     * @return
     *     The Longitude
     */
    public float getLongitude() {
        return Longitude;
    }

    /**
     * 
     * @param Longitude
     *     The Longitude
     */
    public void setLongitude(float Longitude) {
        this.Longitude = Longitude;
    }

    /**
     * 
     * @return
     *     The Latitude
     */
    public float getLatitude() {
        return Latitude;
    }

    /**
     * 
     * @param Latitude
     *     The Latitude
     */
    public void setLatitude(float Latitude) {
        this.Latitude = Latitude;
    }

}
