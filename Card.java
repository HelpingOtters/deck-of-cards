/*************************
 * 
 * Card.java
 * 
 * @author 
 * @version
 * 
 * The structures for a playing card 
*/

public class Card 
{
    public enum Suit
    {
        CLUBS, DIAMONDS, HEARTS, SPADES
    };

    //card values 
    private char value;
    private Suit suit;

    //Checks for illegal card data
    private boolean errorFlag;

    //Constructors
    /**
     * Call the proper mutators.
     * Must overload public Card for client who wishes to use 
     * 'A' and suit.Spades as the default
     * 
     */

     //Accessors 
     /**
      * getSuit(), getValue(), getErrorFlag()
      */

      //Mutators 
      public boolean set(char value, Suit suit)
      {
          //check for validity
      
      //not valid, don't mutate
      /**
       * returns false 
       */
      }

      //Valid card data returned 
      public String toString()
      {
          //if statement with errorFlag as parameter
          //else return value + 'of' + suit string 
      }

      //Returns true if all field members are identical, false otherwise 
      public boolean equals(Card card)
      {
          //determine how to check if field members are true 
      }
      
      //Determine validity for the value
      private boolean isValid(char value, Suit suit)
      {
          //valid card values

          //checks if values are valid 
      }
    }
