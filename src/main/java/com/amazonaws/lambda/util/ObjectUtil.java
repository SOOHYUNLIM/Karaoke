package com.amazonaws.lambda.util;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

public final class ObjectUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();

	private static ModelMapper modelMapper = new ModelMapper();
	
	@SneakyThrows
	public static String objectToJson(Object object) {
		return objectMapper.writeValueAsString(object);
	}

	@SneakyThrows
	public static <T> T jsonToObject(String json, Class<T> type) {
		return objectMapper.readValue(json, type);
	}

	public static <T> T entityToDto(Object entity, Class<T> dto) {
		return modelMapper.map(entity, dto);
	}
}
