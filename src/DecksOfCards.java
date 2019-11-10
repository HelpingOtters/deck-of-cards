package src;
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
        /*
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

        */

        // Phase 3 Deck Class
        /**
         * Declare a deck containing two packs of cards. Do not shuffle.  Deal all the cards in a loop until the deck is empty 
         * (dealt directly to the display/screen, not to any Hand objects just yet).  Display each card as it comes off the deck. 
         * Next, reset the deck by initializing it again (to the same two packs).  
         * Shuffle the deck this time, and re-deal to the screen in a loop again. Notice that the cards are now coming off in a random order.
         * Repeat this double deal, unshuffled, then shuffled, but this time using a single pack deck.
         */
        System.out.println("\n--------------------------------------------------------");
        int twoPacks = 2;
        int twoPacksOfCards = 104;
        //creats a deck of 104 cards (two packs)
        Deck deck2Pack = new Deck(twoPacks);
        //prints out the dealt cards in an unshuffled deck
        for(int x = 1; x < twoPacksOfCards + 1; ++x)
        {
           System.out.print(deck2Pack.dealCard() + " / ");
           if((x % 4) == 0)
              System.out.println();
        }         
        
        System.out.println();
        //refills the deck
        deck2Pack.init(twoPacks);
        //shuffles the deck
        deck2Pack.shuffle();
        //prints out the dealt cars of a shuffled deck
        for(int x = 1; x < twoPacksOfCards + 1; ++x)
        {
           System.out.print(deck2Pack.dealCard() + " / ");
           if((x % 4) == 0)
              System.out.println();
        }             
        System.out.println("\n--------------------------------------------------------"); 
        //creats a deck of 52 cards
        Deck deck1Pack = new Deck();
        int onePackOfCards = 52;
        //prints out the dealt cards of an unshuffled deck
        for(int x = 1; x < onePackOfCards + 1; ++x)
        {
            System.out.print(deck1Pack.dealCard() + " / ");
            if((x % 4) == 0)
              System.out.println();
        }         
        
        System.out.println("\n");

        int onePack = 1;
        //refils the deck with one set of 52 cards
        deck1Pack.init(onePack);
        //shuffles the deck
        deck1Pack.shuffle();
        //prints out the dealt cards of the shuffled deck
        for(int x = 1; x < onePackOfCards + 1; ++x)
        {
            System.out.print(deck1Pack.dealCard() + " / ");
            if((x % 4) == 0)
              System.out.println();
        }     

    }

}
