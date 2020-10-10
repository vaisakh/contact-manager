package com.vaisakhvm;

public class Contact {
    private String name;
    private String address;

    public Contact(String name, String address) {
        this.setName(name);
        this.setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }
}
