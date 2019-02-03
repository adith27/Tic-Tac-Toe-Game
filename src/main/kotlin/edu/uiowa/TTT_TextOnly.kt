/*
* Author: Adith Rai
* Project: CS_2820 Final Project
* Description: This file is a text based Tic Tac Toe game which later on serves as the base for
* the GUI based Tic Tac Toe game in TTT_Engine & TTT_GUI.
* */

package edu.uiowa

import java.lang.Error
import java.util.*

//Version 1.0: This is just a simple text based version of Tic Tac Toe Classic


// This interface initializes all the methods here for better overall design and readability
interface TTT_TextOnly{

    //functions
    fun evalResult():String? // evaluates the various dimensions on the board
    fun resetBoard() // resets the game board
    fun displayBoard() // displays the Tic Tac Toe board
    fun gamePlay() // controls the game play including user input errors

}

//This class serves as the engine and the interface for this text-based game
class TicTacToe_TextOnly: TTT_TextOnly {
    // variables are declared here as private since they are not needed elsewhere
    private var userInput: Scanner = Scanner(System.`in`)
    private lateinit var position: Array<String?>
    private lateinit var player: String
    private var dimension: String? = null
    private var playerEval:String? = null

    // This function controls the game play and the user input error handling for the game
    override fun gamePlay(){
        position = arrayOfNulls(9)
        player = "X"
        resetBoard()

        println("**** Welcome to  Tic Tac Toe Classic! ****")
        println("------------------------------------------")
        displayBoard()
        print("Player X will go first! Please choose a position on the board to place $player on: ")

        while (playerEval == null) {
            val evalInput: Int
            try {
                evalInput = userInput.nextInt()
                if (evalInput !in 1..9) {
                    print("The position you entered is invalid! Please try a different position on the board: ")
                    continue
                }
            } catch (e: Error) {
                print("The position you entered is invalid! Please try a different position on the board: ")
                continue
            }

            if (position[evalInput - 1]?.equals(evalInput.toString()) ?: (false)) {
                position[evalInput - 1] = this.player
                player = if (player == "X") {
                    "O"
                } else {
                    "X"
                }
                displayBoard()
                this.playerEval = evalResult()
            } else {
                print("This position has already been taken. Please try a different position on the board: ")
                continue
            }
        }
        if (this.playerEval == "Tie"|| this.playerEval == "tie") {
            println("It's a tie! Thank you for playing Tic Tac Toe!")
        } else {
            println("Congratulations $playerEval! You have won this game!")
        }
    }
    // this function evaluates each of the various dimensions on the board for 3 consecutive Xs or Os
    override fun evalResult(): String? {
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
        return null
    }
    // this function displays the current status of the board in a text version
    override fun displayBoard() { //displays the current board status

        println("  " + position[0] + " | " + position[1] + " | " + position[2] + "  ")
        println(" ----------- ")
        println("  " + position[3] + " | " + position[4] + " | " + position[5] + "  ")
        println(" ----------- ")
        println("  " + position[6] + " | " + position[7] + " | " + position[8] + "  ")

    }

    // this function creates a brand new 3 x 3 board with positions numbered from 1 to 9
    override fun resetBoard() { // creates the default game board
        for (x in 0..8) { //creates a 3 x 3 board with a number assigned for each position
            position[x] = (x+1).toString()
        }
    }
}

// this main function runs this text-based Tic Tac Toe for testing
fun main(args: Array<String>) { //main testing
    TicTacToe_TextOnly().gamePlay()
}


