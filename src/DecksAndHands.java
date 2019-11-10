package src;

/**
 * DecksAndHands Tester Class 
 */

 import java.util.Scanner;

public class DecksAndHands
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      boolean validHand = false;
      int numHands = 0;

      //Loops until valid number of players are selected 
      while (!validHand)
      {
         System.out.print("How many hands? (1-10, please): ");
         numHands = keyboard.nextInt();
         if ((numHands > 0) & (numHands < 11))
         {
            validHand = true;
         }
      }

      //unshuffled deal 
      Deck d1 = new Deck(1);
      Hand[] myHands = new Hand[numHands];
      int thisCard = 0;
      for (int thisHand = 0; thisHand < numHands; ++thisHand)
      {
         myHands[thisHand] = new Hand();
      }
      System.out.println("Here are our hands, from unshuffled deck: ");
      while (d1.inspectCard(thisCard).getErrorFlag() == false)
      {
         for (int thisHand = 0; thisHand < numHands; ++thisHand)
         {
            if (thisCard > 51)
            {
               break;
            }
            myHands[thisHand].takeCard(d1.dealCard());
            ++thisCard;
         }
      }
      for (int thisHand = 0; thisHand < numHands; ++thisHand)
      {
         System.out.println((thisHand+1) + ") " + myHands[thisHand].toString());
         myHands[thisHand].resetHand();
      }
      System.out.println();

      //Shuffled Deal
      Deck d2 = new Deck(1); 
      d2.shuffle();
      thisCard = 0;
      System.out.println("Here are our hands from a shuffled deck: ");
      while (d2.inspectCard(thisCard).getErrorFlag() == false)
      {
         for(int thisHand = 0; thisHand < numHands; ++thisHand)
         {
            if(thisCard > 51)
            {
               break;
            }
            myHands[thisHand].takeCard(d2.dealCard());
            ++thisCard;
         }
      }
      for(int thisHand = 0; thisHand < numHands; ++thisHand)
      {
         System.out.println((thisHand+1) + ") " + myHands[thisHand].toString());
      }
      keyboard.close();

   }

}