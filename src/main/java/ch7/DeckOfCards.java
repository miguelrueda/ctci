package ch7;

import java.util.ArrayList;

public class DeckOfCards {

    public enum Suit {
        Club(0),
        Diamond(1),
        Heart(2),
        Spade(3);

        private int value;

        private Suit(int v) {
            value = v;
        }

        public int getValue() {
            return value;
        }

        public static Suit getSuitFromValue(int value) {
            for (Suit s : Suit.values()) {
                if (s.value == value) {
                    return s;
                }
            }
            return null;
        }
    }

    public class Deck <T extends Card> {
        private ArrayList<T> cards; // All card, dealt or not
        private int dealtIndex = 0; // marks first undealt card

        public void setDeckOfCards(ArrayList<T> deckOfCards) {
            this.cards = deckOfCards;
        }

        public void shuffle() {}

        public int remainingCards() {
            return cards.size() - dealtIndex;
        }

        public T[] dealHand(int number) {
            return null;
        }

        public T dealCard() {
            return null;
        }
    }

    public abstract class Card {

        private boolean available = true;

        // Number of face that's on card - a number 2 through 10, or 11 for jack, 12 for queen, 13 for king
        // or 1 for ace
        protected int faceValue;
        protected Suit suit;

        public Card(int c, Suit s) {
            faceValue = c;
            suit = s;
        }

        public abstract int value();
        public Suit suit() {
            return suit;
        }

        // Checks if the card is available to be given out to someone
        public boolean isAvailable() {
            return available;
        }

        public void markUnavailable() {
            available = false;
        }

        public void markAvailable() {
            available = true;
        }
    }

    public class Hand <T extends Card> {
        protected ArrayList<T> cards = new ArrayList<>();

        public int score() {
            int score = 0;
            for (T card: cards) {
                score += card.value();
            }
            return score;
        }

        public void addCard(T card) {
            cards.add(card);
        }
    }

    public static void main(String[] args) {
        System.out.println(Suit.getSuitFromValue(3));
    }
}
