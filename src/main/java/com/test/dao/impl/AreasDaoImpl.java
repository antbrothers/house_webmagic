package com.ant.dao.impl;

import com.ant.dao.AreasDao;
import com.ant.model.house.Areas;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/1/8.
 */
@Component
public class AreasDaoImpl extends SqlSessionDaoSupport implements AreasDao {
    @Override
    public int insert(Areas areas) {
        return this.getSqlSession().insert("com.ant.model.house.Areas.create", areas);
    }
}
