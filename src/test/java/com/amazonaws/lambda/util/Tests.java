package com.amazonaws.lambda.util;

import org.junit.Test;

import com.amazonaws.lambda.dto.SongDto;
import com.amazonaws.lambda.service.CrawlService;
import com.amazonaws.lambda.service.impl.GeumyoungServiceImpl;

public class Tests {

	@Test
	public void test() {
		CrawlService<SongDto> service = new GeumyoungServiceImpl();
		service.crawlAndSaveCache();
	}
}
