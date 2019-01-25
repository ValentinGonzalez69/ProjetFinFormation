package com.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.AbstractAdamingTestService;
import com.SpringBootRunner;
import com.DAO.UserDao;
import com.DAO.UserDaoTest;
import com.entity.User;

@SpringBootTest(classes = SpringBootRunner.class)
public class UserServiceTest extends AbstractAdamingTestService {
	@Autowired
	@Mock
	private UserService userServiceToMock;
	@Autowired
	private UserService userService;
	@Mock
	@Autowired
	private UserDao userDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoTest.class);


	
	@Test
	public void givenUsers_getHalfOfNumber() {
		LOGGER.info("--------------- Testing givenUtilisateurs_getHalfOfNumber Method ---------------");
		LOGGER.info("--------------- Constructing Utilisateurs ---------------");
		//userServiceToMock = Mockito.mock(UserService.class);   Use can use this instead of using annotation
		LOGGER.info("--------------- Mocking getAll() methode of IUtilisateurService ---------------");
		Mockito.when(userServiceToMock.getAllUsers()).thenReturn(Arrays.asList(new User(10,"dalii"), new User(1,"dalii"), new User(2,"dalii"), new User(18,"dalii")));
		LOGGER.info("--------------- Method Mocked ---------------");
		LOGGER.info("--------------- Verifying results ---------------");
		assertEquals(2,userService.getUserNbrHalf(userServiceToMock.getAllUsers()));
	}
	@Override
	public void givenEntityService_whenSaving() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void givenEntityService_whenUpdating() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void givenEntityService_whenDeleting() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void givenEntityService_whenRetrievingAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void givenEntityService_whenRetrievingOneById() {
		// TODO Auto-generated method stub
		
	}

}
