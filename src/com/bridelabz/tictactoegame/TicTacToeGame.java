package com.bridelabz.tictactoegame;

import java.util.Arrays;

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

	public char getComputerKey() {
		return this.computerKey;
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
		if (getFreePositions() == null) {
			TicTacToeMain.gameOver = true;
			System.out.println("game is a tie");
			return true;
		}
		if (board[userMove] == ' ') {
			board[userMove] = playerKey;
			if (isWin(playerKey)) {
				TicTacToeMain.gameOver = true;
				System.out.println("you have won the game ,congratulations!!!!");
			}
			
			return true;
		}

		System.out.println("this box is already filled select different box");
		return false;
	}

	public void computerPlay(TicTacToeGame game) {
		System.out.println("Computer's turn");
		int[] freePositons = getFreePositions();
		if (getFreePositions() == null) {
			TicTacToeMain.gameOver = true;
			System.out.println("game is a tie");
			return;
		}
		for (int i = 1; i < 10; i++) {
			if (freePositons[i] == 0) {
				board[i] = computerKey;
				if (gamePlayResult() == 2) {
					TicTacToeMain.gameOver = true;
					System.out.println("computer has won the game");
					return;
				}
				board[i] = ' ';
			}
		}
		for (int i = 1; i < 10; i++) {
			if (freePositons[i] == 0) {
				board[i] = playerKey;
				if (gamePlayResult() == 1) {
					board[i] = computerKey;
					return;
				}
				board[i] = ' ';
			}
		}
		for (int i = 1; i < 10; i++) {
			if (freePositons[i] == 0 && (i == 1 || i == 3 || i == 7 || i == 9)) {
				board[i] = computerKey;
				return;
			}
		}
		if (board[5] == 0) {
			board[5] = computerKey;
			return;
		}
		for (int i = 1; i < 10; i++) {

			if (freePositons[i] == 0) {
				board[i] = computerKey;
				return;
			}
		}

	}

	public int gamePlayResult() {
		if (isWin(playerKey)) {
			return 1;
		} else if (isWin(computerKey)) {
			return 2;
		} else if (getFreePositions() == null) {
			System.out.println("game is tie");
			TicTacToeMain.gameOver = true;
			return 0;
		}
		return -1;
	}

	private boolean isWin(char key) {
		if (board[1] == key && board[5] == key && board[9] == key)
			return true;
		if (board[3] == key && board[5] == key && board[7] == key)
			return true;
		for (int i = 1; i < 10;) {
			if (board[i] != key) {
				if (i % 3 == 0) {
					i = i - 2;
				} else if (i % 3 == 2) {
					i = i - 1;
				}
				i += 3;
				continue;
			}
			if (i % 3 == 0)
				return true;
			i += 1;
		}
		for (int i = 1; i < 4; i++) {
			if (board[i] == key && board[i + 3] == key && board[i + 6] == key)
				return true;
		}
		return false;
	}

	public int[] getFreePositions() {
		int[] freePositions = new int[10];
		boolean full = true;
		Arrays.fill(freePositions, 1);
		freePositions[0] = -1;
		for (int i = 1; i < 10; i++) {
			if (board[i] == ' ') {
				full = false;
				freePositions[i] = 0;
			}
		}
		if (full)
			return null;
		return freePositions;
	}
}
