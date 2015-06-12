
package com.obanyc.api.where.stopsforroute;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Name {

    @Expose
    private String name;
    @Expose
    private List<String> names = new ArrayList<String>();
    @Expose
    private String type;

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

    public Name withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The names
     */
    public List<String> getNames() {
        return names;
    }

    /**
     * 
     * @param names
     *     The names
     */
    public void setNames(List<String> names) {
        this.names = names;
    }

    public Name withNames(List<String> names) {
        this.names = names;
        return this;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    public Name withType(String type) {
        this.type = type;
        return this;
    }

}
