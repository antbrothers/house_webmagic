package com.test.main;

import us.codecraft.webmagic.Spider;

import com.test.pageprocessor.ColumnPageprocessor;
import com.test.pipeline.ColumnPipeline;

public class Crawler {

	public static void main(String[] args) {
		
		Spider.create(new ColumnPageprocessor())
				.addUrl("http://www.baidu.com")
				.addPipeline(new ColumnPipeline()).thread(1).run();
	}
}
