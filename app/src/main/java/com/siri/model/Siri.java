
package com.siri.model;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Siri {

    @Expose
    private com.siri.model.ServiceDelivery ServiceDelivery;

    /**
     * 
     * @return
     *     The ServiceDelivery
     */
    public com.siri.model.ServiceDelivery getServiceDelivery() {
        return ServiceDelivery;
    }

    /**
     * 
     * @param ServiceDelivery
     *     The ServiceDelivery
     */
    public void setServiceDelivery(com.siri.model.ServiceDelivery ServiceDelivery) {
        this.ServiceDelivery = ServiceDelivery;
    }

}
