package com.amazonaws.lambda.dto;

import java.time.LocalDate;

import com.amazonaws.lambda.domain.Song;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class SongDto {

	private int rank;

	private String title;

	private String singer;

	private String composer;

	private String writer;

//	private LocalDate creationDate;

	private String lyrics;
	
	private String youtube;

	public Song toEntity() {
		return Song.builder().rank(rank).title(title).singer(singer).composer(composer).writer(writer)
//				.creationDate(creationDate)
				.lyrics(lyrics).youtube(youtube).build();
	}
}