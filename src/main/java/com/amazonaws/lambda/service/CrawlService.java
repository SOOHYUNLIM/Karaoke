package com.amazonaws.lambda.service;

import java.util.List;

public interface CrawlService<T> {

	List<T> getChart(String category);
	
	void crawlAndSaveCache();
}
