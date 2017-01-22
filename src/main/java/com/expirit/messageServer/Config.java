package com.expirit.messageServer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.expirit.messageServer.domain.Status;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Configuration
public class Config {

	@Bean
	public OkHttpClient okHttpClient() {
		return new OkHttpClient().newBuilder().build();
	}

	@Bean
	public Retrofit retrofit(OkHttpClient client) {
		return new Retrofit.Builder().baseUrl("http://localhost:8080").client(client)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
	}

	@Bean
	public RedisTemplate<String, Status> redisTemplate() {
		RedisTemplate<String, Status> template = new RedisTemplate<String, Status>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
		jedisConFactory.setHostName("localhost");
		jedisConFactory.setPort(6379);
		return jedisConFactory;
	}
}
