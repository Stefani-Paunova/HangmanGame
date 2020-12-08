package org.hangmanBuisnessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GameService implements GameLogic{
	
	@Autowired
	private Helper helper;
	
/*	public GameService(Helper helper) {
		this.helper = helper;
	}*/
	public GameService() {
		
	}
	
	public static final int STARTING_LIVES = 7;
	
	public List<Game> games = new ArrayList<Game>();
	
	
	
	public Game createGame() {
		Game game = new Game();
		Random r = new Random();
		game.setId(r.nextInt());
		game.setOriginalWord(helper.getRandom());
		game.setGuessWord(generateDash(game.getOriginalWord()));		
		game.setLives(STARTING_LIVES);
		
		List<Character> letters = new ArrayList<Character>();
		game.setLetters(letters);
		
		games.add(game);
		
		return game;
	}
	
	public Game getGameById(int gameId) {
		
		Optional <Game> game = games.stream().filter(g-> g.getId() == gameId).findFirst();
		
		return game.get();
	}
	

	@Override
	public String generateDash(String originalWord) {

		StringBuilder guess = new StringBuilder();
		
		int lenght = originalWord.length();
		
		char firstL = originalWord.charAt(0);
		char lastL = originalWord.charAt(lenght - 1);
		
		guess.append(firstL);
		guess.append(" ");
		
		for(int i =0; i < lenght-2; i++)
		{
			guess.append("_ ");
		}
		
		guess.append(lastL);
		
		return guess.toString();
				
		
	}

	@Override
	public boolean isContain(char l, String originalWord) {
		
		boolean isContain = false;
		for (int i = 0; i < originalWord.length(); i++) {
            if (originalWord.toLowerCase().charAt(i) == l) {
                isContain = true;
            }
            
            
        }
		
		return isContain;
	}

	


	@Override
	public Game setLetter(char l, int gameId) {

		Game game = getGameById(gameId);
		String originalWord = game.getOriginalWord();
		String guessWord = game.getGuessWord();
		List<Character> letters = game.getLetters();
		
		String chars = null;
		chars = guessWord.replaceAll("[\\s\\-()]", "");
		StringBuilder sb = new StringBuilder();
		
		if(isContain(l, originalWord)) {
			 for ( int i = 0; i < originalWord.length() ; i++){
		            if(originalWord.toLowerCase().charAt(i) == l){
		            	chars = chars.substring(0, i) + l + chars.substring(i + 1);
		            	
		            }
		        }
			 game.setGuessWord(chars);
			 if(letters.contains(l) == false) {
				 letters.add(l);
			 }
			
		}
		
		if(letters.contains(l) == false){
			
			game.setLives(game.getLives()-1);
			letters.add(l);
			
		}
		
		if(!chars.equals(originalWord)) {	 
			 for(int k = 0; k < chars.length(); k++ ) {
				 
				 char r = chars.charAt(k);
				 if(r == '_') {
					 sb.append(" _ ");
				 }
				 else {
					 sb.append(r);
				 }
				 game.setGuessWord(sb.toString());
			
		 }
		
		}
		
		game.setLetters(letters);
	
		 
	        return game;
	}
	
	
	@Override
	public boolean checkForWinning(int gameId) {
		
	
		
		Game game = getGameById(gameId);
		String originalWord = game.getOriginalWord();
		String guessWord = game.getGuessWord();
		int lives = game.getLives();
		
		if(originalWord.equals(guessWord) && lives>-1) {
			return true;
		}
		
		return false;
	}

	@Override
	public String printLives(int gameId) {
		
		Game game = getGameById(gameId);
		int lives = game.getLives();
		
		StringBuilder live = new StringBuilder();
		
		
		
		for(int i = 0; i < lives; i++) {
			live.append("\u2764" + " ");
		}
		
		return live.toString();
	}

	
	
	

	

}