package com.connected.cities;

import com.connected.cities.utility.FileLoaderTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 *
 * @author Loganathan.
 */
@RunWith(Suite.class)
@SuiteClasses({GraphBuilderFactoryTest.class, GraphTest.class, RouteServiceTest.class,
		UndirectedGraphBuilderTest.class, FileLoaderTest.class })
public class AllTests {

   

}
