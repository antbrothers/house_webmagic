package com.ant.dao.impl;

import com.ant.dao.ColumnDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import com.ant.model.BaiDuColumn;

@Component
public class ColumnDaoImpl extends SqlSessionDaoSupport implements ColumnDao {
	@Override
	public int insert(BaiDuColumn baiDuColumn) {
		return this.getSqlSession().insert("com.ant.model.BaiDuColumn.create", baiDuColumn);
	}
}
