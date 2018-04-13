package com.company.rest;

import com.company.model.Film;
import com.company.service.FilmService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(value = "", description = "")
@Slf4j
@Controller
@RequestMapping(value = "/film")
public class FilmRestController {

	private final FilmService filmService;

	public FilmRestController(FilmService filmService) {
		this.filmService = filmService;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Film>> getAllFilms() {
		return new ResponseEntity<>(filmService.findAllFilms(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/bydirector", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Film>> findBooksByAuthor(@RequestParam String director) {
		return new ResponseEntity<>(filmService.findFilmsByDirector(director), HttpStatus.OK);
	}


}
