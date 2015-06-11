
package com.obanyc.api.siri;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Siri {

    @Expose
    private com.obanyc.api.siri.ServiceDelivery ServiceDelivery;

    /**
     * 
     * @return
     *     The ServiceDelivery
     */
    public com.obanyc.api.siri.ServiceDelivery getServiceDelivery() {
        return ServiceDelivery;
    }

    /**
     * 
     * @param ServiceDelivery
     *     The ServiceDelivery
     */
    public void setServiceDelivery(com.obanyc.api.siri.ServiceDelivery ServiceDelivery) {
        this.ServiceDelivery = ServiceDelivery;
    }

    public Siri withServiceDelivery(com.obanyc.api.siri.ServiceDelivery ServiceDelivery) {
        this.ServiceDelivery = ServiceDelivery;
        return this;
    }

}
