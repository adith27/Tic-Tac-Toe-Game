/*
* Author: Adith Rai
* Project: CS_2820 Final Project
* Description: This files serves the purpose of initializing all the GUI elements of the Tic Tac Toe
* game including the menu for the game. This file also includes the various button controllers as well as
* the main method that will be used to run the game.
* */

package edu.uiowa

import javafx.application.Application
import javafx.application.Application.launch
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.Stage
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import kotlin.system.exitProcess

// these variables here are initialized to work with the various button controllers and label objects
var current_stage: Stage? = null  // to remember which stage we are on
lateinit var resLabel: Label
lateinit var vMain: VBox
lateinit var vClassic: VBox
lateinit var vUltimate: VBox
lateinit var vClassic1on1:VBox

/* This class contains all the GUI elements of the game. All the elements have been stored in a single class for easy
 * accessibility
 */
class TTT_GUI : Application() {
    override fun start(primaryStage: Stage?) {
        current_stage = primaryStage
        primaryStage!!.title = "Welcome to Tic Tac Toe!"

        // Main Menu Buttons

        val vbox1 = VBox()
        vMain = vbox1
        vbox1.setPrefSize(350.0, 400.0)
        vbox1.style = "-fx-background-color: D9E8F7;"

        val hboxMenuClassic = HBox()
        hboxMenuClassic.padding = Insets(15.0, 12.0, 5.0, 12.0)
        hboxMenuClassic.spacing = 10.0
        vbox1.children.add(hboxMenuClassic)

        val playClassicButton = Button("Play Tic Tac Toe Classic")
        playClassicButton.onAction = playClassicController
        hboxMenuClassic.children.add(playClassicButton)

        val hboxMenuUltimate = HBox()
        hboxMenuUltimate.padding = Insets(15.0, 12.0, 5.0, 12.0)
        hboxMenuUltimate.spacing = 10.0
        vbox1.children.add(hboxMenuUltimate)

        val playUltimateButton = Button("Play Ultimate Tic Tac Toe (Coming Soon!)")
        playUltimateButton.onAction = playUltimateController
        hboxMenuUltimate.children.add(playUltimateButton)

        val hboxMenuQuit = HBox()
        hboxMenuQuit.padding = Insets(15.0, 12.0, 5.0, 12.0)
        hboxMenuQuit.spacing = 10.0
        vbox1.children.add(hboxMenuQuit)

        val quitButton = Button("Quit Game")
        quitButton.onAction = quitController
        hboxMenuQuit.children.add(quitButton)

        // Tic Tac Toe Classic Menu

        val vboxClassic = VBox()
        vClassic = vboxClassic
        vbox1.setPrefSize(350.0, 400.0)
        vbox1.style = "-fx-background-color: D9E8F7;"

        val hboxClassicSelector1 = HBox()
        hboxClassicSelector1.padding = Insets(15.0, 12.0, 5.0, 12.0)
        hboxClassicSelector1.spacing = 10.0
        vboxClassic.children.add(hboxClassicSelector1)

        val playClassic1on1 = Button("Play with a friend")
        playClassic1on1.onAction = playClassic1on1Controller
        hboxClassicSelector1.children.add(playClassic1on1)

        val hboxClassicSelector2 = HBox()
        hboxClassicSelector2.padding = Insets(15.0, 12.0, 5.0, 12.0)
        hboxClassicSelector2.spacing = 10.0
        vboxClassic.children.add(hboxClassicSelector2)

        val playClassicComp = Button("Play with the computer (Coming Soon)")
        playClassicComp.onAction = playClassicCompController
        hboxClassicSelector2.children.add(playClassicComp)

        val hboxClassicBack = HBox()
        hboxClassicBack.padding = Insets(15.0, 12.0, 5.0, 12.0)
        hboxClassicBack.spacing = 10.0
        vboxClassic.children.add(hboxClassicBack)

        val classicBackButton = Button("Go Back (Coming Soon)")
        classicBackButton.onAction = classicBackController
        hboxClassicBack.children.add(classicBackButton)

        // Ultimate Tic Tac Toe Menu (Coming soon in a future update)

        val vboxUltimate = VBox()
        vUltimate = vboxUltimate
        vboxUltimate.setPrefSize(350.0, 400.0)
        vboxUltimate.style = "-fx-background-color: D9E8F7;"

        // Tic Tac Toe Classic game window

        val vbox3 = VBox()
        vClassic1on1 = vbox3
        vbox3.setPrefSize(350.0, 400.0)
        vbox3.style = "-fx-background-color: D9E8F7;"

        //row 1 variables

        val hboxRow1 = HBox()
        hboxRow1.padding = Insets(15.0, 12.0, 5.0, 12.0)
        hboxRow1.spacing = 10.0
        vbox3.children.add(hboxRow1)

        val pos1 = Button("1")
        pos1.onAction = pos1Controller
        hboxRow1.children.add(pos1)

        val pos2 = Button("2")
        pos2.onAction = pos2Controller
        hboxRow1.children.add(pos2)

        val pos3 = Button("3")
        pos3.onAction = pos3Controller
        hboxRow1.children.add(pos3)


        // row 2 variables

        val hboxRow2 = HBox()
        hboxRow2.padding = Insets(15.0, 12.0, 5.0, 12.0)
        hboxRow2.spacing = 10.0
        vbox3.children.add(hboxRow2)

        val pos4 = Button("4")
        pos4.onAction = pos4Controller
        hboxRow2.children.add(pos4)

        val pos5 = Button("5")
        pos5.onAction = pos5Controller
        hboxRow2.children.add(pos5)

        val pos6 = Button("6")
        pos6.onAction = pos6Controller
        hboxRow2.children.add(pos6)

        // row 3 variables

        val hboxRow3 = HBox()
        hboxRow3.padding = Insets(15.0, 12.0, 5.0, 12.0)
        hboxRow3.spacing = 10.0
        vbox3.children.add(hboxRow3)

        val pos7 = Button("7")
        pos7.onAction = pos7Controller
        hboxRow3.children.add(pos7)

        val pos8 = Button("8")
        pos8.onAction = pos8Controller
        hboxRow3.children.add(pos8)

        val pos9 = Button("9")
        pos9.onAction = pos9Controller
        hboxRow3.children.add(pos9)

        val hboxRow4 = HBox()
        hboxRow4.padding = Insets(15.0, 12.0, 10.0, 12.0)
        hboxRow4.spacing = 10.0
        vbox3.children.add(hboxRow4)

        var resultLabel = Label("    Player X will go first! Please choose a position on the board to place X on!")
        vbox3.children.add(resultLabel)
        resLabel = resultLabel

        primaryStage.run {
            scene = Scene(vbox1, 500.0, 200.0)
            show()
        }
    }

}


// Main menu Controllers

object playClassicController:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {
        current_stage.run {
            this!!.scene = Scene(vClassic, 500.0, 200.0)
            show()
        }
    }
}

object playUltimateController:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {
        //current_stage.run {
        //    this!!.scene = Scene(vUltimate, 500.0, 200.0)
        //    show()
        }
    }


object quitController:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {
        exitProcess(0)
    }
}

// Tic Tac Toe Classic Menu Controllers

object playClassic1on1Controller:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {
        current_stage.run {
            this!!.scene = Scene(vClassic1on1,500.0,200.0)
            show()
        }
    }
}

object playClassicCompController:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {

    }
}


object classicBackController:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {


    }
}

// Ultimate Tic Tac Toe Menu Controllers (Coming in a future update)



// Tic Tac Toe Classic Game Controllers
// Error found here possibly due to the same NumberFormatException in the engine

object pos1Controller:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {
        val bc1 = event.source as Button
        TTT_Engine().gamePlay(bc1)


    }
}

object pos2Controller:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {
        val bc2 = event.source as Button
        TTT_Engine().gamePlay(bc2)


    }
}

object pos3Controller:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {
        val bc3 = event.source as Button
        TTT_Engine().gamePlay(bc3)

    }
}

object pos4Controller:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {
        val bc4 = event.source as Button

        TTT_Engine().gamePlay(bc4)

    }
}

object pos5Controller:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {
        val bc5 = event.source as Button
        TTT_Engine().gamePlay(bc5)

    }
}

object pos6Controller:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {
        val bc6 = event.source as Button
        TTT_Engine().gamePlay(bc6)

    }
}

object pos7Controller:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {
        val bc7 = event.source as Button
        TTT_Engine().gamePlay(bc7)

    }
}

object pos8Controller:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {
        val bc8 = event.source as Button
        TTT_Engine().gamePlay(bc8)

    }
}

object pos9Controller:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent) {
        val bc9 = event.source as Button
        TTT_Engine().gamePlay(bc9)

    }
}

// this main function runs this GUI-based Tic Tac Toe for testing
fun main(args: Array<String>){
    launch(TTT_GUI::class.java)
}