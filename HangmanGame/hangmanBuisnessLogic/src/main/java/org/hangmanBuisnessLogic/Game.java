package org.hangmanBuisnessLogic;

import java.util.List;

public class Game {
	
	private int id;
	private String originalWord;
	private int lives;
	private String guessWord;
	private List<Character> letters;
	
	
	
	public List<Character> getLetters() {
		return letters;
	}
	public void setLetters(List<Character> letters) {
		this.letters = letters;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOriginalWord() {
		return originalWord;
	}
	public void setOriginalWord(String originalWord) {
		this.originalWord = originalWord;
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
	public String getGuessWord() {
		return guessWord;
	}
	public void setGuessWord(String guessWord) {
		this.guessWord = guessWord;
	}
	
	
}