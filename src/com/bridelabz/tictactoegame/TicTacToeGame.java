package com.bridelabz.tictactoegame;

public class TicTacToeGame {
	char[] ticTacToe;
	public TicTacToeGame() {
		ticTacToe=new char[11];
		assignInitialvalues();
	}
	private void assignInitialvalues() {
		for(int i=1;i<=10;i++) {
			ticTacToe[i]=0;
		}
	}
	
}
