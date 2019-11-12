package src;
/*****************************************************************
 * Hand.java 
 * 
 * @author  Max Halbert
 * @author  Ricardo Barbosa      
 * @version November 7, 2019
 * 
 * Description: Class contains cards in a hand 
 * 
 * Usage: Take a card or a play a card from that hand 
*******************************************************************/

public class Hand
{
  
   public static final  int MAX_CARDS = 52; // a hand can only have 52 cards maximum
   
   private Card[] myCards;
   private int numCards;
   
   //Constructor
   public Hand()
   {
      myCards = new Card[MAX_CARDS];
      numCards = 0;
   }
   
   /**
    * resets hand 
    */
   public void resetHand()
   {
      numCards = 0;  
   }
   
   /**
    * adds a card to the next available position 
    * @param card
    * @return boolean
    */
   public boolean takeCard(Card card)
   {
      if(numCards < MAX_CARDS && card != null && !card.getErrorFlag())
      {
         Card tempCard = new Card(card);  
         myCards[numCards] = tempCard;
         numCards++;
         return true;     
      }
      return false;
   }
   
   /**
    * plays the card until nno more in hand 
    * @return null
    */
   public Card playCard()
   {
      if(numCards > 0)
      {
         numCards--;
         return myCards[numCards];
      }
      
      return null;  // since no more cards in the hand
   }
   
   //stringifies the hand 
   public String toString()
   {
      String myHand = "";
      if(numCards > 0)
      {
         myHand += myCards[0];
         for(int i = 1 ; i < numCards; i++)
         {
            myHand += ", " + myCards[i];
         }
      }
      return myHand;
   }
   
   //Accessor
   public int getNumCards()
   {
      return numCards;
   }

   //Accessor 
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