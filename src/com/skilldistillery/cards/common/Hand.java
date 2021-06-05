package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	List<Card> cards = new ArrayList<>();
//	Static so all hands share the same deck *****
	public static Deck deck = new Deck();
	public Hand() {
		cards.add(deck.dealCard());
		cards.add(deck.dealCard());
		
	}
	
	public int getHandValue() {
		int value = 0;
		for(Card card : cards) {
			value += card.getValue();
		}
		return value;
	}
	
	public List<Card> getCards() {
		return this.cards;
	}
	
	public void fold() {
		cards.clear();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void displayHand() {
		for(int i=0; i<this.cards.size(); i++) {
			System.out.println(this.getCards().get(i).toString());
		}
	}

	@Override
	public String toString() {
		return "Hand [cards=" + cards + "]";
	}
	
	
}
