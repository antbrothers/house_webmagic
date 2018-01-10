package com.ant.dao;

import com.ant.model.house.Houses;

/**
 * Created by Administrator on 2018/1/9.
 */
public interface HousesDao {
    public int insert(Houses houses);
    public Houses selectHousesByTitle(String title);
}
