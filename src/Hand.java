/**
 * Hand.java
 * 
 * @author Max Halbert
 * @author Ricardo
 * 
 * The hands of the Card class 
 */

public class Hand 
{
    public static final int MAX_CARDS = 50;
    private Card[] myCards = new Card[MAX_CARDS];
    private int numCards;

    /**
     * Initialize the hand by creating an empty array
     */
    public Hand()
    {
        resetHand();
    }

    /**
     * Resets the hand by emptying the array 
     */
    public void resetHand()
    {
        myCards = new Card[MAX_CARDS];
        numCards = 0;
    }

    /**
     * Adds card to hand 
     */
    public boolean takeCard(Card card)
    {
        if (numCards >= MAX_CARDS)
        {
            return false;
        }

        Card newCard = new Card(card.getValue(), card.getSuit());
        myCards[numCards++] = newCard;
        return true;
    }

    /**
     * playCard() will remove the recent card from hand and return it 
     */

    /**
     * Stringify the current hand 
    */

    /**
     * Return number of cards in the hand 
     */

    /**
    * Returns individual card 
    */


}