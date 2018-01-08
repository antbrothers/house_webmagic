package com.ant.model.house;

/**
 * Created by Administrator on 2018/1/8.
 */

import java.util.Date;

/**
 * 区域模型
 */
public class Areas {
    private int id;
    private String code;
    private String city;
    private Date createDate;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "AreasDao{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", city='" + city + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
