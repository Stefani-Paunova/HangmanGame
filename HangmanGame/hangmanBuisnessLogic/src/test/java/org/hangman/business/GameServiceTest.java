package org.hangman.business;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.hangmanBuisnessLogic.Game;
import org.hangmanBuisnessLogic.GameService;
import org.hangmanBuisnessLogic.Helper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class GameServiceTest {
	
	@InjectMocks
	GameService gameService =new GameService();
	
	@Mock
	Helper helper;

	@Test
	void createGame() {
		Mockito.when(helper.getRandom()).thenReturn("stefani");
		Game game = gameService.createGame();
		assertThat(gameService.games, hasItem(game));
	}
	
	
	//generateDash(String originalWord)
	@Test
	void checkCorrectDashGenerator() {
		String dashWord = gameService.generateDash("stefani");
	   assertEquals("s _ _ _ _ _ i", (dashWord));
	}

	@Test
	void checkInCorrectDashGenerator() {
		String dashWord = gameService.generateDash("stefani");
	   assertNotEquals("s _ _ _ _ i", (dashWord));
	}
	
	
	//isContain(char l, String originalWord)
	@Test
	void isContain() {
		char l = 's';
		String name = "Stefani";
		boolean check = gameService.isContain(l, name);
		assertEquals(true, check);
	}
	
	@Test
	void isNotContain() {
		char l = 'k';
		String name = "Stefani";
		boolean check = gameService.isContain(l, name);
		assertNotEquals(true, check);
	}
	
	
	
	//getGameById(int gameId)
	@Test
	void getGameById() {
		Game game = new Game();
		game.setId(1);
		game.setOriginalWord("stefani");
		game.setGuessWord("s _ _ _ _ i");
		game.setLives(7);
		gameService.games.add(game);
		
		assertThat(gameService.games, hasItem(game));
	}
	
	
	//setLetter(char l, int gameId)
	@Test
	void setLetter() {
		Game game = new Game();
		game.setId(1);
		game.setOriginalWord("maven");
		game.setGuessWord("m _ _ _ n");
		game.setLives(7);
		game.setLetters(new ArrayList<Character>());
		gameService.games.add(game);
		
		char l = 'a';
		
		Game g = gameService.setLetter(l, 1);
		 
		assertEquals(g.getGuessWord(), "ma _  _ n");
	}
	
	
	@Test
	void setLetterCheckLives() {
		Game game = new Game();
		game.setId(1);
		game.setOriginalWord("maven");
		game.setGuessWord("m _ _ _ n");
		game.setLives(7);
		game.setLetters(new ArrayList<Character>());
		gameService.games.add(game);
		
		char l = 'b';
		
		Game g = gameService.setLetter(l, 1);
		 
		assertEquals(g.getLives(), 6);
	}
	
	
	
	//checkForWinning(int gameId)
	@Test
	void checkForWinnig() {
		Game game = new Game();
		game.setId(1);
		game.setOriginalWord("maven");
		game.setGuessWord("maven");
		game.setLives(7);
		game.setLetters(new ArrayList<Character>());
		gameService.games.add(game);
		
		boolean checkForWin = gameService.checkForWinning(game.getId());
		assertEquals(true, checkForWin);
	}
	

	@Test
	void checkForNotWinning() {
		Game game = new Game();
		game.setId(1);
		game.setOriginalWord("maven");
		game.setGuessWord("mav _ n");
		game.setLives(7);
		game.setLetters(new ArrayList<Character>());
		gameService.games.add(game);
		
		boolean checkForWin = gameService.checkForWinning(game.getId());
		assertNotEquals(true, checkForWin);
	}
	
	
	
	//printLives(int gameId)
	@Test
	void printLives(){
		Game game = new Game();
		game.setId(1);
		game.setOriginalWord("maven");
		game.setGuessWord("mav _ n");
		game.setLives(7);
		game.setLetters(new ArrayList<Character>());
		gameService.games.add(game);
		
		String lives = gameService.printLives(1);
		
		assertEquals(lives, "\u2764" + " " +"\u2764" + " "+"\u2764" + " "+"\u2764" + " "+"\u2764" + " "+"\u2764" + " "+"\u2764" + " ");
	}
	
}
