package com.amazonaws.lambda.crawl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Geumyoung {
	BALLADE(2, 12),
	DANCE(2, 6);
	
	private int songGb;
	
	private int gbSeq;

	public GeumyoungParam getParams() {
		return new GeumyoungParam(this.songGb, this.gbSeq);
	}
}