import java.util.Scanner;
public class DiceMatchingGame {

	public static void main(String[] args) {
		//Program Description: a fun little dice matching game, 20 points for matching and 15 points if you are within 2 points of the computers roll!
		//takes user input and computer generated value and sees if they match or are within 2 points
		// declare and initialize variables
	    int playerPoints = 0;
	    int computerPoints = 0;
	    int roundPoints = 0;
	    int roundCount = 0;
	    String playerName = "";
	    int playerGuess = 0;
	    int computerRoll = 0;
	    boolean quit = false;

	    // create Scanner object for input
	    Scanner sc = new Scanner(System.in);

	    // print welcome statement and game rules
	    System.out.println("***********************************************");
	    System.out.println("*            Welcome to The DICE Game!         *");
	    System.out.println("* You will be competing against the computer, *");
	    System.out.println("* so get READY to THROW some DICE!!!           *");
	    System.out.println("* First one to 100 points WINS!                *");
	    System.out.println("***********************************************");
	    System.out.println();

	    // ask for player name and wish them good luck
	    System.out.print("Player please enter your First and Last Name? ");
	    playerName = sc.nextLine();
	    System.out.println("Good Luck player: " + playerName.toUpperCase());

	    // start game loop
	    while (!quit && playerPoints < 100 && computerPoints < 100) {
	      // increase round count
	      roundCount++;

	      // print round header
	      System.out.println();
	      System.out.println("Round " + roundCount + ":");
	      System.out.println("--------------------");

	      // prompt player to enter a number between 2 and 12
	      do {
	        System.out.print("Choose a number between 2 & 12: ");
	        playerGuess = sc.nextInt();
	      } while (playerGuess < 2 || playerGuess > 12);

	      // simulate computer roll, generate value
	      computerRoll = (int) (Math.random() * 11) + 2;

	      // print computer rolling
	      System.out.println("Computer is rolling...");
	      for (int i = 0; i < 3; i++) {
	        System.out.print(".....[]....");
	        try {
	          Thread.sleep(500);
	        } catch (InterruptedException e) { //sleeping thread so that it can display the fun little animated "computer is rolling" instead of instantly responding
	          e.printStackTrace();
	        }
	      }
	      System.out.println();
	      System.out.println("Computer roll is: " + computerRoll);

	      // compare player guess and computer roll and calculate round points
	      if (playerGuess == computerRoll) {
	        roundPoints = 20;
	        System.out.println(playerName + " MATCHED the computer roll for +" + roundPoints + " points!");
	      } else if (Math.abs(playerGuess - computerRoll) <= 2) {
	        roundPoints = 15;
	        System.out.println(playerName + " is within 2 points of the computer for +" + roundPoints + " points!");
	      } else {
	        roundPoints = 0;
	        System.out.println(playerName + " did NOT match the computer roll!");
	      }

	      // update player and computer points
	      playerPoints += roundPoints;
	      computerPoints += (20 - roundPoints);

	      // print results and total points at end of round
	      System.out.println("Round Points: " + roundPoints);
	      System.out.println("Total Points - " + playerName.toUpperCase() + ": " + playerPoints);
	      System.out.println("Total Points - COMPUTER: " + computerPoints);

	      // ask player if they want to go another round or quit
	      System.out.print("Ready for next round? (y/n) ");
	      String answer = sc.next();
	      if (answer.equals("n") || playerPoints >= 100 || computerPoints >= 100) {
	        quit = true;
	      }
	    }
	    // print results at end of game
	    System.out.println();
	    System.out.println("GAME OVER!");
	    System.out.println("--------------------");
	    System.out.println("Total Rounds Played: " + roundCount);
	    System.out.println("Total Points - " + playerName.toUpperCase() + ": " + playerPoints);
	    System.out.println("Total Points - COMPUTER: " + computerPoints);
	    if (playerPoints > computerPoints) {
	      System.out.println("Congratulations " + playerName.toUpperCase() + "! You WIN!");
	    } else if (playerPoints < computerPoints) {
	      System.out.println("Sorry " + playerName.toUpperCase() + ", the COMPUTER wins this time!");
	    } else {
	      System.out.println("It's a tie!");
	    }

	    // close scanner
	    sc.close();

	}

}
