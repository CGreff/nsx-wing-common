package com.nsxwing.common.networking.config;

import com.esotericsoftware.jsonbeans.JsonException;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;

public class JacksonSerializer<T> extends Serializer<T> {

	private ObjectMapper objectMapper = new ObjectMapper();

	public JacksonSerializer() {
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(FAIL_ON_EMPTY_BEANS, false);
	}

	@Override
	public void write(Kryo kryo, Output output, Object object) {
		try {
			objectMapper.writeValue(output, object);
		} catch (Exception ex) {
			throw new JsonException("Error writing object: " + object, ex);
		}
	}

	@Override
	public T read(Kryo kryo, Input input, Class type) {
		try {
			return (T) objectMapper.readValue(input, type);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
