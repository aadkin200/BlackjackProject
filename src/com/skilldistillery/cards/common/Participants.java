package com.skilldistillery.cards.common;

import java.util.List;

public abstract class Participants {

	private Hand hand;
	
	public Participants() {
		hand = new Hand();
	}
	
	public void resetDeck() {
		if(hand.deck.checkDeckSize() < 10) {
			hand.deck = new Deck();
		}
	}
	

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	
	
}
