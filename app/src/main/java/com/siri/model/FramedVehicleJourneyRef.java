
package com.siri.model;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class FramedVehicleJourneyRef {

    @Expose
    private String DataFrameRef;
    @Expose
    private String DatedVehicleJourneyRef;

    /**
     * 
     * @return
     *     The DataFrameRef
     */
    public String getDataFrameRef() {
        return DataFrameRef;
    }

    /**
     * 
     * @param DataFrameRef
     *     The DataFrameRef
     */
    public void setDataFrameRef(String DataFrameRef) {
        this.DataFrameRef = DataFrameRef;
    }

    /**
     * 
     * @return
     *     The DatedVehicleJourneyRef
     */
    public String getDatedVehicleJourneyRef() {
        return DatedVehicleJourneyRef;
    }

    /**
     * 
     * @param DatedVehicleJourneyRef
     *     The DatedVehicleJourneyRef
     */
    public void setDatedVehicleJourneyRef(String DatedVehicleJourneyRef) {
        this.DatedVehicleJourneyRef = DatedVehicleJourneyRef;
    }

}
