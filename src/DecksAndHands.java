package src;
/**
 * @author Lindsey Reynolds
 * @author Dan Sedano 
 * Declare a deck containing two packs of cards. Do not shuffle.  Deal all the cards in a loop until the deck is empty 
 * (dealt directly to the display/screen, not to any Hand objects just yet).  Display each card as it comes off the deck. 
 * Next, reset the deck by initializing it again (to the same two packs).  
 * Shuffle the deck this time, and re-deal to the screen in a loop again. Notice that the cards are now coming off in a random order.
 * Repeat this double deal, unshuffled, then shuffled, but this time using a single pack deck.
*/

 import java.util.Scanner;

public class DecksAndHands
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
       
        System.out.println("\n--------------------------------------------------------");
        int twoPacks = 2;
        //creats a deck of 104 cards (two packs)
        Deck deck2Pack = new Deck(twoPacks);
        //prints out the dealt cards in an unshuffled deck
        for(int x = 1; x < deck2Pack.getTopCard() + 1; ++x)
        {
           System.out.print(deck2Pack.dealCard() + " / ");
           if((x % 4) == 0)
              System.out.println();
        }         
        
        System.out.println();
        //refills the deck
        deck2Pack.init(twoPacks);
        //shuffles the deck
        deck2Pack.shuffle();
        //prints out the dealt cars of a shuffled deck
        for(int x = 1; x < deck2Pack.getTopCard() + 1; ++x)
        {
           System.out.print(deck2Pack.dealCard() + " / ");
           if((x % 4) == 0)
              System.out.println();
        }             
        System.out.println("\n--------------------------------------------------------"); 
        //creats a deck of 52 cards
        Deck deck1Pack = new Deck();
        //prints out the dealt cards of an unshuffled deck
        for(int x = 1; x < deck1Pack.getTopCard() + 1; ++x)
        {
            System.out.print(deck1Pack.dealCard() + " / ");
            if((x % 4) == 0)
              System.out.println();
        }         
        
        System.out.println("\n");

        int onePack = 1;
        //refils the deck with one set of 52 cards
        deck1Pack.init(onePack);
        //shuffles the deck
        deck1Pack.shuffle();
        //prints out the dealt cards of the shuffled deck
        for(int x = 1; x < deck1Pack.getTopCard() + 1; ++x)
        {
            System.out.print(deck1Pack.dealCard() + " / ");
            if((x % 4) == 0)
              System.out.println();
        }     
        
        System.out.println();
        System.out.println("\nPress enter to continue...");
        try
        {
           System.in.read();
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }

      /******************************************************
       * Phase 4
       * @author Ricardo Barbosa 
       * @version 11/10/2019
       ******************************************************/
      
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
      Deck d1 = new Deck(2);
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
      Deck d2 = new Deck(2); 
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