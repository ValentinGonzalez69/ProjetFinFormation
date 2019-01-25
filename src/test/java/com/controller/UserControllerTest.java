package com.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.AbstractAdamingTestRestController;
import com.SpringBootRunner;
import com.DAO.UserDaoTest;
import com.entity.User;
import com.service.UserService;

@SpringBootTest(classes = SpringBootRunner.class)
public class UserControllerTest extends AbstractAdamingTestRestController {

	@Autowired
	private UserService userService;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoTest.class);

	public UserControllerTest() {
		super();
		this.uri = "/user";

	}

	@Test
	@Override
	public void getAllEntityList() {
		MvcResult mvcResult;
		try {
			LOGGER.info("--------------- Testing getAllEntity Method ---------------");

			LOGGER.info("--------------- Constructing Utilisateur ---------------");
			LOGGER.info("--------------- Saving Utilisateur ---------------");
			userService.addUser(new User(2, "dalii"));
			LOGGER.info("--------------- Mocking Context Webservice ---------------");
			mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/all").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();
			LOGGER.info("--------------- Getting HTTP Status ---------------");
			int status = mvcResult.getResponse().getStatus();
			LOGGER.info("--------------- Verrifying HTTP Status ---------------");
			assertEquals(200, status);
			LOGGER.info("--------------- Getting HTTP Response ---------------");
			String content = mvcResult.getResponse().getContentAsString();
			LOGGER.info("--------------- Deserializing JSON Response ---------------");
			User[] userList = this.mapFromJson(content, User[].class);
			assertTrue(userList.length > 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	@Override
	public void createEntity() {
		LOGGER.info("--------------- Testing createEntity Method ---------------");
		LOGGER.info("--------------- Constructing Utilisateur ---------------");
		User user = new User(50, "sala7");

		MvcResult mvcResult;
		try {
			LOGGER.info("--------------- Serializing Utilisateur Object ---------------");
			String inputJson = this.mapToJson(user);
			LOGGER.info("--------------- Mocking Context Webservice and invoking the webservice ---------------");
			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/adduser")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			LOGGER.info("--------------- Getting HTTP Status ---------------");
			int status = mvcResult.getResponse().getStatus();
			LOGGER.info("--------------- Verrifying HTTP Status ---------------");
			assertEquals(200, status);
			LOGGER.info("--------------- Searching for Utilisateur ---------------");
			User userFound = userService.getUserById(new Long(50));
			LOGGER.info("--------------- Verifying Utilisateur ---------------");
			assertEquals(userFound.getUserName(), user.getUserName());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	@Override
	public void updateEntity() {
		try {
			LOGGER.info("--------------- Testing updateEntity Method ---------------");

			LOGGER.info("--------------- Constructing Utilisateur ---------------");
			User oldUser = new User(2, "Lemon");
			LOGGER.info("---------------  Saving Utilisateur ---------------");
			userService.addUser(oldUser);
			LOGGER.info("--------------- Modifying Utilisateur ---------------");

			User newUser = new User(2, "Lemonade");
			LOGGER.info("--------------- Serializing Utilisateur Object ---------------");

			String inputJson = this.mapToJson(newUser);
			LOGGER.info("--------------- Mocking Context Webservice and invoking the webservice ---------------");

			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/2")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			LOGGER.info("--------------- Getting HTTP Status ---------------");

			int status = mvcResult.getResponse().getStatus();
			LOGGER.info("--------------- Verrifying HTTP Status ---------------");

			assertEquals(200, status);
			LOGGER.info("--------------- Searching for Utilisateur ---------------");

			User userFound = userService.getUserById(new Long(2));
			LOGGER.info("--------------- Verifying Utilisateur ---------------");

			assertEquals(userFound.getUserName(), newUser.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Override
	public void deleteEntity() {
		LOGGER.info("--------------- Testing deleteEntity Method ---------------");

		try {
			LOGGER.info("--------------- Constructing Utilisateur ---------------");
			LOGGER.info("---------------  Saving Utilisateur ---------------");
			userService.addUser(new User(2, "Lemon"));
			LOGGER.info("--------------- Mocking Context Webservice and invoking the webservice ---------------");

			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri + "/2")).andReturn();
			LOGGER.info("--------------- Getting HTTP Status ---------------");

			int status = mvcResult.getResponse().getStatus();
			LOGGER.info("--------------- Verrifying HTTP Status ---------------");

			assertEquals(200, status);
			LOGGER.info("--------------- Searching for Utilisateur ---------------");

			User userFound = userService.getUserById(new Long(2));
			LOGGER.info("--------------- Verifying Utilisateur ---------------");

			assertEquals(userFound, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
