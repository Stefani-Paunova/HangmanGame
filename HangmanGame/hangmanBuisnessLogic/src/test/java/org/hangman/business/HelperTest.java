package org.hangman.business;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hangmanBuisnessLogic.Helper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
class HelperTest {

	Helper helper = new Helper();
	
	@BeforeEach
	public void init() {
		helper.populateInitialWords();
	}

	@Test
	void getRandomWors() {
		String randomWord = helper.getRandom();
		List<String> words = helper.getWords();
		
		assertThat(words, hasItem(randomWord));
		
	}


}
