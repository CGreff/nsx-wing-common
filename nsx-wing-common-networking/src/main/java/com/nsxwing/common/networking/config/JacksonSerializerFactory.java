package com.nsxwing.common.networking.config;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.factories.SerializerFactory;

public class JacksonSerializerFactory implements SerializerFactory {
	@Override
	public Serializer makeSerializer(Kryo kryo, Class<?> type) {
		return new JacksonSerializer();
	}
}
