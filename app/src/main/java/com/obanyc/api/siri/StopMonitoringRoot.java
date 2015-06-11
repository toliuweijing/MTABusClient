
package com.obanyc.api.siri;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class StopMonitoringRoot {

    @Expose
    private com.obanyc.api.siri.Siri Siri;

    /**
     * 
     * @return
     *     The Siri
     */
    public com.obanyc.api.siri.Siri getSiri() {
        return Siri;
    }

    /**
     * 
     * @param Siri
     *     The Siri
     */
    public void setSiri(com.obanyc.api.siri.Siri Siri) {
        this.Siri = Siri;
    }

    public StopMonitoringRoot withSiri(com.obanyc.api.siri.Siri Siri) {
        this.Siri = Siri;
        return this;
    }

}
