package src;
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
   
   //public enum Suit{CLUBS, DIAMONDS, HEARTS, SPADES};

   // constructor
   public Deck(int numPacks)
   {
      /* constructor that populates the arrays and assigns initial 
       * values to members.  
       */
      allocateMasterPack();
      cards = masterPack;
      
      
   }

   // Overloaded constructor 
   public Deck() 
   {
      /* Overloaded constructor so that if no parameters are passed, 
       * 1 pack is assumed.
       */
   }

   public void init(int numPacks) 
   {
      /* re-populate cards[] with the standard 52 × numPacks cards. We should 
       * not repopulate the static array, masterPack[], since that was done 
       * once, in the (first-invoked) constructor and  never changes.
       */
   }
   // made this void for now
   public void shuffle() 
   {
      /* mixes up the cards with the help of the standard random number 
       * generator.
       */
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
      /* this is a private method that will be called by the constructor.  
       * However, it has to be done with a very simple twist:  even if many 
       * Deck objects are constructed in a given program, this static method 
       * will not allow itself to be executed more than once.  Since 
       * masterPack[] is a static, unchanging, entity, it need not be built 
       * every time a new Deck is instantiated.  So this method needs to be 
       * able to ask itself, "Have I been here before?", and if the answer is 
       * "yes", it will immediately return without doing anything;  it has 
       * already built masterPack[] in a previous invocation.
       */
      // Check if this method has already been run. Return if it has.
      if(beenHereBefore) return;
      
      char[] value = 
         {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
     
      
      Suit[] suits = 
         {Card.Suit.DIAMONDS, Card.Suit.SPADES, Card.Suit.HEARTS, Card.Suit.CLUBS};
      
      int curIndex = 0;
      
      for(int x = 0; x < value.length; x++)
      { 
         for(int y = 0; y < suits.length; y++)
         {
            masterPack[curIndex] = new Card(value[x], suits[y]);
            curIndex++;
         }
      }
      
      beenHereBefore = true;
   }


}




