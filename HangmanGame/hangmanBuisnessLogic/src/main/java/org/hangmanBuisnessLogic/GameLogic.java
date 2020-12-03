package org.hangmanBuisnessLogic;

public interface GameLogic {
	
	
	public String generateDash(String originalWord);
	
	public Game setLetter(char l, int gameId);
	
	public boolean checkForWinning(int gameId);
	
	public boolean isContain(char l, String originalWord);
	
	public String printLives(int lives);
	
	

}

