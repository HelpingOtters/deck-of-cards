package src;
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
   
   // static variable to keep track if the master pack has already been created
   public static boolean beenHereBefore = false;

   // private member data
   private static Card[] masterPack = new Card[ONE_PACK];
   private Card[] cards;
   private int topCard;
<<<<<<< HEAD
=======
   
   public enum Suit{CLUBS, DIAMONDS, HEARTS, SPADES};
>>>>>>> parent of d88d8fb... fixed Suit enum errors with import

   // constructor
   public Deck(int numPacks)
   {
      /* constructor that populates the arrays and assigns initial 
       * values to members.  
       */
<<<<<<< HEAD
      allocateMasterPack();
      //cards = masterPack;
      
      
=======
>>>>>>> parent of d88d8fb... fixed Suit enum errors with import
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
      // Check if this method has already been run. Return if it has.
      if(beenHereBefore) return;
      
      char[] value = 
         {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
<<<<<<< HEAD
=======
      
      Suit[] suits = {Suit.DIAMONDS, Suit.SPADES, Suit.HEARTS, Suit.CLUBS};
>>>>>>> parent of d88d8fb... fixed Suit enum errors with import
      
      int curIndex = 0;
      
      for(int x = 0; x < value.length; x++)
<<<<<<< HEAD
      { 
         Card card = new Card(value[x], Card.Suit.DIAMONDS);
         
         masterPack[curIndex] = new Card(value[x], Card.Suit.DIAMONDS);
         
         /*masterPack[curIndex] = new Card(value[x], Card.Suit.DIAMONDS);
         masterPack[curIndex + 1] = new Card(value[x], Card.Suit.SPADES);
         masterPack[curIndex + 2] = new Card(value[x], Card.Suit.HEARTS);
         masterPack[curIndex + 3] = new Card(value[x], Card.Suit.CLUBS);
         */
         curIndex += 4;
            
         System.out.println(card.toString());
         System.out.println(masterPack[].toString());
        
=======
      {
         
         for(int y = 0; y < suits.length; y++)
         {
            masterPack[curIndex] = new Card(value[x], suits[y]);
            curIndex++;
         }
         
>>>>>>> parent of d88d8fb... fixed Suit enum errors with import
      }
      
      
      beenHereBefore = true;
   }

   public static void main(String[] args)
   {
      Deck deck = new Deck(1);
      
   }
   
}






