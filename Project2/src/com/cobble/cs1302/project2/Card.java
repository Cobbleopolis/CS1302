//Class:      CS1302/08
//Term:       Spring 2017
//Name:       Logan Thompson
//Instructor: Monisha Verma
//Assignment: Project 2 | Option 2
package com.cobble.cs1302.project2;

public class Card {

    static final int DECK_SIZE = Suit.values().length * Rank.values().length;

    static final int MAX_SHUFFLE_COUNT = 100;

    private Suit suit;

    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            Card otherCard = (Card) obj;
            return this.suit == otherCard.suit && this.rank == otherCard.rank;
        } else
            return false;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public static Card[] getFullDeck() {
        return getFullDeck(0);
    }

    public static Card[] getFullDeck(int shuffleCount) {
        Card[] deck = new Card[Card.DECK_SIZE];
        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();
        int index = 0;
        for (Suit suit : suits)
            for (Rank rank : ranks) {
                deck[index] = new Card(suit, rank);
                index++;
            }
        for (int i = 0; i < shuffleCount; i++) {
            int swapIndex1 = Project2.rand.nextInt(Card.DECK_SIZE);
            int swapIndex2;
            do {
                swapIndex2 = Project2.rand.nextInt(Card.DECK_SIZE);
            } while (swapIndex2 != swapIndex1);
            Card tmp = deck[swapIndex1];
            deck[swapIndex1] = deck[swapIndex2];
            deck[swapIndex2] = tmp;
        }
        return deck;
    }

}