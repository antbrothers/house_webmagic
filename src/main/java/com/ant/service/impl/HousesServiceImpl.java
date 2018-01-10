package com.ant.service.impl;
import com.ant.dao.HousesDao;
import com.ant.model.house.Houses;
import com.ant.service.HousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/1/9.
 */
@Component
public class HousesServiceImpl implements HousesService {
    @Autowired
    private HousesDao housesDao;
    @Override
    public int insert(Houses houses) {
        return housesDao.insert(houses);
    }
    @Override
    public Houses selectHousesByTitle(String title) {
        return housesDao.selectHousesByTitle(title);
    }
}
