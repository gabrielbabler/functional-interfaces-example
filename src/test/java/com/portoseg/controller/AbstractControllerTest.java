package com.portoseg.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Type;
import java.util.List;

/**
 * This abstract class represents a MVC Controller test
 * <p>
 * All the classes that extends this abstract class gain the capability of mock
 * REST responses using a {@link MockMvc} object
 *
 *
 * @param <T>
 *            the mocked controller type
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@SuppressWarnings("hiding")
@RunWith(SpringRunner.class)
public abstract class AbstractControllerTest<T> {

	@Autowired
	protected MockMvc mockMvc;

	protected MockHttpServletResponse response;

	private ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
	}

	@SneakyThrows
	protected <T> T stringJsonToObject(String json, Class<T> clazz) {
		return mapper.readValue(json, clazz);
	}

	@SneakyThrows
	protected <T> List<T> stringJsonToList(String json, Class<T> clazz) {
		return mapper.readValue(json, new TypeReference<List<T>>() {
			@Override
			public Type getType() {
				return mapper.getTypeFactory().constructCollectionType(List.class, clazz);
			}
		});
	}

	@SneakyThrows
	protected String objectToStringJson(Object object) {
		return mapper.writeValueAsString(object);
	}

}