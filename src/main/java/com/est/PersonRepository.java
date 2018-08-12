package com.est;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
/**
 * @author estevam
 */
@Repository 
public class PersonRepository {
	
	final static Logger log = LoggerFactory.getLogger(PersonRepository.class);

	/**
	 * Person is random generated 
	 * @return List<Person>
	 */
	public List<Person> getListPerson(){
		List<Person> list = new ArrayList<Person>();
		list.forEach((p) ->{
			log.info("Generating person with id: {}", p.getId());
			list.add(generator());	
		});
		return list;
	}

	private Person generator() {
		return new Person(getRandomInt(10000), getRandonString(5), getRandonString(10), getRandonString(5));
	}
	
	private int getRandomInt(int limit) {
		return new Random().nextInt(limit);
	}
	
	/**
	 * String generator using apache commons lang3 
	 * @param length
	 * @return
	 */
	private String getRandonString(int length) {
	   return RandomStringUtils.random(length, true, false);// length, isLetters, isNumbers
	}
	
}
