package com.amazonaws.lambda.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import lombok.SneakyThrows;

public final class HttpUtil {

	public static String objectToQueryString(Object object) {
		String queryString = "?";
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				queryString += field.getName() + "=" + String.valueOf(field.get(object)) + "&";
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return queryString;
	}

	@SneakyThrows
	public static String httpGet(String baseUrl, Object params) {
		String queryString = HttpUtil.objectToQueryString(params);
		HttpEntity responseBody = HttpClientBuilder.create().build().execute(new HttpGet(baseUrl + queryString))
				.getEntity();
		return EntityUtils.toString(responseBody);
	}
}