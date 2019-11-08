/**************
 * 
 * DecksOfCards.Java
 * 
 * Dan
 * Lindsey
 * Max
 * Ricardo
 * 
 * Simulation of dealing out playing cards 
*/

import java.util.Scanner;

public class DecksOfCards
{
    private static final String CARD_TESTER = "---Card Tester---";

    public static void main(String[] arg) {
        // Phase One CARD CLASS

        System.out.println(CARD_TESTER);
        Card card1 = new Card();
        Card card2 = new Card('Z', Card.Suit.DIAMONDS);
        Card card3 = new Card('T', Card.Suit.CLUBS);

        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);

        //Phase Two HAND CLASS

        System.out.println();
        System.out.println("---Hand Tester---");
        Hand hand1 = new Hand();
        while(true)
        {
            hand1.takeCard(new Card('3', Card.Suit.CLUBS));
            hand1.takeCard(new Card('T', Card.Suit.CLUBS));
            hand1.takeCard(new Card('9', Card.Suit.HEARTS));
            hand1.takeCard(new Card('T', Card.Suit.SPADES));
            boolean lastCardPlayed = hand1.takeCard(new Card('3', Card.Suit.CLUBS));
            if(!lastCardPlayed)
            {
                System.out.println("Hand full");
                System.out.println("After deal");
                break;
            }
        }

        System.out.println(hand1.toString());
        System.out.println();
        System.out.println("---inspectCard() Tester---");
        System.out.println(hand1.inspectCard(42));
        System.out.println(hand1.inspectCard(420));
        System.out.println();

        while (hand1.getNumCards() != 0)
        {
            System.out.println("Playing " + hand1.playCard());
        }

        System.out.println(hand1.toString());

    }

}