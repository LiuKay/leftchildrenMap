package org.leftchildren.entity;

/**
 * Created by kay on 2017/5/1.
 */
public class Volunteer {

    private String id;

    private String name;

    private int gender;

    private String address;

    private long phone;

    @Override
    public String toString() {
        return "Volunteer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }

    public Volunteer() {
    }

    public Volunteer(String id, String name, int gender, String address, long phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
