//Class:      CS1302/08
//Term:       Spring 2017
//Name:       Logan Thompson
//Instructor: Monisha Verma
//Assignment: Project 2 | Option 2
package com.cobble.cs1302.project2;

public class Card {

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

}