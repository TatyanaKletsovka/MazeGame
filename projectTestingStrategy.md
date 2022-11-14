# Testing strategy 

Major of functions going to be tested manually, but several will be tested with unit tests.

## 1. Game setup:

- Test case 1. 

   * Action: The user can start working with the application after launch.
   * Steps: 
      * Clone the game from GitLab
      * Run
   * Expected Result: Game runs on a console. User can complete the whole game.

## 2. Map:

- Test case 1. 

   * Action: User chooses a map from listed TXT files.
   * Steps: 
      * Upload a variety of maps.
      * Choose it in game process.
   * Expected Result: If map is valid, it will let choose; otherwise it will inform about invalidness of a map and asks to choose another.

- Test case 2.
   * Action: Program shows the shortest path based on chosen map.
   * Steps: 
      * Upload variety of valid maps.
      * Use them in a game.
   * Expected Result: Map will show the shortest path in any of them.

- Test case 3.
   * Action: User moves on a map in various direction.
   * Steps:
      * Enter all possible commands of movement.
      * Get out of a map edge.
   * Expected result: User can move freely on a map except through obstacles. When got out of it, it will consider it as winning or will not let if you trying to get out from entry point.


## 3. Encounters:
- Test case 1. 

   * Action: User meets and fights a monster.
   * Steps: 
      * Continue walking on a map till you user meets a monster.
      * Choose fight when you find a monster.
      * Roll/fight with a monster till the end result (till one of theirs HP will be 0)
   * Expected Result: User fights a monster. If monster is defeated,then user can continue the journey. Otherwise, the game ends and it will be considered as loosing game.
- Test case 2. 

   * Action: User finds and uses a weapon.
   * Steps: 
      * Continue walking on a map till you find a weapon.
      * Continue walking on a map till you find a monster.
      * Choose "Use a weapon" option.
   * Expected Result: If user has a weapon, using the weapon user able to defeat a monster immediately. Otherwise, will get back damage while searching none existing weapon.
- Test case 3. 

   * Action: User finds and uses a stone of fortune.
   * Steps: 
      * Continue walking on a map till you find a stone of fortune.
      * Continue walking on a map till you find a monster.
      * System should automatically start using the stone of fortune.
   * Expected Result: Stone of fortune will increase user's chances of winning (Stone of fortune will increase of user's roll points probability min range).
- Test case 4. 

   * Action: User finds and uses a shield.
   * Steps: 
      * Continue walking on a map till you find a shield.
      * Continue walking on a map till you find a monster.
      * System should automatically start using the shield.
   * Expected Result: Shield will get part of the damage points from a monster.

## 4. TextGame:
- Test case 1. 

   * Action: Getting welcome text message from system.
   * Steps: 
      * Launch game.
   * Expected Result: The system should welcome our user to the game and ask to choose from given options.
- Test case 2.
   * Action: The system gives to user a name.
   * Steps:
      * The system offers to enter user's name
      * Enter some name or nothing.
   * Expected Result: The system saves entered data and will call the user with it. If entered no data, the system will call the user with a default set in system name.
- Test case 3.
   * Action: User chooses level of difficulty.
   * Steps: 
      * After choosing a map, the system asks to choose one of given levels of difficulty.
      * Choose one of them.
   * Expected Result: The probability of generation of monsters, items and HP, Damage points of a user and monsters will set accordingly to the chosen level of difficulty.
- Test case 4.
   * Action: User quits/restart game at any time.
   * Steps:
      * After setting a name, a map, difficulty; start your journey
   * Expected Result: You are able to quit or restart a game using "0" option whenever you're asked to enter data. "0" option means quitting or restarting. (You can also quit a game during a fight, choosing run away option)
- Test case 5.
   * Action: Checking validness of entered data.
   * Steps: 
      * Enter anything every time you are asked to enter some data.
   * Expected Result: The system will accept it, if it's a valid data, otherwise it will ask to enter data again. (Here we don't consider name setting stage, because a name can be everything)