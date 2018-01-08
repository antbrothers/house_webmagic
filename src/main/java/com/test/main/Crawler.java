package com.ant.main;

import com.ant.pageprocessor.HousePageProcessor;
import us.codecraft.webmagic.Spider;
import com.ant.pipeline.HousePipeline;

public class Crawler {

	public static void main(String[] args) {
		
		Spider.create(new HousePageProcessor())
				.addUrl("http://sh.fang.lianjia.com/")
				.addPipeline(new HousePipeline())
				.thread(1)
				.run();
	}
}
