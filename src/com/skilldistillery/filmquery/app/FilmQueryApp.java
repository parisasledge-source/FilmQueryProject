package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.test();
    app.launch();
	}

	private void test() {
		Film film = null;
		film = db.findFilmById(4);
		//Actor actor = db.findActorById(2);
		System.out.println(film);
		//System.out.println(actor);
//		List<Actor> actors = db.findActorsByFilmId(2);
//		System.out.println(actor);
//		System.out.println(film.getActors());
		
		for (Actor a : film.getActors()) {
			System.out.println(a);
		}
		
		
		String language = db.findLanguageByFilmId(4);
		System.out.println(language);
		
		//=======================================
		//film = db.findFilmBySearchKeyword("IDE");
		
		List<Film> film2 = db.findFilmBySearchKeyword("santa");
		for (Film b : film2) {
			System.out.println(film2);
		}
		
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {

	}

}
