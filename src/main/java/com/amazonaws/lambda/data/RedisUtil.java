package com.amazonaws.lambda.data;

import java.util.List;
import java.util.UUID;

import com.amazonaws.lambda.util.ObjectUtil;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public final class RedisUtil {

	private static final RedisURI redisUri = RedisURI.Builder
			.redis("karaoke-cache.s2oqff.ng.0001.apn2.cache.amazonaws.com", 6379).build();

	public static void saveList(String key, List<?> list) {
		RedisClient redisClient = RedisClient.create(redisUri);
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();

		System.out.println("====입력 시작====");

//
//
//		list.stream().map(ObjectUtil::objectToJson).forEach(map -> {
////			String uuid = UUID.randomUUID().toString().replace("-", "");
////
////			System.out.println(uuid);
//			syncCommands.lpu
//			syncCommands.set(key, map);
//		});
		String[] values = list.stream().map(ObjectUtil::objectToJson).toArray(String[]::new);
		
		syncCommands.del(key);
		
		syncCommands.lpush(key, values);
		
		connection.close();
		redisClient.shutdown();
		System.out.println("====입력 완료====");
	}

	public static List<?> getList() {
		return null;
	}

	public static String test() {
		RedisClient redisClient = RedisClient.create(redisUri);
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();

//		String result = syncCommands.get("BALLADE");
		String result = syncCommands.rpop("BALLADE");
		
		redisClient.shutdown();
		return result;
	}
}
