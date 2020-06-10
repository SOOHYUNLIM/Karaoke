package com.amazonaws.lambda.crawl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.amazonaws.lambda.dto.SongDto;
import com.amazonaws.lambda.util.HttpUtil;
import com.amazonaws.lambda.util.StringUtil;

public class GeumyongCrawling {

	private static final String url = "http://www.ikaraoke.kr/isong/genre_hit.asp";

	private static List<String> eachText(Elements elements) {
		ArrayList<String> texts = new ArrayList<>(elements.size());
		elements.forEach(el -> texts.add(el.hasText() ? el.text() : ""));
		return texts;
	}

	private static SongDto mapper(Elements elements) {
		List<String> data = eachText(elements);
		return SongDto.builder().title(data.get(4)).singer(data.get(5)).composer(data.get(6)).writer(data.get(6))
				.creationDate(StringUtil.fomatLocalDate("yyyy.MM.dd", data.get(7))).lyrics(data.get(8)).build();
	}

	public static List<SongDto> getChart(GeumyoungParam param) {
		List<SongDto> result = new ArrayList<>();
		String queryString = HttpUtil.objectToQueryString(param);
		try {
			Document document = Jsoup.connect(url + queryString).get();
			List<Element> rows = document.getElementsByTag("tr");
			rows.remove(0);

			Function<Element, SongDto> function = el -> mapper(el.children());
			result = rows.stream().map(function).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}