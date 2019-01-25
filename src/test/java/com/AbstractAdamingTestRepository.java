package com;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author bjrad: Designed to be implemented in the test classes in the Data
 *         Access Layer You need to implement the @Test annotation for any
 *         method you want to classify as a test.
 *         You need to add the @SpringBootTest annotation with classes parameter
 *         for the Spring Boot entry class
 */
public abstract class AbstractAdamingTestRepository extends AbstractAdamingTest {

	/**
	 * Implemented to test the entity's repository saving operation. You need add
	 * the @Test Annotation when overriding
	 */
	public abstract void givenEntityRepository_whenSaving();

	/**
	 * Implemented to test the entity's repository updating operation. You need add
	 * the @Test Annotation when overriding
	 */
	public abstract void givenEntityRepository_whenUpdating();

	/**
	 * Implemented to test the entity's repository deleting operation. You need add
	 * the @Test Annotation when overriding
	 */
	public abstract void givenEntityRepository_whenDeleting();

	/**
	 * Implemented to test the entity's repository retrieving all operation. You need add
	 * the @Test Annotation when overriding
	 */
	public abstract void givenEntityRepository_whenRetrievingAll();

	/**
	 * Implemented to test the entity's repository retrieving by ID operation. You need add
	 * the @Test Annotation when overriding
	 */
	public abstract void givenEntityRepository_whenRetrievingOneById();

}
