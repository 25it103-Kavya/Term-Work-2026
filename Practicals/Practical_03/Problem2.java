package Practicals.Practical_03;

import java.util.Objects;

class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return Objects.equals(rank, card.rank) && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Card[] incomingCards = {
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("10", "Diamonds"),
            new Card("Ace", "Spades"),
            new Card("King", "Hearts")
        };

        Card[] hand = new Card[incomingCards.length];
        int count = 0;
        boolean duplicatePrinted = false;

        for (Card currentCard : incomingCards) {
            boolean isDuplicate = false;

            for (int i = 0; i < count; i++) {
                if (currentCard.equals(hand[i])) {
                    isDuplicate = true;
                    if (!duplicatePrinted) {
                        System.out.println("Duplicate found: " + currentCard);
                        duplicatePrinted = true;
                    }
                    break;
                }
            }

            if (!isDuplicate) {
                hand[count] = currentCard;
                count++;
            }
        }
    }
}
