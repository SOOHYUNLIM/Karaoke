package com.amazonaws.lambda.data;

import java.util.List;
import java.util.stream.Collectors;

import com.amazonaws.lambda.util.ObjectUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public final class RedisUtil {

//	private static final RedisURI redisUri = RedisURI.Builder
//			.redis("karaoke-cache.s2oqff.0001.apn2.cache.amazonaws.com", 6379).build();
//
//	private static RedisClient redisClient = RedisClient.create(redisUri);
//
//	private static StatefulRedisConnection<String, String> connection = redisClient.connect();
//
//	private static RedisCommands<String, String> syncCommands = connection.sync();
	
	public static void saveList(String key, List<?> list) {
		RedisURI redisUri = RedisURI.Builder
				.redis("karaoke-cache.s2oqff.0001.apn2.cache.amazonaws.com", 6379).build();
		RedisClient redisClient = RedisClient.create(redisUri);
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();
		
		String[] values = list.stream().map(ObjectUtil::objectToJson).toArray(String[]::new);
		
		syncCommands.del(key);

		for (int i = 0; i < values.length; i++) {
			syncCommands.hset(key, String.valueOf(i + 1), values[i]);
		}
	}

	public static <T> List<T> getList(String key, Class<T> type) {
		RedisURI redisUri = RedisURI.Builder
				.redis("karaoke-cache.s2oqff.0001.apn2.cache.amazonaws.com", 6379).build();
		RedisClient redisClient = RedisClient.create(redisUri);
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();
		
		
		return syncCommands.hgetall(key).values().stream().map(json -> ObjectUtil.jsonToObject(json, type))
				.collect(Collectors.toList());
	}

//	public static void close() {
//		connection.close();
//		redisClient.shutdown();
//	}

}
