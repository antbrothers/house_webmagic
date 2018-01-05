package com.test.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import com.test.model.BaiDuColumn;

@Component
public class ColumnDaoImpl extends SqlSessionDaoSupport implements ColumnDao {

	@Override
	public int insert(BaiDuColumn baiDuColumn) {
		
		return this.getSqlSession().insert("com.test.model.BaiDuColumn.create", baiDuColumn);
	}
}
