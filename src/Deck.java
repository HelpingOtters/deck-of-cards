package src;

import java.util.Random;

import javax.lang.model.util.ElementScanner6;

import src.Card.Suit;

/*
 * Card.java
 * 
 * @author Lindsey Reynolds
 * @author Dan Sedano
 * @version 11/8/19
 * 
 * The structure for a deck of cards
 */

// added some changes for testing
//added some changes as well 


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
      // If numPacks is too large, automatically make it 6 packs
      if((numPacks * ONE_PACK) >= MAX_CARDS)
         numPacks = 6;

      allocateMasterPack();

      // Create the cards array with 52 x numPacks cards
      cards = new Card[numPacks * ONE_PACK];

      // populate the cards array
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
      int topCard = getTopCard();
      Card dealCard;
      //checks if there are cards in the deck
      if(topCard > 0)
      {
         //assings the top card to the dealCard variable
         dealCard = cards[topCard-1];
         //removes the topcard from the deck
         cards[topCard-1] = null;
         return dealCard;
      }
      //returns null if no more cards
      return null;
   }

   /**
    * Counts the number of cards in the deck
    * @return the number of cards in the deck
    */
   public int getTopCard()
   {
      topCard = 0;
      //traverses the array and counts all non-null elements
      for(int x = 0; x < cards.length; x++)
      {
         if(cards[x] != null)
         topCard++;
      }
      //returns the number of cards
      return topCard;

   }

   /**
    * Accessor for an individual card. Returns a card or
    * returns a card with an error flag.
    *@return the card 
    *@return a card with with an error flag
    */
   public Card inspectCard(int k)
   {
      Card returnCard;

      // If k is out of bounds, return a card with an error flag
      if(k < 0 || k >= topCard)
      {
         // 'E' is not a valid argument, so this card will have errorFlag = true
         returnCard = new Card('E', Card.Suit.CLUBS);
      }
      else 
      {
         returnCard = cards[k];
      }

      return returnCard;
      

      // Check if this cards errorFlag variable is true
      if(returnCard.getErrorFlag())
      {
         // Return a
         return null;
      } 
      // Otherwise, return the good card 
      else
      {
         return returnCard;
      }

      // Dan's code 

      Card inspectCard = null;
      boolean errorFlag = true;
      //checks if the card is valid
      if(cards[k] != null)
      {
         errorFlag = false;
         //if the card is valid it is assigned to the variable
         inspectCard = cards[k];
         //returns the card
         return inspectCard;
      }
      //returns a null card
      else
      {
         errorFlag = true;
         //inspectCard = errorFlag;
         return inspectCard;
      }
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
   /**
    * Returns a String representation of the deck.
    * @return returns a String representation of the deck
    */
   public String toString()
   {
      String deck = "";
      
      for(int x = 0; x < cards.length; x++)
      {
         
         if(cards[x] != null) 
         {
            deck += "Card #"; 
            deck += x;
            deck += " ";
            deck += cards[x];
            deck += "\n";
         }  
    
      }      
      return deck;
   }
   


}

//do not make changes to this
