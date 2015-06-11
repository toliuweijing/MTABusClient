
package com.obanyc.api.where.scheduleforstop;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Data {

    @Expose
    private Entry entry;
    @Expose
    private References references;

    /**
     * 
     * @return
     *     The entry
     */
    public Entry getEntry() {
        return entry;
    }

    /**
     * 
     * @param entry
     *     The entry
     */
    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public Data withEntry(Entry entry) {
        this.entry = entry;
        return this;
    }

    /**
     * 
     * @return
     *     The references
     */
    public References getReferences() {
        return references;
    }

    /**
     * 
     * @param references
     *     The references
     */
    public void setReferences(References references) {
        this.references = references;
    }

    public Data withReferences(References references) {
        this.references = references;
        return this;
    }

}
