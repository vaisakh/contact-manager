package com.contactmanager.dao;

/**
 * @author vaisakhvm
 */
public class SQLParameter {
    public String name;
    public Object value;
    public SQLType type;

    public SQLParameter(String name, Object value, SQLType type) {
        this.name = name;
        this.value = value;
        this.type = type;

    }
}


