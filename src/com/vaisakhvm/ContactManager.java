package com.vaisakhvm;

public class ContactManager {

    public void addContact(String name, String address) {
        Contact contact = new Contact(name, address);
    }

    public void getContacts() {
        System.out.println("List of contacts");
    }
}
