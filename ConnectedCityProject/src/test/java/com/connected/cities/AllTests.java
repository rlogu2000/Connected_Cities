package com.connected.cities;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.connected.cities.utility.FileLoaderTest;


@RunWith(Suite.class)
@SuiteClasses({GraphBuilderFactoryTest.class, GraphTest.class,
		RouteServiceTest.class, UndirectedGraphBuilderTest.class,FileLoaderTest.class })
public class AllTests {

}
