package com.ant.pipeline;

import com.ant.model.house.Areas;
import com.ant.service.AreasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/8.
 */
public class HousePipeline implements Pipeline{
    private static Logger log = LoggerFactory.getLogger(HousePipeline.class);
    @Override
    public void process(ResultItems resultItems, Task task) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-beans.xml");
        AreasService areasService = (AreasService) ac.getBean(AreasService.class);
        ArrayList<Areas> areas = resultItems.get("repo");
        for (int i = 0; i< areas.size(); i++) {
            System.out.println(areas.get(i));
            log.info("34232");
            areasService.insert(areas.get(i));
        }
    }

}
