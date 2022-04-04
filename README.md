## FilmQueryProject

### Description

FilmQuery Project is a project that prompts the user to choose from a menu of 3 options:
1. Look up a film by its id.
2. Look up a film by a search keyword.
3. Exit the application.
If the user chooses the first option, they are prompted to enter the film id.
If the user chooses the second option, they are prompted to enter a search keyword.
If the user chooses the third option, the program will end and exit the menu.
If the user enters a number other than 1, 2, or 3, they will see a message saying: "Invalid number for menu option!". And finally, if the user enters a mismatch input such as a word or a symbol, they will see a message saying: "Invalid input!".

In case the option 1 is chosen, if the user enters a number which is not an existing film id, they will see a message saying "The film is not found!". If the user enters a mismatch input such as a word or a symbol, they will see a message saying: "Invalid input!". And finally, if the user enters a number which is an existing film id, they will see a message saying: "The film is found!", and then its title, year, rating, and description are displayed.

In case the option 2 is chosen, if the user enters a search keyword which is not in any of film titles or descriptions, they will see a message saying "No matching films are found!". But if the user enters a search keyword which is in one or more of film titles or descriptions, they will see a message saying "Matching films found!", and then they will see a list of films for which the search term was found anywhere in the title or description, with each film displayed with its title, year, rating, and description.
