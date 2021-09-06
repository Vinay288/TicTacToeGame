package com.bridelabz.tictactoegame;

public class TicTacToeGame {
	char[] board;

	public TicTacToeGame() {
		board = new char[10];
		assignInitialvalues();
	}

	private void assignInitialvalues() {
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
	}

}
