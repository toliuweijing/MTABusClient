
package com.siri.model;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Extensions {

    @Expose
    private com.siri.model.Distances Distances;

    /**
     * 
     * @return
     *     The Distances
     */
    public com.siri.model.Distances getDistances() {
        return Distances;
    }

    /**
     * 
     * @param Distances
     *     The Distances
     */
    public void setDistances(com.siri.model.Distances Distances) {
        this.Distances = Distances;
    }

}
