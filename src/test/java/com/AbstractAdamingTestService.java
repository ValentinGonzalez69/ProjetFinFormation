package com;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

/**
 * @author bjrad: Designed to be implemented in the test classes in the
 *         Service\Business Logic Layer. You need to implement the @Test
 *         annotation for any method you want to classify as a test. You need to
 *         add the @SpringBootTest annotation with classes parameter for the
 *         Spring Boot entry class
 */
public abstract class AbstractAdamingTestService extends AbstractAdamingTest {
	
	/**
	 * Preparing the class to accept the use of the @Mock annotation
	 */
	@Before
	  public final void setUp() {
	    MockitoAnnotations.initMocks(this);
	  }
	
	/**
	 * Implemented to test the entity's service saving operation. You need add
	 * the @Test Annotation when overriding
	 */
	public abstract void givenEntityService_whenSaving();

	/**
	 * Implemented to test the entity's service updating operation. You need add
	 * the @Test Annotation when overriding
	 */
	public abstract void givenEntityService_whenUpdating();

	/**
	 * Implemented to test the entity's service deleting operation. You need add
	 * the @Test Annotation when overriding
	 */
	public abstract void givenEntityService_whenDeleting();

	/**
	 * Implemented to test the entity's service retrieving all operation. You need add
	 * the @Test Annotation when overriding
	 */
	public abstract void givenEntityService_whenRetrievingAll();

	/**
	 * Implemented to test the entity's service retrieving by ID operation. You need add
	 * the @Test Annotation when overriding
	 */
	public abstract void givenEntityService_whenRetrievingOneById();

}
