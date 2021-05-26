package com.connected.cities;

import com.connected.cities.services.IRouteService;
import com.connected.cities.services.RouteService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Loganathan.
 */
@RunWith(SpringRunner.class)
public class RouteServiceTest {


	@Autowired
	private IRouteService routeService;

    /**
     *
     */
    @Before
	public void setUp() {
	}

    /**
     *
     */
    @Test
	public void whenValidOriginAndDestination_thenResultShouldBeReturned() {
		String result = routeService.findConnection("NewYork".toLowerCase(), "Raleigh".toLowerCase());
		assertThat(result).isEqualTo("Yes");
	}

    /**
     *
     */
    @Test
	public void losAngels_to_London_Connection_Testing() {
		String result = routeService.findConnection("LosAngels".toLowerCase(), "London".toLowerCase());
		assertThat(result).isEqualTo("Yes");
	}

    /**
     *
     */
    @Test
	public void pitsburg_to_Detroit_Connection_Testing() {
		String result = routeService.findConnection("Pitsburg".toLowerCase(), "Detroit".toLowerCase());
		assertThat(result).isEqualTo("No");
	}

    /**
     *
     */
    @Test
	public void passing_Origin_Null_Value_Test() {
		String result = routeService.findConnection(null, "Raleigh".toLowerCase());
		assertThat(result).isEqualTo("No");
	}

    /**
     *
     */
    @Test
	public void passing_Destination_Null_Value_Test() {
		String result = routeService.findConnection("LosAngels".toLowerCase(), null);
		assertThat(result).isEqualTo("No");
	}

    /**
     *
     */
    @Test
	public void both_Null_Value_Test() {
		String result = routeService.findConnection(null, null);
		assertThat(result).isEqualTo("No");
	}
        @TestConfiguration
        static class RouteServiceImplTestConfiguration {
            @Bean
            public IRouteService routeService() {
                return new RouteService();
            }
        }
}
