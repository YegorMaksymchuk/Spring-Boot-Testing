package com.company.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RestFilmTest {

	private static final String BASE_URL = "http://localhost:8080/film";
	private RestTemplate restTemplate;

	@Before
	public void setup() {
		restTemplate = new RestTemplate();
	}


	@Test
	public void canGetFilmById() {
		ResponseEntity<String> response
				= restTemplate.getForEntity(BASE_URL + "/2", String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}


	@Test
	public void canGetListOfFilm() {
		ResponseEntity<String> response
				= restTemplate.getForEntity(BASE_URL + "/list", String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
}
