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
		
		String language = db.findLanguageByFilmId(4);
		System.out.println(language);
		
		for (Actor actors : film.getActors()) {
			System.out.println(actors);
		}
		System.out.println();
		
		
		//=======================================
		//film = db.findFilmBySearchKeyword("IDE");
		
		//Film film = null;
		//film = db.findFilmByText("santa paris");
		//System.out.println(film);
		
		List<Film> film2 = db.findFilmBySearchKeyword("SANTA");
		for (Film b : film2) {
			System.out.println(b.getTitle());
			System.out.println(b.getLanguage());
			
			for (Actor actors : b.getActors()) {
				System.out.println(actors);
			}
			System.out.println();
			
		}
		
		//language = db.findLanguageByFilmId(4);
//		System.out.println();
//		for (Actor actors : film.getActors()) {
//			System.out.println(actors);
//		}
		
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		
		int menuInput = 0;
		do{
			
			//Prompt the user to choose from the menu.
			System.out.println("\n");
			System.out.println("Please choose between 1 to 3 from the menu:");
			System.out.println("============================================");
			System.out.println("1: Look up a film by its id.");
			System.out.println("2: Look up a film by a search keyword.");
			System.out.println("3: Exit the application.");
			
			menuInput = input.nextInt();
			
			if (menuInput == 1) {
				
				//Look up a film by its id.
				System.out.println("\n");
				System.out.println("Please enter film ID: ");
				int filmId = input.nextInt();
				System.out.println("======================");
				
				Film film = db.findFilmById(filmId);
				System.out.println(film);
				
				String language = db.findLanguageByFilmId(4);
				System.out.println(language);
				
				for (Actor actors : film.getActors()) {
					System.out.println(actors);
				}
				
				
			}
			else if (menuInput == 2) {
				
				//Look up a film by a search keyword.
				System.out.println("\n");
				System.out.println("Please enter the keyword that you want to search: ");
				String keyword = input.next();
				System.out.println("==================================================");

				List<Film> film2 = db.findFilmBySearchKeyword(keyword);
				for (Film b : film2) {
					System.out.println(film2);
				}
			}
			else if (menuInput == 3){
				//Exit the application.
				System.out.println("\n");
				System.out.println("You have chosen to exit the application.\nHave a nice day!");
				//break;
			}
			else {
				//Message for incorrect menu input.
				System.out.println("\n");
				System.out.println("Incorrect input for menu option.");
				//break;
			}
			
		}while (menuInput != 3);

	}

}
