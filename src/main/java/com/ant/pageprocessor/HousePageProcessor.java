package com.ant.pageprocessor;

import com.ant.model.house.Areas;
import com.ant.model.house.Houses;
import org.apache.ibatis.annotations.Select;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/1/8.
 */
public class HousePageProcessor implements PageProcessor {
    private Site site = Site.me().setRetrySleepTime(3).setSleepTime(1000 * 30);
    @Override
    public void process(Page page) {
        // 抓取区域
        Selectable xpath = page.getHtml().xpath("//div[@id='filter-options']//dl[1]//div[@class='option-list']/a");
        List<Selectable> nodes = xpath.nodes();
        List<Areas> areas = new ArrayList<Areas>();
        for (Selectable node : nodes) {
            Areas tmp = new Areas();
            tmp.setCreateDate(new Date());
            String code = node.xpath("a/@actdata").toString() != "" ? node.xpath("a/@actdata").toString().split(":")[1] : "不限";
            String text = node.xpath("a/text()").toString();
            tmp.setCode(code);
            tmp.setCity(text);
            areas.add(tmp);
        }
        page.putField("repo", areas);

        // 抓取所有新的楼盘
        Selectable xpath2 = page.getHtml().xpath("//div[@id='list-box']//div[@class='house-lst']//li[@class='block-item']//div[@class='info-panel']");
        List<Selectable> nodes2 = xpath2.nodes();
        List<Houses> houses = new ArrayList<Houses>();
        for (Selectable node: nodes2) {
            Houses h = new Houses();
            h.setCreateDate(new Date());
            String code = "上海";
            h.setCityCode(code);

            String[] city = node.xpath("a[@class='region']/text()").toString().split("】")[0].split(" ");
            String[] area = city[1].split("【");
            h.setArea(area[1]);
            h.setTown(city[2]);
            String title = node.xpath("a[@id='nameShow']/text()").toString();
            h.setTitle(title);
            String address = node.xpath("a[@class='region']/text()").toString();
            h.setAddress(address);
            String mj = node.xpath("a[@class='area']/text()").toString();
            h.setAcreage(mj);
            String trafic = node.xpath("span[@class='subway']/text()").toString();
            h.setTraffic(trafic);
            String price = node.xpath("span[@class='num']/text()").toString();
            h.setPrice(price);
            String state = node.xpath("span[@class='status label']/text()").toString();
            h.setState(state.equals("在售") ? "1" : "2");

            String link = node.xpath("a[@id='nameShow']").links().toString();
            h.setLink(link);
            houses.add(h);
        }
        page.putField("houses", houses);

            // 添加分页链接
        int allPage = Integer.parseInt(page.getHtml().xpath("//div[@id='list-pagination']/@data-totalpage").toString());
        System.out.println(allPage);
        List<String> pageRequest = new ArrayList<String>();
        for (int i = 1; i <= allPage; i ++) {
            pageRequest.add("http://sh.fang.lianjia.com/loupan/pg" + i);
        }
        page.addTargetRequests(pageRequest);
    }
    @Override
    public Site getSite() {
        return site;
    }
}
