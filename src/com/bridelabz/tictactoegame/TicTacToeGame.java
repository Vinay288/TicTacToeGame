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

	public void displayBoard() {
		System.out.println("board values");
		for (int i = 1; i < 10; i++) {
			System.out.print(board[i] + "|");
			if (i % 3 == 0) {
				System.out.print("\n------\n");
			}
		}
	}

	public boolean playerGamePlay(int userMove) {
		if(board[userMove]==' ') {
			board[userMove]=playerKey;
			return true;
		}
		else {
			System.out.println("this box is already filled select different box");
		}
		return false;
	}

	public void computerPlay(TicTacToeGame game) {
	
		
	}
}
