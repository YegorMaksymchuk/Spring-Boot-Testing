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
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<Film> getFilm(@PathVariable Long id) {
		Film film = filmService.getById(id).get();
		return new ResponseEntity<>(film, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Film>> getAllFilms() {
		return new ResponseEntity<>(filmService.findAllFilms(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/bydirector", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Film>> findFilmByDirector(@RequestParam("director") String director) {
		return new ResponseEntity<>(filmService.findFilmsByDirector(director), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity deleteFilm(@PathVariable Long id) {
		filmService.delete(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity addFilm(@RequestBody Film film) {
		return new ResponseEntity(filmService.add(film), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/update/{id}")
	public ResponseEntity<Film> updateFilm(@PathVariable long id, @RequestBody Film film) {
		return new ResponseEntity<>(filmService.update(id, film), HttpStatus.OK);
	}
}
