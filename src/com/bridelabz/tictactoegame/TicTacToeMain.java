package com.bridelabz.tictactoegame;

import java.util.Scanner;

public class TicTacToeMain {

	public static void main(String[] args) {
		char computerKey;
		System.out.println("Welcome to Tic Tac Toe game");
		char playerKey = selectKey();
		if (playerKey == 'X') {
			computerKey = 'O';
		} else
			computerKey = 'X';
		TicTacToeGame game = new TicTacToeGame(playerKey, computerKey);

	}

	public static char selectKey() {
		System.out.println("Player1 choose a letter X or O");
		Scanner scanner = new Scanner(System.in);
		char playerKey = scanner.next().charAt(0);
		return playerKey;
	}

}
