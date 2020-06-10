package com.amazonaws.lambda.data;

import java.util.List;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public final class RedisUtil {

	private static final RedisURI redisUri = RedisURI.Builder
			.redis("karaoke-cache.s2oqff.ng.0001.apn2.cache.amazonaws.com", 6379).build();

	public static void saveList(List<?> list) {
		RedisClient redisClient = RedisClient.create(redisUri);
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();

		syncCommands.set("key", "Hello, Redis!");

		connection.close();
		redisClient.shutdown();
	}

	public static List<?> getList() {
		return null;
	}

	public static String test() {
		RedisClient redisClient = RedisClient.create(redisUri);
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();

		String result = syncCommands.get("key");

		connection.close();
		redisClient.shutdown();
		return result;
	}
}
