package com.amazonaws.lambda.crawl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Geumyoung {
	BALLADE(2, 12),
	DANCE(2, 6),
	RANDB(2, 15),
	HIPHOP(2, 27),
	ROCK(2, 9),
	TROT(2, 13),
	POP(19, 19),
	JPOP(13, 13),
	MEDLEY(8, 8),
	CATOON(57, 57)
	;
	
	private int songGb;
	
	private int gbSeq;

	public GeumyoungParam getParams() {
		return new GeumyoungParam(this.songGb, this.gbSeq);
	}
}