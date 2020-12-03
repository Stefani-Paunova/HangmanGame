package org.hangmanBuisnessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public  class Helper  {
	
	private  List<String> words = new ArrayList<String>();
	
	@PostConstruct
	public void populateInitialWords() {
		getWords().add("street");
		getWords().add("maven");
		getWords().add("spring");
		getWords().add("developer");
		getWords().add("success");
	}
	
	public String getRandom() {
		Random r = new Random();
		
		return words.get(r.nextInt(words.size()));
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

}