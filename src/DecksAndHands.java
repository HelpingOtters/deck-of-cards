package src;

import java.util.Scanner;

/**
 * DecksAndHands Tester Class
 */
public class DecksAndHands
{
   public static void main(String[] args)
   {
      // Variable to hold the number of hands the user inputs
      int numHands = getUserInput();

      Deck singleDeck = new Deck();
      
      // Step 1: Create a Hands array to hold all the hand objects
      Hand[] hands = createHands(numHands);

      // Step 2: Deal the deck into "numHands" Hands
      while(singleDeck.getTopCard() > 0) // keep dealing until there are no cards left
      {
         // Deal one card to each hand
         for(int x = 0; x < hands.length; x++)
         {
            hands[x].takeCard(singleDeck.dealCard());
         }
      }

      // Step 3: Display all the hands
      System.out.println("Here are your hands, from an unshuffled deck: ");
      for(int i = 0; i < hands.length; i++)
      {
         System.out.println(hands[i]);
      }

      // Step 4: Reset the deck and the hands

      // Step 5: Shuffle the deck and deal cards again

      // Step 6: Display all the hands again
      System.out.println("Here are your hands, from a shuffled deck: ");    

   }

   /*
   * Private helper method to create an array of Hand objects
   */
   private static Hand[] createHands(int numHands) 
   {
      // Create a Hand array of length numHands
      Hand[] hands = new Hand[numHands];

      // Populate the array with Hand object
      for(int i = 0; i < numHands; i++)
      {
         hands[i] = new Hand();
      }
      return hands;
   }

   /*
   * Private helper method to get a valid number of hands from the user  
   */
   private static int getUserInput()
   {
      Scanner keyboard = new Scanner(System.in);
      boolean invalidInput = true;
      int numHands;
      
      do 
      {
         System.out.println("How many hands would you like? (1 - 10): ");

         numHands = keyboard.nextInt();  // Retrieve the user's input
         
         // Check if they entered valid input (1 - 10)
         if(numHands >= 1  && numHands <= 10)
            invalidInput = false;
      }
      while(invalidInput); // continue loop until user's input is valid 

      keyboard.close();
      return numHands;
   }

}