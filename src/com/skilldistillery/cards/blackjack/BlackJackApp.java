package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Dealer;
import com.skilldistillery.cards.common.Hand;
import com.skilldistillery.cards.common.Participants;
import com.skilldistillery.cards.common.Player;

public class BlackJackApp {
	Scanner input = new Scanner(System.in);
	private boolean stand = false;

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.welcome();
	}

//	Welcome screen
	public void welcome() {
		System.out.println("Welcome to BlackJack!");
		System.out.println("1. Play");
		System.out.println("2. Exit");
		int choice = choice();
		switch (choice) {
		case 1:
			game();
			break;
		case 2:
			System.out.println("Thanks for playing!");
			System.exit(0);
		}
	}

//	flow of game is controlled here
	public void game() {
		stand = false;
		Participants player = new Player();
		Participants dealer = new Dealer();
		dealer.resetDeck();
		boolean running = true;
		while (running) {
			displayHands(player, dealer);
			hitOrStandMenu(player, dealer);
			checkBlackJack(player, dealer);
			int choice = choice();
			switch (choice) {
			case 1:
				deal(player);
				break;
			case 2:
				stand = true;
				stand(player, dealer);
				break;
			}
			checkBust(player, dealer);
			if (stand == true) {
				checkWinner(player, dealer);
			}
		}
	}

	public void checkBlackJack(Participants player, Participants dealer) {
		if (player.getHand().getHandValue() == 21 && dealer.getHand().getHandValue() == 21) {
			System.out.println("*************** You and Dealer Blackjack! ***************");
			bustMenu(player, dealer);
		} else if(player.getHand().getHandValue() == 21) {
			System.out.println("*************** You Blackjack! ***************");
			bustMenu(player, dealer);
		} else if(dealer.getHand().getHandValue() == 21) {
			System.out.println("*************** Dealer Blackjack! ***************");
			bustMenu(player, dealer);
		}
	}
	public void checkBust(Participants player, Participants dealer) {
		if (bust(player)) {
			System.out.println("*************** You busted! ***************");
			System.out.println("*************** Dealer Win! ***************");
			bustMenu(player, dealer);
		} else if (bust(dealer)) {
			System.out.println("*************** Dealer busted! ***************");
			System.out.println("*************** You Win! ***************");
			bustMenu(player, dealer);
		}

	}
	
	public void checkWinner(Participants player, Participants dealer) {
		if (player.getHand().getHandValue() > dealer.getHand().getHandValue()) {
			System.out.println("*************** You Win! ***************");
			bustMenu(player, dealer);
		} else if (player.getHand().getHandValue() < dealer.getHand().getHandValue()) {
			System.out.println("*************** Dealer Win! ***************");
			bustMenu(player, dealer);
		} else if (dealer.getHand().getHandValue() == player.getHand().getHandValue()) {
			System.out.println("*************** You tied the dealer! ***************");
			bustMenu(player, dealer);
		}
	}

//	Logic for dealing the dealer cards once player stands
	public void stand(Participants player, Participants dealer) {
		while (dealer.getHand().getHandValue() < 17
				&& dealer.getHand().getHandValue() < player.getHand().getHandValue()) {
			dealer.getHand().addCard(dealer.getHand().deck.dealCard());
		}
	}

//	used for each logic endpoint under stand logic
	public void bustMenu(Participants player, Participants dealer) {
		displayHands(player, dealer);
		System.out.println("Play again?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		int choice = choice();
		switch (choice) {
		case 1:
			game();
			break;
		case 2:
			System.out.println("Thanks for playing!");
			System.exit(0);
		}
	}

//	Determines if Participant has busted
	public boolean bust(Participants participant) {
		if (participant.getHand().getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

//	Deals card to either player or dealer
	public void deal(Participants participant) {
		participant.getHand().addCard(participant.getHand().deck.dealCard());
	}

//	Displays dealer and player hands. If player stands dealers hand will show
	public void displayHands(Participants player, Participants dealer) {
		if (dealer.getHand().getCards().size() > 2 || stand == true) {
			System.out.println("-------------------------------");
			System.out.println("DEALER'S HAND: ");
			dealer.getHand().displayHand();
			System.out.println("-------------------------------");
		} else {
			System.out.println("-------------------------------");
			System.out.println("DEALER'S HAND: ");
			System.out.println("face down");
			System.out.println(dealer.getHand().getCards().get(1).toString());
			System.out.println("-------------------------------");
		}
		System.out.println("-------------------------------");
		System.out.println("YOUR HAND: ");
		player.getHand().displayHand();
		System.out.println("-------------------------------");
	}

	public void hitOrStandMenu(Participants player, Participants dealer) {
		System.out.println("1. Hit");
		System.out.println("2. Stand");
	}

//	used throughout program to get user input and clear line for next input
	public int choice() {
		System.out.print("Enter your choice: ");
		int choice = input.nextInt();
		input.nextLine();
		return choice;
	}

}
