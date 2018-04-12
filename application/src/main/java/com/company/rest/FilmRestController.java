package com.company.rest;

import com.company.model.Film;
import com.company.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/film")
public class FilmRestController {

	private final FilmService filmService;

	public FilmRestController(FilmService filmService) {
		this.filmService = filmService;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/producer")
	public List<Film> findBooksByAuthor(@RequestParam String producer) {
		return filmService.findFilmsByProducer(producer);
	}


}
