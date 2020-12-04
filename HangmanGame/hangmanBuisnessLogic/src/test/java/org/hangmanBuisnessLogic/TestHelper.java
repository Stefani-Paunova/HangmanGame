package org.hangmanBuisnessLogic;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hangmanBuisnessLogic.Helper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestHelper {
	
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
