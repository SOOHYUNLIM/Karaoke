package com.amazonaws.lambda.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import lombok.SneakyThrows;

public final class ObjectUtil {

	@SneakyThrows
	public static <T> Map<String, String> objectToMap(T object) {
		Map<String, String> map = new HashMap<>();
		
		Field[] fields = object.getClass().getDeclaredFields();
		for(Field field : fields) {
			field.setAccessible(true);
			String value = field.get(object) == null ? "" : String.valueOf(field.get(object));
			
			map.put(field.getName(), value);
		}
		
		return map;
	}
	
	@SneakyThrows
	public static <T> String objectToJson(T object) {
		String json = "{";
		
		Field[] fields = object.getClass().getDeclaredFields();
		
		for(Field field : fields) {
			field.setAccessible(true);
			String value = field.get(object) == null ? "" : String.valueOf(field.get(object));
			json += field.getName() + ": " + value + ", ";
		}
		
		json += "}";
		return json;
	}
}
