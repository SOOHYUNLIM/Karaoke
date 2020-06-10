//package com.amazonaws.lambda.demo;
//
//import java.util.List;
//
//import com.amazonaws.lambda.dto.SongDto;
//import com.amazonaws.lambda.service.CrawlService;
//import com.amazonaws.lambda.service.impl.GeumyoungServiceImpl;
//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//
//public class KaraokeChart implements RequestHandler<Object, List<SongDto>> {
//
//    @Override
//    public List<SongDto> handleRequest(Object input, Context context) {
//    	
//        CrawlService<SongDto> crawlService = new GeumyoungServiceImpl();
//        
//        return crawlService.getChart();
//    	
//    }
//
//}
