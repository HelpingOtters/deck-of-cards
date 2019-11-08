package src;

import java.util.Random;

import javax.lang.model.util.ElementScanner6;

import src.Card.Suit;

/*
 * Card.java
 * 
 * @author 
 * @version
 * 
 * The structure for a deck of cards
 */

public class Deck 
{
   // public static variable for maximum cards in a deck
   public static final int MAX_CARDS = 312; // 6 x 52
   public static final int ONE_PACK = 52;
   public static boolean beenHereBefore = false;

   // private static variable for master pack of cards
   private static Card[] masterPack = new Card[ONE_PACK];

   // private member data
   private Card[] cards;
   private int topCard;

   /**
    * Constructor that takes in a number of packs as an argument and then creates a deck 
    * of cards with that many pakcs of cards (52 x numPacks)
    * @param numPacks
    */
   public Deck(int numPacks)
   {
      allocateMasterPack();

      // Create the cards array with the correct number of packs
      cards = new Card[numPacks * ONE_PACK];
      
      // Variable to keep track of the current index in masterPack 
      int masterCounter = 0;
      
      // Populate the card array with Card objects, copying values from masterPack
      for(int i = 0; i < cards.length; i++, masterCounter++)
      {
         // Create a new Card Object, copying it from the masterPack
         cards[i] = new Card(masterPack[masterCounter]);

         // If the cards array is more than one pack, reset the index of masterPack 
         // in order to loop through it again
         if(masterCounter == ONE_PACK - 1) 
            masterCounter = -1;
      }
   }

   /*
    * Overloaded no argument constructor that creates a pack of cards using 
    * just one deck
    */
   public Deck() 
   {
      allocateMasterPack();

      // Create the cards array using one pack of cards
      cards = new Card[ONE_PACK];
      
      // Loop through the cards array, populating it with Cards
      for(int i = 0; i < cards.length; i++)
      {
         // Create a new Card Object, copying it from the masterPack
         cards[i] = new Card(masterPack[i]);
      }
   }

   public void init(int numPacks) 
   {
      /* re-populate cards[] with the standard 52 × numPacks cards. We should 
       * not repopulate the static array, masterPack[], since that was done 
       * once, in the (first-invoked) constructor and  never changes.
       */

   }
   // made this void for now
   /* mixes up the cards with the help of the standard random number 
    * generator.
    */
    public void shuffle() 
    {
       Random shuffle = new Random();
       Card tempCard;
       int randCard;

       for(int x = 0; x < cards.length; x++)
       {
         randCard = shuffle.nextInt(ONE_PACK);
         tempCard = cards[randCard];
         cards[randCard] = cards[x];
         cards[x] = tempCard;
       }
 
    }

   public Card dealCard()
   {
      return null;
      /* returns and removes the card in the top occupied position of cards[]. 
       * Make sure there are still cards available.
       */
   }

   public int getTopCard()
   {
      return topCard;

   }

   public Card inspectCard(int k)
   {
      return null;
      /* Accessor for an individual card.  Returns a card with 
       * errorFlag = true if k is bad.
       */
   }

   private static void allocateMasterPack()
   {
      // Check if this method has already been run. Return if it has.
      if(beenHereBefore) return;
      
      char[] value = 
         {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
     
      Suit[] suits = 
         {Card.Suit.DIAMONDS, Card.Suit.SPADES, Card.Suit.HEARTS, Card.Suit.CLUBS};
      
      int curIndex = 0;
      
      // Loop through the value array
      for(int x = 0; x < value.length; x++)
      { 
         // Loop through the suits array
         for(int y = 0; y < suits.length; y++)
         {
            // Create a new Card object with the correct suit and value
            masterPack[curIndex] = new Card(value[x], suits[y]);
            curIndex++;
         }
      }
      
      beenHereBefore = true;
   }
   public String toString()
   {
      String deck = "";
      
      for(int x = 0; x < cards.length; x++)
      {
            deck += cards[x];
            //deck += " ";
         
         deck += "\n";   
      }      
      return deck;
   }
   


}