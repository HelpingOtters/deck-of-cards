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
   public static final int ONE_PACK = 1;
   public static final int TWO_PACK = 2;
   public static void main(String[] args)
   {

      Scanner keyboard = new Scanner(System.in);
       
        System.out.println("\n--------------------------------------------------------");
        //creats a deck of 104 cards (two packs)
        Deck deck2Pack = new Deck(TWO_PACK);
        int twoPacksofCards = 104;
        //prints out the dealt cards in an unshuffled deck
        for(int x = 1; x < twoPacksofCards + 1; ++x)
        {
           System.out.print(deck2Pack.dealCard() + " / ");
           if((x % 4) == 0)
              System.out.println();
        }         
        
        System.out.println();
        //refills the deck
        deck2Pack.init(TWO_PACK);
        //shuffles the deck
        deck2Pack.shuffle();
        //prints out the dealt cars of a shuffled deck
        for(int x = 1; x < twoPacksofCards + 1; ++x)
        {
           System.out.print(deck2Pack.dealCard() + " / ");
           if((x % 4) == 0)
              System.out.println();
        }             
        System.out.println("\n--------------------------------------------------------"); 
        //creats a deck of 52 cards
        Deck deck1Pack = new Deck();
        int onePackOfCards = 52;
        //prints out the dealt cards of an unshuffled deck
        for(int x = 1; x < onePackOfCards + 1; ++x)
        {
            System.out.print(deck1Pack.dealCard() + " / ");
            if((x % 4) == 0)
              System.out.println();
        }         
        
        System.out.println("\n");

        //refils the deck with one set of 52 cards
        deck1Pack.init(ONE_PACK);
        //shuffles the deck
        deck1Pack.shuffle();
        //prints out the dealt cards of the shuffled deck
        for(int x = 1; x < onePackOfCards + 1; ++x)
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
      Deck d1 = new Deck();
      Hand[] myHands = new Hand[numHands];
      int thisCard = d1.getTopCard();
      for (int thisHand = 0; thisHand < numHands; ++thisHand)
      {
         myHands[thisHand] = new Hand();
      }
      System.out.println("Here are our hands, from unshuffled deck: ");
      while (d1.inspectCard(thisCard-1).getErrorFlag() == false)
      {
         for (int thisHand = 0; thisHand < numHands; ++thisHand)
         {
            if (thisCard == 0)
            {
               break;
            }
            myHands[thisHand].takeCard(d1.dealCard());
            --thisCard;
         }
      }
      for (int thisHand = 0; thisHand < numHands; ++thisHand)
      {
         System.out.println((thisHand+1) + ") " + myHands[thisHand].toString());
         myHands[thisHand].resetHand();
      }
      System.out.println();

      //Reset the deck
      d1.init(1); 
      //Shuffled deck
      d1.shuffle();

      thisCard = d1.getTopCard();
      System.out.println("Here are our hands from a shuffled deck: ");
      while (d1.inspectCard(thisCard-1).getErrorFlag() == false)
      {
         for(int thisHand = 0; thisHand < numHands; ++thisHand)
         {
            if(thisCard == 0)
            {
               break;
            }
            myHands[thisHand].takeCard(d1.dealCard());
            --thisCard;
         }
      }
      for(int thisHand = 0; thisHand < numHands; ++thisHand)
      {
         System.out.println((thisHand+1) + ") " + myHands[thisHand].toString());
      }
      keyboard.close();

   }

}