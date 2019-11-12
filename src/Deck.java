package src;

import java.util.Random;

import javax.lang.model.util.ElementScanner6;

import src.Card.Suit;

/************************************************************
 * Deck.java
 * 
 * @author Lindsey Reynolds
 * @author Dan Sedano
 * @version 11/8/19
 * 
 * Description: Creates a deck of cards 
 * Usage: Holds up to six decks of 52 playing cards 
 ************************************************************/

public class Deck 
{
   //playing card pack values 
   public static final int MAX_CARDS = 312; // 6 packs x 52 cards
   public static final int ONE_PACK = 52; // Standard 52 card deck
   public static boolean beenHereBefore = false; 

   //creates a new object with one pack of cards 
   private static Card[] masterPack = new Card[ONE_PACK];

   private Card[] cards;
   private int topCard;

   /**
    * Constructor that takes in a number of packs as an argument and then creates a deck 
    * of cards with that many packs of cards (52 x numPacks)
    * @param numPacks
    */
   public Deck(int numPacks)
   {
      // maximum packs is 6
      if((numPacks * ONE_PACK) > MAX_CARDS)
         numPacks = 6;

      allocateMasterPack();

      // create the cards array with 52 x numPacks cards
      cards = new Card[numPacks * ONE_PACK];

      // populate the cards in the deck 
      init(numPacks);
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

      // Initialize the last index of the array to be the top card of the deck  
      topCard = cards.length;
      
      // Loop through the cards array, populating it with Cards
      for(int i = 0; i < cards.length; i++)
      {
         // Create a new Card Object, copying it from the masterPack
         cards[i] = new Card(masterPack[i]);
      }
   }

   /**
    * Method to re-populate cards[] with 52 x numPacks cards.
    * @param numPacks
    */
   public void init(int numPacks) 
   {
      
      // Initialize the last index of the array to be the top card of the deck  
      topCard = cards.length;
      
      // Populate the card array with Card objects, copying values from masterPack
      for(int masterCounter = 0, i = 0; i < cards.length; i++, masterCounter++)
      {
         // Create a new Card Object, copying it from the masterPack
         cards[i] = new Card(masterPack[masterCounter]);

         // If the cards array is more than one pack, reset the index of masterPack 
         // in order to loop through it again
         if(masterCounter == ONE_PACK - 1) 
            masterCounter = -1;
      }
   }
   
   /**
    * Shuffles the deck of Cards
    */
   public void shuffle() 
   {
      Random shuffle = new Random();
      Card tempCard;
      int randCard;

      //loops through the entire deck
      for(int x = 0; x < cards.length; x++)
      {
        //Picks a random card from the deck
        randCard = shuffle.nextInt(ONE_PACK);
        //assigns the random card to a placeholder
        tempCard = cards[randCard];
        //assigns the random card to the next card in the deck
        cards[randCard] = cards[x];
        //assigns the next card in the deck to the card in 
        //the place holder
        cards[x] = tempCard;
      }      
    }
   
    /**
     * Deals a card by taking the top of the deck and
     * makes sure there are still cards available.
     * @return the top Card from the deck.
     */
   public Card dealCard()
   {
      //int topCard = getTopCard();
      
      Card dealCard;

      //checks if there are cards in the deck
      if(topCard > 0)
      {
         //assigns the top card to the dealCard variable
         dealCard = cards[getTopCard()-1];

         //removes the topcard from the deck
         cards[getTopCard()-1] = null;

         //decreases card count
         topCard--;
         return dealCard;
      }
      //returns null if no more cards
      return null;
   }

   /**
    * Returns the number of cards in a deck.
    * @return the number of cards in the deck
    */
   public int getTopCard()
   {
      return topCard;
   }

   /**
    * Accessor for an individual card. Returns a card or
    * returns a card with an error flag.
    * @return the card at index k
    * @return a card with with an error flag
    */
   public Card inspectCard(int k)
   {
      Card returnCard;

      // If k is out of bounds, return a card with an error flag
      if(k < 0 || k >= topCard)
      {
         // Create an invalid card with errorFlag = true
         returnCard = new Card('E', Card.Suit.CLUBS);
      }
      else 
      {
         // Otherwise return the card at k index
         returnCard = cards[k];
      }
      return returnCard;
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
}


