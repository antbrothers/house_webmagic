package com.ant.dao;

import com.ant.model.house.Areas;

/**
 * Created by Administrator on 2018/1/8.
 */
public interface AreasDao {
    public int insert(Areas areas);
    public Areas selectAreasByCode(String code);
}
