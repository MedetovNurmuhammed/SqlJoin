package model;

import java.util.List;

public class Phone {
    //hone (id, name, brand, contacts(List)) полелери болуш керек.
    private int id;
    private String name;
    private String brand;
    private List<Contact>contactList;

    public Phone() {
    }

    public Phone(int id, String name, String brand, List<Contact> contactList) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.contactList = contactList;
    }

    public Phone(String рррр) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", contactList=" + contactList +
                '}';
    }
}
