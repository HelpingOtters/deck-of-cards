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
    public Card(char value, Suit suit)
    {
        set(value, suit);
    }

    public Card()
    {
        this('A', Suit.SPADES);
    }

     //Accessors 
     public Suit getSuit()
     {
         return suit;
     }

     public char getValue()
     {
         return value;
     }

     public boolean getErrorFlag()
     {
         return errorFlag;
     }

      //Mutators 
      public boolean set(char value, Suit suit)
      {
          if(isValid(value, suit))
          {
              this.value = value;
              this.suit = suit;
              errorFlag = false;
              return true;
          }
          erroFlag = true;
          return false;
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
}