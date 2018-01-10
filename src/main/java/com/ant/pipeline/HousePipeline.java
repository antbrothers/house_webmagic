package com.ant.pipeline;

import com.ant.common.SendHTMLEmail;
import com.ant.model.house.Areas;
import com.ant.model.house.Houses;
import com.ant.service.AreasService;
import com.ant.service.HousesService;
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
    @Override
    public void process(ResultItems resultItems, Task task) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-beans.xml");
        // 添加区域
        AreasService areasService = (AreasService) ac.getBean(AreasService.class);
        ArrayList<Areas> areas = resultItems.get("repo");
        for (int i = 0; i< areas.size(); i++) {
            Areas areas1 = areasService.selectAreasByCode(areas.get(i).getCode());
            System.out.println(areas1);
            if (areas1 == null) {
                areasService.insert(areas.get(i));
            }
        }
        // 添加所有楼盘
        HousesService hservice = (HousesService) ac.getBean(HousesService.class);
        ArrayList<Houses> houses = resultItems.get("houses");
        for (int i = 0; i < houses.size(); i++) {
            Houses houses1 = hservice.selectHousesByTitle(houses.get(i).getTitle());
            if (houses1 == null) {
                hservice.insert(houses.get(i));
                SendHTMLEmail.Send(houses.get(i));
            }
        }
    }

}
