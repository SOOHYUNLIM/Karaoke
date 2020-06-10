package com.amazonaws.lambda.util;

import com.google.gson.JsonParser;

import lombok.SneakyThrows;

public class Youtube {

	private static final String baseUrl = "https://www.googleapis.com/youtube/v3/search";

	@SneakyThrows
	public static String search(String search) {
		String response = HttpUtil.httpGet(baseUrl, new YoutubeParam(search));
		String videoId = JsonParser.parseString(response).getAsJsonObject().getAsJsonArray("items").get(0)
				.getAsJsonObject().getAsJsonObject("id").get("videoId").getAsString();
		return videoId;
	}
}
