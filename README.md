## Hangman Game
The program is a hangman game where the user try's to guess a mystery word one character at a time.
They can choose between different difficulty levels to try and challenge themselves. The program uses the Java version 
11.0.19 and the tests use the JUnit 5 testing framework.

## Use cases    
1. **Choose Difficulty level**: This use case allows the player to set up the difficulty level of the game.
2. **Guess letter**: During an active game, the user can guess a letter to fill in the blanks of the hidden word. The 
game validates the input and updates the state accordingly.
3. **Display word**: This use case involves showing the current state, with the successfully guessed letters revealed.
4. **Display figure**: The game displays the figure based on the number of incorrect guesses made.
5. **Display remaining tries**: This use case allows the game to show the number of remaining attempts (wrong guesses) 
before they lose.
6. **Game over check**: The program checks if the game has ended so whether the user has one and or ran out of tries 
and updates the state accordingly and displays the message.
## User stories
1. As a player, I want to choose the difficulty level of the game to challenge myself appropriately
2. As a player, I want to see a series of underscores representing the hidden word, so I can see what letters remain 
un-guessed.
3. As a player, I want to guess a letter and be told whether it is correct or not, so I can progress in the game.
4. As a player, I want to see the hangman figure being drawn with each wrong guess and the number of tries I have left,
so I can keep track of my progress and strategize my upcoming tries.
5. As a player, I want to be informed if I have won or lost the game, so I can either celebrate or try again.

## Design patterns
1. I implemented a **strategy design pattern** with the FigureStrategy interface, for now, there is only one implemented 
figure (the default figure which draws the typical hangman) but in the future, I can extend the program and have more 
figures.

<img width="719" alt="image" src="https://github.com/hassa963/Hangman-Game-ai-assisted-assignment/assets/133050886/3d1c4e15-ca53-4aa6-b0ee-84a374a7fa78">

<img width="676" alt="image" src="https://github.com/hassa963/Hangman-Game-ai-assisted-assignment/assets/133050886/61169e28-44a4-4a1b-8609-5220885c6ca7">



2. I implemented a factory design pattern for the GuessedWord Class so that in the future, the program could support and 
create different subclass like phrases instead as an example and further separate the business layer and the 
application layer. 

<img width="689" alt="image" src="https://github.com/hassa963/Hangman-Game-ai-assisted-assignment/assets/133050886/4214d740-68b4-4e30-a0b9-4d783e110f5e">

## Code Smells and violations
I believe I avoided code smells and based on my understanding I do not think I violated clean architecture.
