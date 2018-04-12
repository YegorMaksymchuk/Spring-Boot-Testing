package com.company.service;

import com.company.model.Film;

import java.util.List;
import java.util.Map;

public interface FilmService {
	List<Film> addFilms(Map<String, String> films);

	List<Film> findFilmsByProducer(String producer);

	List<Film> findAllFilms();
}
