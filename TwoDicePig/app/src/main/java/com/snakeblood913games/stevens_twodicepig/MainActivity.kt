package com.snakeblood913games.stevens_twodicepig

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity(val zero: () -> kotlin.Int = { 0 }, val one: () -> kotlin.Int = { 1 }, val two: () -> kotlin.Int = { 2 }, val three: () -> kotlin.Int = { 3 }, val four: () -> kotlin.Int = { 4 }, val five: () -> kotlin.Int = { 5 }, val six: () -> kotlin.Int = { 6 }, val win: () -> kotlin.Int = { 50 }) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    } //end onCreate
    var playerTurn: () -> kotlin.Int = { 0 }
    var p1Score: () -> kotlin.Int = { 0 }
    var p2Score: () -> kotlin.Int = { 0 }
    var score: () -> kotlin.Int = { 0 }
    var p1Wins: () -> kotlin.Int = { 0 }
    var p2Wins: () -> kotlin.Int = { 0 }
    fun rollDice() {
        //values for playerTurn & Dice values were initialized in MainActivity, as well as playerTurn int and Scores
        var rndInt1: () -> kotlin.Int = { Random.nextInt(0, 7) }
        var rndInt2: () -> kotlin.Int = { Random.nextInt(0, 7) }
        score = rndInt1 + rndInt2
        when (rndInt1) {
            one -> {/*set left die to display @drawable/die_1*/}
            two -> {/*set left die to display @drawable/die_2*/}
            three -> {/*set left die to display @drawable/die_3*/}
            four -> {/*set left die to display @drawable/die_4*/}
            five -> {/*set left die to display @drawable/die_5*/}
            six -> {/*set left die to display @drawable/die_6*/}
        }
        when (rndInt2) {
            one -> {/*set right die to display @drawable/die_1*/ }
            two -> {/*set right die to display @drawable/die_2*/ }
            three -> {/*set right die to display @drawable/die_3*/}
            four -> {/*set right die to display @drawable/die_4*/}
            five -> {/*set right die to display @drawable/die_5*/}
            six -> {/*set right die to display @drawable/die_6*/}
        }
        if (rndInt1 == one && rndInt2 == one) {//Clear total score of current player & Changes Turn
            when (playerTurn) {
                zero -> {
                    p1Score = zero
                    playerTurn = one
                }
                one -> {
                    p2Score = zero
                    playerTurn = zero
                }
            }
        }//end if statement for Double Ones
        if (rndInt1 == one || rndInt2 == one) { //changes turn
            if (playerTurn === zero) {
                playerTurn = one
            } else {
                playerTurn = zero
            }
        } // end if statement for a single one
    } /* End fun rollDice() */
    fun hold() {
        //modifies score & changes turn
        if (playerTurn === zero) {
            p1Score = p1Score + score
            playerTurn = one
            //change PlayerTurnTV String to @string\Turn2
        } else {
            p2Score = p2Score + score
            playerTurn = zero
            //change PlayerTurnTV String to @string\Turn1
        }
        if (p2Score > win || p2Score === win)
        {p2Wins = p2Wins + 1}
        else if (p1Score > win || p2Score === win)
        {p1Wins = p1Wins + 1}
    } /* end fun hold() */

}//end of MainActivity

