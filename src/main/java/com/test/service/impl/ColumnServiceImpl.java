package com.ant.service.impl;

import com.ant.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ant.dao.ColumnDao;
import com.ant.model.BaiDuColumn;

@Component
public class ColumnServiceImpl implements ColumnService {

	@Autowired
	private ColumnDao columnDao;

	@Override
	public int insert(BaiDuColumn baiDuColumn) {
		return columnDao.insert(baiDuColumn);
	}

}
