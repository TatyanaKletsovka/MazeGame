# Project development plan

## Instruction

A developer responsible for a feature should know everything what he needs to do with it from this file.

For example, User writes his nickname feature is happening in the Menu class, but passes a variable to the Player class.

To see that more clearly a developer should look into [Technical Design](https://git.syberry.com/syberry-academy/liftoff/crew-51022-i/-/blob/develop/Project%20Technical%20Design.md). If he wants to test it, he has to look at the 2nd point of [Testing Strategy](https://git.syberry.com/syberry-academy/liftoff/crew-51022-i/-/blob/develop/projectTestingStrategy.md). To know when the feature occurs during the runtime 2nd point of [User Journey](https://git.syberry.com/syberry-academy/liftoff/crew-51022-i/-/blob/develop/User_Journey_diagram.drawio.svg). It is recommended to take a look at the Diagram.

_______________________________________________________________________________________

## Map features:
Developer: Tenirberdi Kambarov\ Deadline: 17th of November


| Feature  | Testing strategy  | Tech design classes  |
|---|---|---|
| Converts from txt to 2d massive| 3, 4 | Labyrinth |
| Algorithm which finds shortest path  | 3  | PathFindingAlgorithm |
| Offers list of txt maps | 2 | Labyrinth |
| Shows current location of user | 4 | Labyrinth |
| Checks whether txt map is valid | 2 | Labyrinth |
| Ability to move on a map | 4 | Adventure |
_______________________________________________________________________________________

## Text game features:

Developer: Kletsovka Tatyana\ Deadline: 17th of November


| Feature  | Testing strategy  | Tech design classes  |
|---|---|---|
| User writes nickname | 10 | Player |
| Setting difficulty  | 11  | DifficultyLevels |
| User chooses the map | 2 | Labyrinth |
| Possibility to quit/restart game at any time  | 12 | Adventure |
| Checks whether entered command is valid | 13 | Adventure |
| Fight monster | 5 | Adventure |
| Use such items as shield, stone of fortune and weapon | 6, 7, 8 | Player, Adventure |
| Probability of generation of certain things | 11, 5-8 | DifficultyLevels |
| Possibility to play "Dice Rolling" mini game | 5 | DiceRollingGame |

_______________________________________________________________________________________

## Testing and bug repairs: 17th of November.

When the phase of creating ends the phase of testing and bug repair starts. The whole team will be looking for bugs following the testing strategy from the first point to the last.

_______________________________________________________________________________________

## Additional features
In case of no problems during all phases, additional features are going to be implemented.