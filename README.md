# Classes to the Card Game 
Card: The Card class has two obvious members:  value (a char)  and suit (an enum).  But we add a new boolean, errorFlag, which can inform a client that a card is in an illegal state. We'll want the usual constructors, mutators, accessors and toString() methods for the class.  We only allow standard cards, like ('A', clubs), ('9', hearts) and ('T', diamonds), no jokers or other special cards.

Hand:  As you can see, a Hand object usually contains several cards, so we'll need an array of Card objects (myArray) as the principal member of the Hand class.  Since each game deals a different number of cards into its players hands, and even within a game the number of cards in a hand will increase or decrease, we must keep track of this with an int value (numCards).  We'll need constructors, mutators, etc., of course.  We'll also want a way for the hand to receive a card (from the deck or somewhere else), and play a card (to the table or to another player).  These two methods will be called takeCard() and playCard(), respectively.  Since this class has no information about the game being played, it always puts new cards received by takeCard() into the next available location of the array (index position numCards) and plays a card via playCard() from the highest occupied location (index position numCards - 1).  The client game application would somehow prepare this highest position with the correct card to be played before calling Hand's playCard() method.  This detail is not our concern.

Deck: A Deck object is the source of all cards.  It's where the dealer gets cards to deal, and if a player takes an individual card after the deal, he takes it from the Deck object.  Naturally, the primary member here is an array of Card objects, much like Hand.  We'll call this member cards[].  A deck normally consists of a single pack of cards: 52 cards (four suits of 13 values each).  However, some games use two, three or more packs.  If a card game requires two packs, then the deck will consist of two full 52-card packs:  104 cards.  (Many games throw away some cards before beginning.  For example Pinochle wants all cards with values 8-and-below to be taken out of the deck, but we will not trouble ourselves with this complexity.)  A newly instantiated deck will have a multiple of 52 cards and will contain all the standard cards, so the number of cards in a newly instantiated deck will be 52, 104, 156, ...,  i.e., numPacks × 52.

Clearly, we need an int like Hand's numCards, to keep track of how many cards are actually in the cards[] array.  To this end, we'll use topCard (not numCards), since a deck typically removes and delivers cards to players from the top-of-the-deck, and this is a convenient variable to use for the number of cards as well as the position of the top of the deck.

There are a few other useful members (numPacks, for example).  In addition to the the usual constructors and accessors, we'll want a dealCard() to return and remove the card at the top of the deck (which may be received by a client and added to some player's hand), and a shuffle() to re-order the cards in a random fashion.  Also, we'll need to restock the deck (init()) to the original full condition in preparation for a fresh deal (we would certainly not want to re-instantiate a new deck when we have a perfectly good one available:  garbage collection, done by us or by the operating system, is a resource we do not abuse).

**There will be one main class and three other classes.  Put everything that is needed for testing in one main().  Submit only one .txt file that has all classes and output.

#The Card Class
A Public enum Type 
Suit enum, { clubs, diamonds, hearts, spades }, inside the Card class. 
Private Member Data
char value;
Suit suit;
boolean errorFlag;
Public Methods
Card(char value, Suit suit) - constructor
string toString() 
boolean set(char value, Suit suit) 
Accessors for suit and value.
Accessor for errorFlag.
boolean equals(Card card) 
Private Methods
boolean isValid(char value, Suit suit) .
Test of Card class
Create a main() 
Instantiate three cards, two legally, and one illegally. 
Print all three out and confirm. 
Make good card bad by set() with an illegal value, and change the initial illegal card to a legal one by setting a legal value.


#The Hand Class
Static Class Constants
public static final int MAX_CARDS = (50 or 100)
Private Member Data
Card[] myCards;
int numCards;
 
Public Methods
Hand() - a default constructor.
void resetHand() 
boolean takeCard(Card card)
Card playCard() 
String toString() 
Accessor for numCards
Card inspectCard(int k)
Test of Hand class
Create between two and five explicit Card objects and one Hand object
Use takeCard() on these few cards 
Display the hand using toString()
Play each card in a loop, until the hand is empty
Display the card played as it is played
Display the (now empty)  hand, verifying that no cards remain. 
Test inspectCard() with both legal and illegal int arguments.

#The Deck Class
Public Static Class Constants
public static final int MAX_CARDS = (6 x 52)
Private Static Member Data
Card[] masterPack
Private Member Data
Card[] cards;
 int topCard;

Public Methods
Deck(int numPacks) - constructor
void init(int numPacks) 
void shuffle() 
Card dealCard() 
An accessor for topCard 
Card inspectCard(int k)
Private Methods
static void allocateMasterPack() 
Test of Class Deck
Declare a deck containing two packs of cards. Do not shuffle.  
Deal all the cards in a loop until the deck is empty 
Display each card as it comes off the deck
Reset the deck by initializing it again (to the same two packs).  Shuffle.
Re-deal to the screen in a loop again.

#The Deck and Hand Classes
Methods
main()
Ask the user to select the number of players 
Instantiate a single-pack Deck object without shuffling
Deal a deck into that many Hand objects, dealing all cards until the deck is empty  
Display all the hands after the deal. 
Reset the objects to their initial state. Shuffle the deck before a second deal (same # of players)

