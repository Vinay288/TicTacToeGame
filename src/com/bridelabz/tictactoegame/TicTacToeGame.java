package com.bridelabz.tictactoegame;

public class TicTacToeGame {
	char[] board;
	private char playerKey;
	private char computerKey;

	public TicTacToeGame(char playerKey, char computerKey) {
		this.playerKey = playerKey;
		this.computerKey = computerKey;
		board = new char[10];
		assignInitialvalues();
	}

	private void assignInitialvalues() {
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
	}

}
