package com.bridelabz.tictactoegame;

import java.util.Scanner;

public class TicTacToeMain {
	static Scanner scanner = new Scanner(System.in);
	final static int HEADS = 1;
	final static int TAILS = 0;
	public static boolean gameOver = false;

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe game");
		char playerKey = selectKey();
		char computerKey = (playerKey == 'X') ? 'O' : 'X';
		TicTacToeGame game = new TicTacToeGame(playerKey, computerKey);
		gamePlay(game);
	}

	private static void computerStart(TicTacToeGame game) {
		game.board[5] = game.getComputerKey();
		return;
	}

	public static void userStart(TicTacToeGame game) {
		System.out.println("enter the user move index (1-9) ");
		int userMove = scanner.nextInt();
		if (!game.playerGamePlay(userMove))
			userStart(game);
		return;

	}

	public static char selectKey() {
		System.out.println("Player1 choose a letter X or O");
		char playerKey = scanner.next().toUpperCase().charAt(0);
		return playerKey;
	}
	public static void gamePlay(TicTacToeGame game) {
		gameOver=false;
		game.assignInitialvalues();
		int toss = (int) Math.round(Math.random());
		int play = 0;
		if (toss == HEADS) {
			userStart(game);
			play = 1;
		} else {
			computerStart(game);
			play = 0;
		}
		game.displayBoard();
		while (!gameOver) {
			if (play == 0) {
				userStart(game);
				game.displayBoard();
				play = 1;
			} else if (play == 1) {
				game.computerPlay(game);
				game.displayBoard();
				play = 0;
			}
			game.gamePlayResult();
		}
		System.out.println("DO you want to play again?, press y to play n to exit?");
		char userInput=scanner.next().toUpperCase().charAt(0);
		if(userInput=='Y') {
			gamePlay(game);
		}
		else {
			System.out.println("BYE");
			return;
		}
	}

}
