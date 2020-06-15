package com.amazonaws.lambda.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
public class Song {

	private int no;
	
	private int rank;

	private String title;

	private String singer;

	private String composer;

	private String writer;

//	private LocalDate creationDate;

	private String lyrics;
	
	private String youtube;

	private LocalDateTime registerDate;

	@Builder
	public Song(int rank, String title, String singer, String composer, String writer, LocalDate creationDate, String lyrics, String youtube) {
		this.rank = rank;
		this.title = title;
		this.singer = singer;
		this.composer = composer;
		this.writer = writer;
//		this.creationDate = creationDate;
		this.lyrics = lyrics;
		this.youtube = youtube;
	}

}