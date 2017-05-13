package org.leftchildren.entity;

/**
 * Created by kay on 2017/5/1.
 */
public class Point {
    private String uid;

    private String title;

    private String address;

    private String lat;

    private String lng;

    private String city;

    public Point() {
    }

    public Point(String uid, String title, String address, String lat, String lng, String city) {
        this.uid = uid;
        this.title = title;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Point{" +
                "uid='" + uid + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

}
