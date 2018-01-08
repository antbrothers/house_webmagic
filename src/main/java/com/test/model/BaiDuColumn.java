package com.ant.model;

import java.util.Date;

public class BaiDuColumn {

	private int id;
	private String columnName;
	private Date createdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Override
	public String toString() {
		return "BaiDuColumn [id=" + id + ", columnName=" + columnName
				+ ", createdate=" + createdate + "]"+"\n";
	}
}
