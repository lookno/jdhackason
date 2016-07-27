package com.jd.hackason.redis;

import redis.clients.jedis.Jedis;

public interface IRedisClient {
	public Jedis getJedis();
}
