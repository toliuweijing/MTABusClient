
package com.siri.model;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class StopMonitoringDeliveryRoot {

    @Expose
    private com.siri.model.Siri Siri;

    /**
     * 
     * @return
     *     The Siri
     */
    public com.siri.model.Siri getSiri() {
        return Siri;
    }

    /**
     * 
     * @param Siri
     *     The Siri
     */
    public void setSiri(com.siri.model.Siri Siri) {
        this.Siri = Siri;
    }

}
