package com.company.unit.service;

import com.company.model.Film;
import com.company.service.FilmService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FilmServiceImplTest {

	@Autowired
	private FilmService filmService;

	@Test
	public void canGetFilmById() {
		Film film = filmService.getById(1L).get();

	}
}
