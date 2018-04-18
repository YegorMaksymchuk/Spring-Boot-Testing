package com.company.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class NewFeatureTest {
	private static final String BASE_URL = "http://localhost:8080/film";
	private static final String RESOURCE = "/bydirector" + "?";
	private static final String DIRECTOR = "director=";
	private static final String DATA = "Peter_Jackson";
	private RestTemplate restTemplate;

	@Before
	public void setup() {
		restTemplate = new RestTemplate();
	}

	@Test
	public void canGetListOfFilm() {
		ResponseEntity<String> response
				= restTemplate.getForEntity(BASE_URL + RESOURCE + DIRECTOR + DATA, String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(response.getBody(), notNullValue());
	}


}
