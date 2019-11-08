/**
 * Hand.java
 * 
 * @author Ricardo Barbosa
 *         Max Halbert
 * 
 * The hands of the Card class 
 */

// public class Hand 
// {
//     public static final int MAX_CARDS = 50;
//     private Card[] myCards = new Card[MAX_CARDS];
//     private int numCards;

//     /**
//      * Initialize the hand by creating an empty array
//      */
//     public Hand()
//     {
//         resetHand();
//     }

//     /**
//      * Resets the hand by emptying the array 
//      */
//     public void resetHand()
//     {
//         myCards = new Card[MAX_CARDS];
//         numCards = 0;
//     }

//     /**
//      * Adds card to hand until hand is full 
//      */
//     public boolean takeCard(Card card)
//     {
//         if (numCards >= MAX_CARDS)
//         {
//             return false;
//         }

//         Card newCard = new Card(card.getValue(), card.getSuit());
//         myCards[numCards++] = newCard;
//         return true;
//     }

//     /**
//      * playCard() will remove the recent card from hand and return it 
//      */
//     public Card playCard()
//     {
//         numCards--;
//         Card card = myCards[numCards];
//         myCards[numCards] = null;
//         return card;
//     }

//     /**
//      * Stringify the current hand 
//     */
//     public String toString()
//     {
//         String currentHand= "";
//         for (int i = 0; i < numCards; i++)
//         {
//             currentHand += myCards[i] + " ";
//         }
//         return "Hand = ( " + currentHand + ")";

//     }

//     /**
//      * Return number of cards in the hand 
//      */
//     public int getNumCards()
//     {
//         return numCards;
//     }

//     /**
//     * Returns individual card 
//     */
//     public Card inspectCard(int k)
//     {
//         if (k >= 0 && k < MAX_CARDS)
//         {
//             return myCards[k];
//         }

//         return new Card('Z', Card.Suit.DIAMONDS);
//     }

// }

/**
 * 
 * Hand.java class contains cards of a hand and number of cards in the hand
 * take a card to the hand or play a card from the hand
 * 
 * @author  Max Halbert
 *          Ricardo Barbosa
 *          
 * @version November 7, 2019
 * 
*/

public class Hand
{
  
   public static final  int MAX_CARDS = 52; // a hand can only have 52 cards maximum
   
   private Card[] myCards;
   private int numCards;
   
   public Hand()
   {
      myCards = new Card[MAX_CARDS];
      numCards = 0;
   }
   
   public void resetHand()
   {
      numCards = 0;  // the same myCards array will be reused for next hand
   }
   
   public boolean takeCard(Card card)
   {
      if(numCards < MAX_CARDS && card != null && !card.getErrorFlag())
      {
         Card tempCard = new Card(card);  // prevent privacy leaks
         myCards[numCards] = tempCard;
         numCards++;
         return true;     
      }
      return false;
   }
   
   public Card playCard()
   {
      if(numCards > 0)
      {
         numCards--;
         return myCards[numCards];
      }
      
      return null;  // since no more cards in the hand
   }
   
   public String toString()
   {
      String myHand = "";
      for(int i =0; i < numCards; i++)
      {
         if(i == numCards - 1)
            myHand += myCards[i];
         else
            myHand += myCards[i] + ", ";
         
      }
      
      return "\nAfter playing all cards\nHand = (" + myHand + " )";
   }
   
   public int getNumCards()
   {
      return numCards;
   }
   
   public Card inspectCard(int k)
   {

      if (k >= 0 && k < numCards)  // assume valid k starts from 0
      {
         Card aCard = new Card(myCards[k]);  // prevent privacy leaks
         return aCard;
      }
      
      // return a dummy invalid card
      Card badCard = new Card(' ', Card.Suit.SPADES); 
      return badCard;

   }
}