package com.ant.dao.impl;

import com.ant.dao.HousesDao;
import com.ant.model.house.Houses;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/1/9.
 */
@Component
public class HousesDaoImpl extends SqlSessionDaoSupport implements HousesDao {
    @Override
    public int insert (Houses houses) {
        return this.getSqlSession().insert("com.ant.model.house.Houses.create", houses);
    }
    @Override
    public Houses selectHousesByTitle (String title) {
        return this.getSqlSession().selectOne("com.ant.model.house.Houses.selectHousesByTitle", title);
    }
}
