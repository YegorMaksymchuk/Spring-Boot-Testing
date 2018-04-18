package com.company.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RestFilmTest {

	private static final String PROTOCOL = "http://";
	private static final String HOST = "localhost";
	private static final String PORT = ":8080";
	private static final String FILM = "/film";
	private static final String BASE_URL=PROTOCOL+HOST+PORT+FILM;


	@Before
	public void setup(){
		RestAssured.baseURI = BASE_URL;
	}

	@Test
	public void canGetFilmById(){
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json")
				.get("/2")
				.prettyPeek()
				.then()
				.statusCode(200);
	}

	@Test
	public void canGetListAllFilms(){
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json")
				.get("/list")
				.prettyPeek()
				.then()
				.statusCode(200);
	}
}
