# Project Technical Design

## Class Adventure
```
Player player;
Monster monster;
Probabilities probabilities;
Labyrinth labyrinth;

startGame()
The basic method that starts the game
Input: - 
Output: - 

chooseNextLocation()
Asks the player where to go
Input: - 
Output: array with next location adress

chooseDifficultyLevel()
Offers to choose the difficulty level of the game
Input: - 
Output: - 

quitRestartGame() 
Offers exit/restart of the game
Input: - 
Output: - 

getCorrectCommand() 
Requests input until it receives the correct command
Input: array with correct commands
Output: string with correct command

meetMonster()
Offers options when encountering a monster
Input: - 
Output: boolean was an encounter

runAwayFromMonster()
Escape from the monster to the previous location
Input: - 
Output: -  
```

## Class DiceRollingGame
```
Player player;
Monster monster;
Probabilities probabilities;

fightMonster()
Offers options for action during a battle
Input: - 
Output: -  

roll()
Starts one round of the roll game
Input: - 
Output: -  
```

## Class ENUM DifficultyLevels (EASY, MEDIUM, HARD)
```
double monsterProbability;
double weaponProbability;
double backDamageProbability;
int playerHP;
int monsterHP;
int playerDamage;
int monsterDamage;

willBeGenerated()
Returns whether there will be an event with a certain probability
Input: probability of generation
Output: boolean is in probability
```

## Class Labyrinth
```
String pathToFiles;
char[][] maze;

showCurrentLocation()
Display a map with the current route on the console
Input: - 
Output: - 

chooseMap()
Offers the user to select a map from the existing
Input: - 
Output: - 

convert()
Converts map from .txt file to array
Input: name of choosen map
Output: array with map
```

## Class PathFindingAlgorithm
```
showShortestPath()
Outputs a map with a short path to the console
Input: array with map
Output: - 

findShortestPath()
Finds the coordinates of the shortest path
Input: array with map
Output: list with path coordinates

findPathWithAlgorithm()
Implementation of the algorithm for drawing the shortest path in array
Input: array with map
Output: list with path coordinates
```
## Class Character
```
int HP;
int damage;
```
## Class Monster extends Character
```
-
```
## Class Player extends Character
```
String name;
int[] location = {1, 0};
int weaponQuantity;
int fortune;
boolean haveShield;
boolean haveStoneOfFortune;

setNameFromConsole()
Set player's name
Input: - 
Output: - 

useWeapon()
Uses weapon
Input: - 
Output: - 

pickUpWeapon()
Adds a weapon to the player
Input: - 
Output: - 

pickUpShield()
Adds a shield to the player
Input: - 
Output: - 

pickUpStoneOfFortune()
Adds a stone of fortune to the player
Input: - 
Output: - 
```