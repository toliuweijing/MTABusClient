
package com.obanyc.api.siri;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Extensions {

    @Expose
    private com.obanyc.api.siri.Distances Distances;

    /**
     * 
     * @return
     *     The Distances
     */
    public com.obanyc.api.siri.Distances getDistances() {
        return Distances;
    }

    /**
     * 
     * @param Distances
     *     The Distances
     */
    public void setDistances(com.obanyc.api.siri.Distances Distances) {
        this.Distances = Distances;
    }

    public Extensions withDistances(com.obanyc.api.siri.Distances Distances) {
        this.Distances = Distances;
        return this;
    }

}
