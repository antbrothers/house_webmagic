package com.test.pageprocessor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.test.model.BaiDuColumn;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

public class ColumnPageprocessor implements PageProcessor {
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000 * 30);

	@Override
	public Site getSite() {

		return site;
	}

	@Override
	public void process(Page page) {

		Selectable xpath = page.getHtml().xpath("//div[@id='wrapper']//p[@id='nv']/a");
		List<Selectable> nodes = xpath.nodes();
		List<BaiDuColumn> finalResult = new ArrayList<BaiDuColumn>();
		for (Selectable node : nodes) {
			BaiDuColumn tmp = new BaiDuColumn();
			tmp.setCreatedate(new Date());
			String name = node.xpath("a/text()").toString();
			tmp.setColumnName(name);
			finalResult.add(tmp);
		}
		page.putField("repo", finalResult);
	}

}
