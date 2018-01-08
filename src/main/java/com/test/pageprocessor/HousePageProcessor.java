package com.ant.pageprocessor;

import com.ant.model.house.Areas;
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
    }
    @Override
    public Site getSite() {

        return site;
    }
}
