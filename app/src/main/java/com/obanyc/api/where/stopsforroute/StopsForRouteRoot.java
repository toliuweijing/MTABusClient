
package com.obanyc.api.where.stopsforroute;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class StopsForRouteRoot {

    @Expose
    private long code;
    @Expose
    private long currentTime;
    @Expose
    private Data data;
    @Expose
    private String text;
    @Expose
    private long version;

    /**
     * 
     * @return
     *     The code
     */
    public long getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(long code) {
        this.code = code;
    }

    public StopsForRouteRoot withCode(long code) {
        this.code = code;
        return this;
    }

    /**
     * 
     * @return
     *     The currentTime
     */
    public long getCurrentTime() {
        return currentTime;
    }

    /**
     * 
     * @param currentTime
     *     The currentTime
     */
    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public StopsForRouteRoot withCurrentTime(long currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    /**
     * 
     * @return
     *     The data
     */
    public Data getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(Data data) {
        this.data = data;
    }

    public StopsForRouteRoot withData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * 
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    public StopsForRouteRoot withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * 
     * @return
     *     The version
     */
    public long getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    public void setVersion(long version) {
        this.version = version;
    }

    public StopsForRouteRoot withVersion(long version) {
        this.version = version;
        return this;
    }

}
