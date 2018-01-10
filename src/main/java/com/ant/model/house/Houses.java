package com.ant.model.house;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/9.
 */
public class Houses {
    private int id;
    private String cityCode;
    private String address;
    private String acreage;
    private String traffic;
    private String price;
    private String state;
    private String title;
    private String area;
    private String town;
    private String link;
    private Date createDate;

    public Houses() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Houses{" +
                "id=" + id +
                ", cityCode='" + cityCode + '\'' +
                ", address='" + address + '\'' +
                ", acreage='" + acreage + '\'' +
                ", traffic='" + traffic + '\'' +
                ", price='" + price + '\'' +
                ", state='" + state + '\'' +
                ", title='" + title + '\'' +
                ", area='" + area + '\'' +
                ", town='" + town + '\'' +
                ", link='" + link + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
