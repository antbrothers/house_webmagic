package com.ant.service.impl;

import com.ant.dao.AreasDao;
import com.ant.model.house.Areas;
import com.ant.service.AreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/1/8.
 */
@Component
public class AreasServiceImpl implements AreasService {
    @Autowired
    private AreasDao areasDao;
    @Override
    public int insert(Areas areas) {
        return areasDao.insert(areas);
    }
    @Override
    public Areas selectAreasByCode(String code) {
        return areasDao.selectAreasByCode(code);
    }

}
