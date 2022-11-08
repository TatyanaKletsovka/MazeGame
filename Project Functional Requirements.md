### Project Functional Requirements
1. All the text should be in English.
2. The game must have a name in the form "Name: Adventure"
3. Any Player should be able to clone the repository and play the game on his device.
4. After the Player launched the game System should display a sentence with game rules.
5. System should ask the Player to choose a map.
6. The map contains not only short ways, but also exits long roads.
7. The map must be drawn using ASCII characters.
8. The .txt file contains the characters `x`, `-` where `x` indicates a wall and `-` indicates a path.
9. If a monster is found, it will be marked on the map with a symbol `@`.
10. System should ask the Player to choose a level of difficulty.
11. After choosing a level of difficulty, the system assigns a health points - "HP" and impact force to the Player.
12. After choosing a level of difficulty, the system assigns to the game the probabilities of various events.
13. System should find the shortest path to exit on the map correctly.
14. The system should display the shortest path to the exit on the map at the beginning of the game.
15. The path can not go through walls.
16. System should take a .txt file as input through the console.
17. The entrance to the map is always in the upper left corner at `[1][0]`.
18. The player can walk freely through the maze (left, right, up, down).
19. Each move the system displays the current location of the Player on the map (the distance traveled `o` and the current location `■`).
20. The system displays the player characteristics before and after the fight.
21. A monster is not specified in the .txt file and occurs at any stage of the journey with a certain probability.
22. The player must fight the monster at least once during the game.
23. There is a possibility to find a single-use weapon that defeats one monster when used.
24. If the Player meets the monster system should give a choice to the Player: fight with a monster or run away to the previous location.
25. If the Player chooses to run away, he can take damage in the back with a certain probability.
26. If the Player chooses to run away from fight, the game ends.
27. If the Player chooses to fight, the system prompts him to roll dice.
28. The game goes step by step.
29. The Player and the monster have health and impact force.
30. The player and the monster have the same luck to roll.
31. The player can find a shield that will block part of the damage from the monster.
32. The player can find a stone of fortune that will add points to the players start roll.
33. The Player and the monster roll in fight. 
34. The one with the greater roll removes health equal to his impact force from the enemy.
35. Fighting continues until someone runs out of HP.
36. The player and the monster have the same range to roll.
37. If the Player wins, he can continue his way.
38. If the Player loses, the game ends, and the system displays a defeat message on the screen, offering to play again or quit.
39. To win the game, the Player must complete the map.
40. The player can quit the game at any time.
41. The player can restart the game at any time.
42. The game should not stop suddenly. There must be some message that the game is over or that the Player has won, or that the map cannot be loaded.
43. Before and after actions, the system should display a message prompting the Player what he can do by entering a certain command.
44. If the Player enters the wrong command, instead of the command given by the system, 
the system says that the command is not recognized and asks the Player to enter the command from the ones already given.
