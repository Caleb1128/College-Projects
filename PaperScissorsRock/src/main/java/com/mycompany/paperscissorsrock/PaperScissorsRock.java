/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.paperscissorsrock;
import java.util.Random; //generates pseudo-random numbers 
import java.util.Scanner; //to parse and read sources
/**
 *
 * @author mkbph
 */
public class PaperScissorsRock {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    //"r" is rock, "p" is paper, "s" is scissors
    
    while (true) { //using a while loop to to keep the game running until the player exits
      String[] rps = {"r", "p", "s"};
      String computerMove = rps[new Random().nextInt(rps.length)];
      
      String playerMove;
      
      while(true) {
        System.out.println("Please enter your move (r, p, or s)");
        playerMove = scanner.nextLine();
        if (playerMove.equals("r") || playerMove.equals("p") || playerMove.equals("s")) {
          break;
        }
        System.out.println(playerMove + " is not a valid move.");
      }
      
      System.out.println("Computer played: " + computerMove);
      
      if (playerMove.equals(computerMove)) { //if the player plays the same letter as the computer
        System.out.println("The game was a tie!"); //displays "The game was a tie"
      }
      else if (playerMove.equals("r")) { //if the player plays rock
        if (computerMove.equals("p")) { //if the computer plays paper
          System.out.println("You lose!"); //Displays "you lose"
          
        } else if (computerMove.equals("s")) { //If the computer plays scissors
          System.out.println("You win!"); //displays "You win"
        }
      }
      
      else if (playerMove.equals("p")) { //if the player plays paper
        if (computerMove.equals("r")) { //If the computer plays rock
          System.out.println("You win!"); //displays "You win"
          
        } else if (computerMove.equals("s")) {
          System.out.println("You lose!"); //displays "You win"
        }
      }
      
      else if (playerMove.equals("s")) { //if the user plays scissors
        if (computerMove.equals("p")) { //if the comptuter plays paper
          System.out.println("You win!"); //displays "You win"
          
        } else if (computerMove.equals("r")) { //if the computer plays rock
          System.out.println("You lose!"); //displays "You win"
        }
      }
      
      System.out.println("Play again? (y/n)"); //choice between yes or nor
      String playAgain = scanner.nextLine();
      
      if (!playAgain.equals("y")) { //if yes it will play again, if no it will break.
        break;
      }
    }
   scanner.close();
  }
}
/*refernce:
JakeTheSnake, 2016, Howw do I exit a while loop in Java?
Available at https://stackoverflow.com/questions/7951690/how-do-i-exit-a-while-loop-in-java


*/