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

	@Override
	public Film getById(Long id) {
		if (filmRepository.findById(id).isPresent()) {
			return filmRepository.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public void delete(Long id) {
		filmRepository.deleteById(id);
	}

	@Override
	public Film add(Film film) {
		return filmRepository.save(film);
	}

	@Override
	public Film update(Long id, Film film) {
		Film updatedFilm = null;
		if (filmRepository.findById(id).isPresent()) {
			updatedFilm.setDirector(film.getDirector());
			updatedFilm.setName(film.getName());
			return filmRepository.save(updatedFilm);
		} else {
			return null;
		}
	}
}
