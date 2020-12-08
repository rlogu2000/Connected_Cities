/**
 * 
 */
package com.connected.cities.utility;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author Loganathan.
 *
 */
public class FileLoaderTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	/**
	 * Test method for {@link com.connected.cities.utility.FileLoader#checkFile(java.io.File)}.
	 */
	@Test
	public final void testCheckFileIsEmpty() {
		try {
			FileLoader fileLoader = new FileLoader();
			Resource routes = new ClassPathResource("cities_empty_file.txt");
			fileLoader.checkFile(routes.getFile());
		}catch(Exception ex) {
			final String msg = ErrorMessages.FILE_IS_EMPTY.toString();
		    assertEquals(msg, ex.getMessage());
		}
	}
	@Test
	public final void testCheckFileIsNotFound() {
		try {
			FileLoader fileLoader = new FileLoader();
			Resource routes = new ClassPathResource("cities1.txt");
			fileLoader.checkFile(routes.getFile());
		}catch(Exception ex) {
			final String msg = "class path resource [cities1.txt] cannot be resolved to URL because it does not exist";
		    assertEquals(msg, ex.getMessage());
		}
	}
	



}
