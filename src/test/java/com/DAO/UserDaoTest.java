package com.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.AbstractAdamingTestRepository;
import com.SpringBootRunner;
import com.entity.User;

@SpringBootTest(classes = SpringBootRunner.class)
public class UserDaoTest extends AbstractAdamingTestRepository {
	
	@Autowired
	private UserDao userDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoTest.class);

 
	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		LOGGER.info("--------------- Testing givenEntityRepository_whenSaving Method ---------------");
		User addedUser = userDao.save(new User(10,"dalii"));
		LOGGER.info("--------------- Utilisateur saved ---------------");
		LOGGER.info("--------------- Searching for Utilisateur ---------------");
		User foundUser = userDao.findById(addedUser.getId());
		LOGGER.info("--------------- Utilisateur found ---------------");
		LOGGER.info("--------------- Verifying Utilisateur  ---------------");
		assertNotNull(foundUser);
		assertEquals(addedUser.getUserName(), foundUser.getUserName());
		LOGGER.info("--------------- Utilisateur verified ---------------");
	
		
	}
	@Override
	public void givenEntityRepository_whenUpdating() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void givenEntityRepository_whenDeleting() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		// TODO Auto-generated method stub
		
	}

}
