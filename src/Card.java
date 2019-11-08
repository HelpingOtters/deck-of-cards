/*************************
 * 
 * Card.java
 * 
 * @author Ricardo Barbosa
 *         Max Halbert
 * @version November 6, 2019
 * 
 * The structure for the Card class 
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

    //Overloaded constructor
    public Card()
    {
        this('A', Suit.SPADES);
    }
     // Copy Constructor
     public Card (Card otherCard)
     {
       set(otherCard.value, otherCard.suit);
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
        errorFlag = true;
        return false;
    }

    //Valid card data returned 
    public String toString()
    {
        if(errorFlag)
            return "[Card Not Valid]";
        return value + " of " + suit;

    }

    //Returns true if all field members are identical, false otherwise 
    public boolean equals(Card card)
    {
        if(card == null)
        return false;

        //comparing member values 
        if (this.value == card.value)
        {
            if (this.suit == card.suit)
                return true;
        }
        return false;
    }
    
    //Determine validity for the value
    private boolean isValid(char value, Suit suit)
    {
        //valid card values 
        char[] validCardValues =
        {
            'A','2','3','4','5','6','7','8','9','T','J','Q','K'
        };

        //checks if value is in the field of valid values 
        for (int i = 0; i < validCardValues.length; ++i)
        {
            if (value == validCardValues[i])
            return true;
        }
        //invalid value
        return false;
    }
}
