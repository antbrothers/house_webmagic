package com.ant.pipeline;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import com.ant.model.BaiDuColumn;
import com.ant.service.ColumnService;


public class ColumnPipeline implements Pipeline {

	
	@Override
	public void process(ResultItems resultItems, Task task) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:spring-beans.xml");
		ColumnService columnService=(ColumnService) ac.getBean(ColumnService.class);
		ArrayList<BaiDuColumn> baiDuColumns = resultItems.get("repo");
		for (int i = 0; i < baiDuColumns.size(); i++) {
			columnService.insert(baiDuColumns.get(i));
			System.out.println(baiDuColumns.get(i));
		}

	}

}
