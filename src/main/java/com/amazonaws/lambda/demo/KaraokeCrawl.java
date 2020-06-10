package com.amazonaws.lambda.demo;

import com.amazonaws.lambda.data.RedisUtil;
import com.amazonaws.lambda.dto.SongDto;
import com.amazonaws.lambda.service.CrawlService;
import com.amazonaws.lambda.service.impl.GeumyoungServiceImpl;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class KaraokeCrawl implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
    	
//        CrawlService<SongDto> crawlService = new GeumyoungServiceImpl();
//        
//        crawlService.crawlAndSaveCache();
    	RedisUtil.saveList(null);
    	System.out.println(RedisUtil.test());
        return "Crawling SUCCESS!";
    }

}
