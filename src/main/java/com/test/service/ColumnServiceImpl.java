package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.dao.ColumnDao;
import com.test.model.BaiDuColumn;

@Component
public class ColumnServiceImpl implements ColumnService {

	@Autowired
	private ColumnDao columnDao;

	@Override
	public int insert(BaiDuColumn baiDuColumn) {
		
		return columnDao.insert(baiDuColumn);
	}

}
