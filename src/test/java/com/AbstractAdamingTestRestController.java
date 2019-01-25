package com;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author bjrad: Designed to be implemented in the test classes in the Rest
 *         Controller Layer. You need to implement the @Test annotation for any
 *         method you want to classify as a test. You need to add
 *         the @SpringBootTest annotation with classes parameter for the Spring
 *         Boot entry class
 *         You need to override the subclass constructor and call the super class constructor
 *         
 */
@WebAppConfiguration
@RunWith(SpringRunner.class)
public abstract class AbstractAdamingTestRestController extends AbstractAdamingTest {
	@Autowired
	WebApplicationContext webApplicationContext;
	/**
	 * Used to mock the Web Context
	 */
	protected MockMvc mvc;
	/**
	 * Used for the web service adressing. You need to initiate it in the subclasses constructors
	 */
	protected String uri;

	public AbstractAdamingTestRestController() {
		super();
	}
	
	
	/**
	 * Setting up the Mock MVC with the Web Context
	 */
	@Before
	public final void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockitoAnnotations.initMocks(this);

	}

	/**
	 * Implemented to test the entity's Rest controller GET service to get all the record of the entity. You need add
	 * the @Test Annotation when overriding
	 */
	public abstract void getAllEntityList();

	/**
	 * Implemented to test the entity's Rest controller POST service to add a record of the entity. You need add
	 * the @Test Annotation when overriding
	 */
	public abstract void createEntity();

	/**
	 * Implemented to test the entity's Rest controller PUT service to update a record of the entity. You need add
	 * the @Test Annotation when overriding
	 */
	public abstract void updateEntity();

	/**
	 * Implemented to test the entity's Rest controller DELETE service to delete a record of the entity. You need add
	 * the @Test Annotation when overriding
	 */
	public abstract void deleteEntity();

}
