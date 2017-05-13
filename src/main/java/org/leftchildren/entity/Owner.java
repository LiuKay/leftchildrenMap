package org.leftchildren.entity;

/**
 * Created by kay on 2017/5/1.
 */
public class Owner {

    private String id;

    private String name;

    private long phone;

    private int gender;

    private String address;

    @Override
    public String toString() {
        return "OwnerDao{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }

    public Owner() {
    }

    public Owner(String id, String name, long phone, int gender, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
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
}
