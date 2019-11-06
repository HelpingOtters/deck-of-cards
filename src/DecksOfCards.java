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
    }
}