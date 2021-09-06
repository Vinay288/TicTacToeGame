package com.bridelabz.tictactoegame;

import java.util.Scanner;

public class TicTacToeMain {
	static Scanner scanner = new Scanner(System.in);
	final static int HEADS=1;
	final static int TAILS=0;
	public static boolean gameOver=false;
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe game");
		char playerKey = selectKey();
		char computerKey=(playerKey=='X')?'O':'X';
		TicTacToeGame game = new TicTacToeGame(playerKey, computerKey);
		int toss = (int) Math.round(Math.random());
			while(!gameOver) {
				game.displayBoard();
			userStart(game);
			game.computerPlay(game);
		game.gamePlayResult();
			}
	}

	public static void userStart(TicTacToeGame game) {
		System.out.println("enter the user move index (1-9) ");
		int userMove=scanner.nextInt();
		if(!game.playerGamePlay(userMove))
			userStart(game);
		return;
		
	}

	public static char selectKey() {
		System.out.println("Player1 choose a letter X or O");
		char playerKey = scanner.next().charAt(0);
		return playerKey;
	}

}
