# Tic Tac Toe Game

**Version 1.0:** 
- Basic text-based Tic Tac Toe.
- GUI is yet to be implemented.
- Issues with GitHub and Intellij have been fixed by creating a new gradle project.

**Version 2.0:**
- GitHub Access: (Fixed)
- GUI will be implemented in this version, which will interact with the core Kotlin code: (Completed)
  - Current engine not suitable for GUI implementation (New Engine implemented)
  - I will have to completely rework the engine to make it work with the new GUI layout that I have created. 
  - While the logic is still in tact I might have to introduce new functions or reassign the things certain functions 
    in the engine do (Proposed Soln) (Completed)
- Unit Tests will also be implemented in this version, which was previously missing in v1.0.: (In Progress pending successful GUI Implementation)

**Version 3.0:**
- Changed the entire GUI to a button layout since the radio button layout was not working
- Added menus for both Tic Tac Toe Classic & Ultimate
- Ultimate Tic Tac Toe will be made at a later date
- Currently there is a NumberFormatException in the engine and functionality needs to be implemented for some of the buttons
  - After debugging I discovered that the error is causing the game to start over after every move on the engine side. 
  - On the GUI side it just changes all the buttons to just X so I am assuming the engine is failing to work after the first
    button press.
- Unit Tests are still pending.
- Documentation is also pending

**Version 4.0:**
- Errors with certain menu buttons functionality (FIXED)
- NumberFormatException cuased due to some parseInt error in the engine (Identified and fix is in progress)
- New comments have been added and existing comments have been rephrased according to project requirements (Pending)
- Unit Test file (Pending)


**Final Version:**

 ***What works***
 - The text based version of Tic Tac Toe works perfectly error free
 - The errors with certain menu buttons have been fixed 
 - The GUI game successfully toggles from the position number to the current player 
 - I have also added the required comments throughout the GUI and text-based files that explains why certain interfaces, classes and functions exist and how they help the program
 
 ***What does not work***
 - NumberFormatException in the engine that is causing all the positions in the GUI version to turn to O when clicked
 - In the debugging process I noticed that the porgram basically starts over everytime I click on a new position instead of changing the position on the same board
 - Example: selecting position 1 works okay but when I click on position 2 on the board it creates a new board in the debugger and only switches position 2 but forgets the change made to position 2

***Future Updates***
- In the future my first goal would be to fix the error with the TTT engine so that the GUI version works the way I intended it to
- I would also like to introduce more functionality to the various menu buttons that are currently inactive
- I am in fact doing some research right now for the Player v. Computer version of the game and how to apply the Player v. Player and the Player v. Computer to an Ultimate Tic Tac Toe version of the game
- Finally I would like to have a scoreboard in the game that can track your scores against friends and the computer over time as well as make some design changes like using better colors throughout and also using a good image of X and O instead of just text. 
- Last but not least I would love to make some small overall code design changes to the game 
