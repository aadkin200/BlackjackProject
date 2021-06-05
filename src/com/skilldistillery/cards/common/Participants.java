package com.skilldistillery.cards.common;

import java.util.List;

public abstract class Participants {

	private Hand hand;
	
	public Participants() {
		hand = new Hand();
	}
	

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	
	
}
