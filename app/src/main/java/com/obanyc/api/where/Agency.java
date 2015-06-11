
package com.obanyc.api.where;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Agency {

    @Expose
    private String disclaimer;
    @Expose
    private String id;
    @Expose
    private String lang;
    @Expose
    private String name;
    @Expose
    private String phone;
    @Expose
    private boolean privateService;
    @Expose
    private String timezone;
    @Expose
    private String url;

    /**
     * 
     * @return
     *     The disclaimer
     */
    public String getDisclaimer() {
        return disclaimer;
    }

    /**
     * 
     * @param disclaimer
     *     The disclaimer
     */
    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Agency withDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
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

    public Agency withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * 
     * @param lang
     *     The lang
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    public Agency withLang(String lang) {
        this.lang = lang;
        return this;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Agency withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agency withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * 
     * @return
     *     The privateService
     */
    public boolean isPrivateService() {
        return privateService;
    }

    /**
     * 
     * @param privateService
     *     The privateService
     */
    public void setPrivateService(boolean privateService) {
        this.privateService = privateService;
    }

    public Agency withPrivateService(boolean privateService) {
        this.privateService = privateService;
        return this;
    }

    /**
     * 
     * @return
     *     The timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * 
     * @param timezone
     *     The timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Agency withTimezone(String timezone) {
        this.timezone = timezone;
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

    public Agency withUrl(String url) {
        this.url = url;
        return this;
    }

}
