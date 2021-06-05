package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	List<Card> deck = new ArrayList<>();
	
	public Deck() {
		Suit[] suit = Suit.values();
		Rank[] rank = Rank.values();
		for(int i=0; i<suit.length; i++) {
			for(int j=0; j<rank.length; j++) {
				Card card = new Card(suit[i], rank[j]);
				deck.add(card);
			}
		}
	}
	
	public int checkDeckSize() {
		if(deck == null) {
			return -1;
		}
		return deck.size();
	}
	
	public Card dealCard() {
		shuffle();
		return deck.remove(0);
	}
	
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
}
