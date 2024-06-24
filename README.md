# StickHero
In this project, we developed a game where a character named stick-hero traverses between platforms by stretching out a stick.

GitHub repo :- https://github.com/aethernavshulkraven-allain/StickHero.git (this has been kept private as per guidlines)

Game Mechanics:

The game begins by running HelloAplication.java File

Pillars are generated of random width and at a random x layout on the screen.

Save game mechanics have been achieved through serialization.

The player can control the stickman character. To stretch out the stick, the player can holds A key. To flip the stickman upside down, the player can press SPACEBAR. To collect cherries, the player must flip the stickman upside down while it is in the air. If the stickman falls into the abyss, the game is over.

Music and Graphic(Image) features has been provided and Files are present in resources folder 

Reviving Feature:

The player can be revived once using a 3 cherries. To revive the stickman, the player must press Revive button on the game over menu. After the player has been revived, the cherries (and related score) will be deducted.

Scoring System:

The player earns points for collecting cherries. The more cherries the player collects, the higher their score will be. Restarting, Saving, and Loading:

During the gameplay score is shown on Top of the screen, cherry count is shown on top left of the screen.

To save the player's progress, the player can press S key.

Menu:

Game starts with Home Screen on which player can start a new game or load a previous game.

During the gameplay player can save the progress using S key as said.

Once the pillar fails traverse to pillar 2 a Game Over Menu is displayed, on which player can 1) Go to Home screen 2) Save curent progress 3) Revive gameplay

ALso Highest score till that point is displayed.

Design Patterns:

Singleton : StickHero class

Decorator : Media player

Flyweight : pillars

JUnit:

JUnit tests for crucial flags in  

BONUS : 

We have used Multithreading in MusicPlayer class by implementing the runable interface