//package com.amazonaws.lambda.demo;
//
//import java.util.List;
//import java.util.Map;
//
//import com.amazonaws.lambda.dto.SongDto;
//import com.amazonaws.lambda.service.CrawlService;
//import com.amazonaws.lambda.service.impl.GeumyoungServiceImpl;
//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//
//public class KaraokeChart implements RequestHandler<Map<String, String>, List<SongDto>> {
//
//    @Override
//    public List<SongDto> handleRequest(Map<String, String> input, Context context) {
//    	
//        CrawlService<SongDto> crawlService = new GeumyoungServiceImpl();
//        
//        return crawlService.getChart(input.get("category"));
//    	
//    }
//
//}
