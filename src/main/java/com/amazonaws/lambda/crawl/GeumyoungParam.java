package com.amazonaws.lambda.crawl;

import lombok.Getter;

@Getter
public class GeumyoungParam {

	private final int page = 1;
	
	private int songGb;
	
	private int gbSeq;
	
	public GeumyoungParam(int songGb, int gbSeq) {
		this.songGb = songGb;
		this.gbSeq = gbSeq;
	}
}