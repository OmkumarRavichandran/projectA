package com.chainsys.springproject.beans;

public class ScoreBoard {

	public int targetScore;
	private ScoreBoard() {
		System.out.println("ScoreBoard Object Created");
	}
	private ScoreBoard (int runs) {
		targetScore=runs;
		System.out.println("Scoreboard obj is created" +runs);
	}
	// Factory method - The methods are static here
	
	public static ScoreBoard createObject() {
		return new ScoreBoard(240);
	}
	public static ScoreBoard createObject(int runs) {
		return new ScoreBoard(runs);
	}
}
