//blackjack

import java.util.Scanner;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        int gameNumber = 1;
        double percentage;

        //given random number generator
        P1Random rng = new P1Random();
        int card = 0;
        int playerDeck = 0;
        int dealerDeck = 0;
        boolean gameOver = false;
        int menuSelection = 0;
        int playerWins =0;
        int dealerWins=0;
        int ties =0;
        //counter for the startup message
        int start=0;

        //scanner to allow the player to select a menu option
        Scanner scnr = new Scanner(System.in);

        while (!gameOver) {
            //reinitialize at the end of the code to be zero when the condition fails if
            // gameOver ==true menuSelection=0; also increment game number by one
            if (start == 0) {
                System.out.println("START GAME #" + gameNumber);
                System.out.println("");
                //restart player and deck values
                playerDeck=0;
                dealerDeck=0;
                //allows the program to run without printing game number every loop
                //need to grab a card right after game begins every time
                //min value 0+1 =1 max value 12+1 =13
                card = rng.nextInt(13) + 1;
                //handling the point value for face cards
                if (card >= 11) {
                    playerDeck += 10;
                    //Jack
                    if (card == 11) {
                        System.out.println("Your card is a JACK!");
                        System.out.println("Your hand is: " + playerDeck);
                        System.out.println(""); }
                    //Queen
                    else if (card == 12) {
                        System.out.println("Your card is a QUEEN!");
                        System.out.println("Your hand is: " + playerDeck);
                        System.out.println("");
                    }
                    //King
                    else {
                        System.out.println("Your card is a KING!");
                        System.out.println("Your hand is: " + playerDeck);
                        System.out.println("");
                    }
                }
                //less than 11
                else {
                    //printing if you got an ace
                    if (card == 1) {
                        playerDeck += card;
                        System.out.println("Your card is a ACE!");
                        System.out.println("Your hand is: " + playerDeck);
                        System.out.println("");

                    }
                    else {
                        //printing the point value as a card number
                        playerDeck += card;
                        System.out.println("Your card is a " + card + "!");
                        System.out.println("Your hand is: " + playerDeck);
                        System.out.println("");
                    }
                }
                start = 1;
            }


            //menu after first draw
            System.out.println("1. Get another card");
            System.out.println("2. Hold hand");
            System.out.println("3. Print game statistics");
            System.out.println("4. Exit");
            System.out.println("");
            System.out.print("Choose an option: ");
            menuSelection = scnr.nextInt();
            System.out.println("");




            if (menuSelection == 1) {

                //min value 0+1 =1 max value 12+1 =13
                card = rng.nextInt(13) + 1;
                //handling the point value for face cards
                if (card >= 11) {
                    playerDeck += 10;
                    //Jack
                    if (card == 11) {
                        System.out.println("Your card is a JACK!");
                        System.out.println("Your hand is: " + playerDeck);
                        System.out.println("");
                    }
                    //Queen
                    else if (card == 12) {
                        System.out.println("Your card is a QUEEN!");
                        System.out.println("Your hand is: " + playerDeck);
                        System.out.println("");
                    }
                    //King
                    else {
                        System.out.println("Your card is a KING!");
                        System.out.println("Your hand is: " + playerDeck);
                        System.out.println("");
                    }
                }
                //less than 11
                else {
                    //printing if you got an ace
                    if (card == 1) {
                        playerDeck += card;
                        System.out.println("Your card is a ACE!");
                        System.out.println("Your hand is: " + playerDeck);
                        System.out.println("");

                    }
                    else {
                        //printing the point value as a card number
                        playerDeck += card;
                        System.out.println("Your card is a " + card + "!");
                        System.out.println("Your hand is: " + playerDeck);
                        System.out.println("");
                    }
                }
                //check here if playDeck value >=21
                if (playerDeck <= 21) {
                    if (playerDeck == 21) {
                        System.out.println("BLACKJACK! You win!");
                        System.out.println("");
                        //increasing player wins by one as well as the game number before exiting the loop
                        playerWins++;
                        gameNumber++;
                        //restarting the counter for the next game to display the game number
                        start = 0;
                        //how to keep the game going???

                    }
                    else if(dealerDeck == playerDeck) {
                        System.out.println("It's a tie! No one wins!");
                        System.out.println("");
                        ties++;
                        gameNumber++;
                        start = 0;

                    }


                }
                //player deck >21
                else {
                    System.out.println("You exceeded 21! You lose.");
                    System.out.println("");
                    //means the dealer wins and on to the next game
                    dealerWins++;
                    gameNumber++;
                    start=0;



                }

            }


            //select option two-player holding
            else if (menuSelection == 2) {
                //dealer's turn
                //grabbing a random number min 0+16=16 max 10+16=26
                card = rng.nextInt(11) + 16;
                //handling the point value for the dealer's card
                dealerDeck+=card;
                //check the dealer hand value here
                if(dealerDeck<=21) {
                    if(dealerDeck==21){
                        //starting a new game as well as keeping tabs on the winner
                        System.out.println("Dealer's hand: " + dealerDeck);
                        System.out.println("Your hand is: " + playerDeck);
                        System.out.println("");
                        System.out.println("Dealer wins!");
                        System.out.print("");
                        dealerWins++;
                        gameNumber++;
                        start=0;

                    }
                    //handling if the same value tie
                    else if(dealerDeck == playerDeck) {
                        System.out.println("It's a tie! No one wins!");
                        System.out.println("");
                        ties++;
                        gameNumber++;
                        start = 0;

                    }


                }
                //dealer deck is greater than 21
                else if(dealerDeck<=26){
                    System.out.println("Dealer's hand: " + dealerDeck);
                    System.out.println("Your hand is: " + playerDeck);
                    System.out.println("");
                    System.out.println("You win!");
                    System.out.println("");
                    playerWins++;
                    gameNumber++;
                    start=0;

                }

            }
            //select option three
            else if (menuSelection == 3) {

                percentage = 100.0*(playerWins*1.0)/(gameNumber-1);
                System.out.print("Number of Player wins: " + playerWins +'\n');
                System.out.print("Number of Dealer wins: " + dealerWins + '\n');
                System.out.print("Number of tie games: "+ ties +'\n');
                //accounting for the game you are currently playing
                System.out.print("Total # of games played is: " + (gameNumber-1) +'\n');
                System.out.print("Percentage of Player wins " + percentage  + "%" + '\n');
                System.out.println("");

            }
            //select option four
            else if (menuSelection == 4) {
                //exits the while loop
                gameOver = true;

            }

            //dealing with an input other than 1-4 started with a counter zero to prevent error specify range specifically
            //to assume the play only input it incorrectly once or many times
            else if (menuSelection < 1 || menuSelection > 4) {

                System.out.println("Invalid input!");
                System.out.println("Please enter an integer value between 1 and 4.");
                System.out.println("");


            }







        }







    }
}












