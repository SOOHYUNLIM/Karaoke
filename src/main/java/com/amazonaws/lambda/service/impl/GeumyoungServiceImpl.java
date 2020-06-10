package com.amazonaws.lambda.service.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.amazonaws.lambda.crawl.GeumyongCrawling;
import com.amazonaws.lambda.crawl.Geumyoung;
import com.amazonaws.lambda.data.RedisUtil;
import com.amazonaws.lambda.domain.Song;
import com.amazonaws.lambda.dto.SongDto;
import com.amazonaws.lambda.service.CrawlService;
import com.amazonaws.lambda.util.Youtube;

public class GeumyoungServiceImpl implements CrawlService<SongDto> {

	@Override
	public void crawlAndSaveCache() {
		AtomicInteger rank = new AtomicInteger();
		Function<SongDto, Song> function = dto -> {
			dto.setRank(rank.incrementAndGet());
			dto.setYoutube(Youtube.search(dto.getTitle() + " 노래방"));
			System.out.println(dto);
			return dto.toEntity();
		};
		for (Geumyoung category : Geumyoung.values()) {
			//요부분을 멀티 쓰레드 사용할 것!
			List<Song> chart = GeumyongCrawling.getChart(category.getParams()).stream().map(function)
					.collect(Collectors.toList());
			RedisUtil.saveList(chart);
		}
	}

	@Override
	public List<SongDto> getChart() {
		// TODO Auto-generated method stub
		return null;
	}
}
