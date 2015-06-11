
package com.obanyc.api.where.stopsforlocation;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Route {

    @Expose
    private Agency agency;
    @Expose
    private String color;
    @Expose
    private String description;
    @Expose
    private String id;
    @Expose
    private String longName;
    @Expose
    private String shortName;
    @Expose
    private String textColor;
    @Expose
    private long type;
    @Expose
    private String url;

    /**
     * 
     * @return
     *     The agency
     */
    public Agency getAgency() {
        return agency;
    }

    /**
     * 
     * @param agency
     *     The agency
     */
    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Route withAgency(Agency agency) {
        this.agency = agency;
        return this;
    }

    /**
     * 
     * @return
     *     The color
     */
    public String getColor() {
        return color;
    }

    /**
     * 
     * @param color
     *     The color
     */
    public void setColor(String color) {
        this.color = color;
    }

    public Route withColor(String color) {
        this.color = color;
        return this;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Route withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Route withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The longName
     */
    public String getLongName() {
        return longName;
    }

    /**
     * 
     * @param longName
     *     The longName
     */
    public void setLongName(String longName) {
        this.longName = longName;
    }

    public Route withLongName(String longName) {
        this.longName = longName;
        return this;
    }

    /**
     * 
     * @return
     *     The shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 
     * @param shortName
     *     The shortName
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Route withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    /**
     * 
     * @return
     *     The textColor
     */
    public String getTextColor() {
        return textColor;
    }

    /**
     * 
     * @param textColor
     *     The textColor
     */
    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public Route withTextColor(String textColor) {
        this.textColor = textColor;
        return this;
    }

    /**
     * 
     * @return
     *     The type
     */
    public long getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(long type) {
        this.type = type;
    }

    public Route withType(long type) {
        this.type = type;
        return this;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public Route withUrl(String url) {
        this.url = url;
        return this;
    }

}
