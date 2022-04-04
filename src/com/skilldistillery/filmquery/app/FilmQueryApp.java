package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
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
		// app.test();
		app.launch();
	}

	// =======================Test Method================================
	private void test() {
		// =======================Test by Id=============================
		Film film = null;
		film = db.findFilmById(4);
		System.out.println(film);

		// Actor actor = db.findActorById(2);
		// System.out.println(actor);

		// List<Actor> actors = db.findActorsByFilmId(2);
		// System.out.println(film.getActors());

		String language = db.findLanguageByFilmId(4);
		System.out.println(language);

		for (Actor actors : film.getActors()) {
			System.out.println(actors);
		}
		// System.out.println("Double Check:");
		// System.out.println(film.getActors());
		System.out.println();

		// =======================Test by Keyword=============================
		List<Film> film2 = db.findFilmBySearchKeyword("SANTA");
		for (Film b : film2) {
			System.out.println(b.toString());
			System.out.println(b.getLanguage());

			for (Actor actors : b.getActors()) {
				System.out.println(actors);
			}
			// System.out.println("Double Check:");
			// System.out.println(b.getActors());
			System.out.println();

		}
	}

	// =======================Launch Method================================

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {

		System.out.println();
		System.out.println("**************************FILM QUERY**************************");

		int menuInput = 0;
		do {
			// Prompt the user to choose from the menu.
			System.out.println("\n");
			System.out.println("Please choose between 1 to 3 to find information about a film:");
			System.out.println("==============================================================");
			System.out.println();
			System.out.println("1: Look up a film by its id.");
			System.out.println("2: Look up a film by a search keyword.");
			System.out.println("3: Exit the application.");

			try {
				menuInput = input.nextInt();

				if (menuInput == 1) {

					// Look up a film by its id.
					System.out.println("\n");
					System.out.println("Enter the film ID: ");
					int filmId = input.nextInt();
					System.out.println("================");
					System.out.println();

					if (db.findFilmById(filmId) == null) {

						System.out.println("The film is not found!");
					} else {
						System.out.println("The film is found! \n");

						Film film = db.findFilmById(filmId);
						System.out.println("Title: " + film.getTitle() + "\nRelease Year: " + film.getReleaseYear()
								+ "\nRating: " + film.getRating() + "\nDescription: " + film.getDescription());

						String language = db.findLanguageByFilmId(filmId);
						System.out.println("Language: " + language);
						
						System.out.println("\nThe cast:\n");
						for (Actor actors : film.getActors()) {
							System.out.println(actors.getFirstName() + " " + actors.getLastName());
						}
					}

				} else if (menuInput == 2) {

					// Look up a film by a search keyword.
					System.out.println("\n");
					System.out.println("Enter the seach keyword: ");
					String keyword = input.next();
					System.out.println("========================");
					System.out.println();

					List<Film> film2 = db.findFilmBySearchKeyword(keyword);

					boolean matching = false;
					for (Film requestedFilms : film2) {
						matching = true;
						System.out.println("Matching film: \n");

						System.out.println("Title: " + requestedFilms.getTitle() + "\nRelease Year: "
								+ requestedFilms.getReleaseYear() + "\nRating: " + requestedFilms.getRating()
								+ "\nDescription: " + requestedFilms.getDescription());
						System.out.println("Language: " + requestedFilms.getLanguage());

						System.out.println("\nThe cast:\n");
						for (Actor actors : requestedFilms.getActors()) {
							System.out.println(actors.getFirstName() + " " + actors.getLastName());
						}
						System.out.println();
					}
					if (!matching) {
						System.out.println("No matching films are found!");
					}

				} else if (menuInput == 3) {
					// Exit the application.
					System.out.println("\n");
					System.out.println("You have chosen to exit the application.\nHave a nice day!");
					// break;
				} else {
					// Message for invalid number.
					System.out.println("\n");
					System.out.println("Invalid number for menu option!");
				}
			} catch (InputMismatchException e) {
				// Message for invalid input.
				System.out.println("\n");
				System.out.println("Invalid input!");
				input.nextLine();// Clear input buffer
			}

		} while (menuInput != 3);

	}
}
