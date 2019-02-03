/*
* Author: Adith Rai
* Project: CS_2820 Final Project
* Description: This file contains the main engine that drives the GUI component
* of the game. This engine is mainly based on the code in TTT_TextOnly.kt
*
* */

package edu.uiowa

import javafx.scene.control.Button
import javafx.scene.control.Label
import java.lang.Error
import java.util.*

// This interface initializes all the methods here for better overall design and readability
interface TTT{
    fun evalResult():String?
    fun resetBoard()
    fun displayBoard()
    fun gamePlay(b:Button)

}

// this class serves as the engine that drives the GUI for the game while evaluating the board and handling any user input errors
class TTT_Engine: TTT{
     lateinit var position: Array<String?>
     lateinit var player: String
     var dimension: String? = null
     var playerEval:String? = null

    // this function handles the game play and user input error handling while working with evalResult() to check the user input
    override fun gamePlay(b:Button) {
        position = arrayOfNulls(9)
        player = "X"
        resetBoard()

        println("**** Welcome to  Tic Tac Toe Classic! ****")
        println("------------------------------------------")
        displayBoard()
        println("Player X will go first! Please choose a position on the board to place $player on ")

        while (playerEval == null){
            /* possible NumberFormatException that's preventing the game to function as expected */
            val evalInput = b.text.toInt()

            if (position[evalInput - 1]?.equals(evalInput.toString()) ?: (false)) {
                position[evalInput - 1] = this.player
                player = if (player == "X") {
                    b.text = "O"
                    "O"
                } else {
                    "X"
                }
                displayBoard()
                this.playerEval = evalResult()
            } else {
                print("This position has already been taken. Please try a different position on the board: ")
                resLabel.text = "   This position has already been taken. Please try a different position on the board: "

                continue
            }
        }
        if (this.playerEval == "Tie"|| this.playerEval == "tie") {
            println("It's a tie! Thank you for playing Tic Tac Toe!")
            resLabel.text = "   It's a tie! Thank you for playing Tic Tac Toe!"
        } else {
            println("Congratulations $playerEval! You have won this game!")
            resLabel.text = "   Congratulations $playerEval! You have won this game!"
        }

        }

    // this function evaluates each of the various dimensions on the board for 3 consecutive Xs or Os
    override fun evalResult(): String? {  // evaluates the various dimensions
        for (x in 0..7) {

         when (x) {
            0 -> dimension = position[0] + position[1] + position[2]// row 1
            1 -> dimension = position[3] + position[4] + position[5]// row 2
            2 -> dimension = position[6] + position[7] + position[8]// row 3
            3 -> dimension = position[0] + position[3] + position[6]// column 1
            4 -> dimension = position[1] + position[4] + position[7]// column 2
            5 -> dimension = position[2] + position[5] + position[8]// column 3
            6 -> dimension = position[0] + position[4] + position[8]// diagonal 1
            7 -> dimension = position[2] + position[4] + position[6]// diagonal 2
        }
        //we evaluate the dimensions above for a winner
        when(dimension){
            "XXX" -> return "X"
            "OOO" -> return "O"
        }

    }

         for (x in 0..8) {
             if (Arrays.asList(*position).contains((x + 1).toString())) {
                 break
             } else if (x == 8) return "Tie"
          }

         print("Its $player's turn! Please enter the position on the board you desire to place $player in: ")
         resLabel.text = "   Its $player's turn! Please enter the position on the board you desire to place $player in: "
        return null
    }

    // this function creates a brand new 3 x 3 board with positions numbered from 1 to 9
    override fun resetBoard() { // creates the default game board
        for (x in 0..8) { //creates a 3 x 3 board with a number assigned for each position
            position[x] = (x+1).toString()
        }
    }

    /* unlike the text based version, this function now serves as a debugger by displaying the current board status
     on the console */
    override fun displayBoard() {
        println("  " + position[0] + " | " + position[1] + " | " + position[2] + "  ")
        println(" ----------- ")
        println("  " + position[3] + " | " + position[4] + " | " + position[5] + "  ")
        println(" ----------- ")
        println("  " + position[6] + " | " + position[7] + " | " + position[8] + "  ")

    }


}
