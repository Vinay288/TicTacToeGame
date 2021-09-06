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
		if (board[userMove] == ' ') {
			board[userMove] = playerKey;
			System.out.println("ff");
			return true;
		}
		
		System.out.println("this box is already filled select different box");
		return false;
	}

	public void computerPlay(TicTacToeGame game) {

	}

	public void gamePlayResult() {
		if (isWin(playerKey)) {
			System.out.println("player1 has won the game");
		} else if (isWin(computerKey)) {
			System.out.println("computer has wont the game");
		} else {
			System.out.println("change the turn");
		}

	}

	private boolean isWin(char key) {
		System.out.println("d");
		if (board[1] == key && board[5] == key && board[9] == key)
			return true;
		if (board[3] == key && board[5] == key && board[7] == key)
			return true;
		for (int i = 1; i < 10;) {
			if (board[i] != key) {
				i += 3;
				break;
			}
			if (i % 3 == 0)
				return true;
			i+=1;
		}
		for (int i = 1; i < 4; i++) {
			if (board[i] == key && board[i + 3] == key && board[i + 6] == key)
				return true;
		}
		return false;
	}
}
