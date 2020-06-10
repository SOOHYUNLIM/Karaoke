package com.amazonaws.lambda.util;

import java.net.URLEncoder;

import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class YoutubeParam {

	private String key = "AIzaSyAV9lr7dk5YCCRsslpIpsKd-15JP7kJPk4";
	
	private String part = "id";
	
	private String type = "video";
	
	private int maxResults = 10;
	
	private boolean videoEmbeddable = true;
	
	private String q;
	
	@SneakyThrows
	public YoutubeParam(String search) {
		this.q = URLEncoder.encode(search,"UTF-8");
	}
}
