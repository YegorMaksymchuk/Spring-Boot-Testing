package com.company.service;

import com.company.model.Film;
import com.company.repository.FilmRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class FilmServiceImpl implements FilmService {
	@Autowired
	private FilmRepository filmRepository;

	@Override
	public List<Film> addFilms(Map<String, String> films) {
		return null;
	}

	@Override
	public List<Film> findFilmsByDirector(String director) {
		return filmRepository.findByDirector(director);
	}

	@Override
	public List<Film> findAllFilms() {
		return filmRepository.findAll();
	}
}
