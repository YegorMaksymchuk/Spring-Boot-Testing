package com.company.rest;

import com.company.model.Film;
import com.company.service.FilmService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(value = "film", description = "Api for work with simple film knowledge base service.")
@Slf4j
@Controller
@RequestMapping(value = "/film")
public class FilmRestController {

	private final FilmService filmService;

	@Autowired
	public FilmRestController(FilmService filmService) {
		this.filmService = filmService;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Film> getFilm(@RequestParam Long id) {
		return new ResponseEntity<>(filmService.getById(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Film>> getAllFilms() {
		return new ResponseEntity<>(filmService.findAllFilms(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/bydirector", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Film>> findBooksByAuthor(@RequestParam String director) {
		return new ResponseEntity<>(filmService.findFilmsByDirector(director), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity deleteFilm(@RequestParam Long id) {
		filmService.delete(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity addFilm(@RequestBody Film film) {
		return new ResponseEntity(filmService.add(film), HttpStatus.OK);
	}

	public ResponseEntity<Film> updateFilm() {
		return null;
	}

}
