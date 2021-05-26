package com.connected.cities;

import com.connected.cities.application.ConnectedCitiesApplication;
import com.connected.cities.services.IRouteService;
import java.util.logging.Logger;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.mockito.ArgumentMatchers.eq;

import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author THANISSHKA
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = ConnectedCitiesApplication.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class ConnectedCitiesControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private IRouteService routeService;

    /**
     *
     * @throws Exception
     */
    @Test
	public void isConnected_Return_No() throws Exception {
		mvc.perform(get("/connected?origin=NewYork&destination=NewYork")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$", is("No")));
	}

    /**
     *
     * @throws Exception
     */
    @Test
	public void isConnected_Return_Yes() throws Exception {
		given(routeService.findConnection(eq("NewYork".toLowerCase()),
				startsWith("LosAngels".toLowerCase()))).willReturn("Yes");
		mvc.perform(get("/connected?origin=NewYork&destination=LosAngels")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$", is("Yes")));
		reset(routeService);
	}

    /**
     *
     * @throws Exception
     */
    @Test
	public void isConnected_Return_No_For_Pitsburg_to_Dhuram() throws Exception {
		given(routeService.findConnection(eq("Pitsburg".toLowerCase()),
				eq("Dhuram".toLowerCase()))).willReturn("No");
		mvc.perform(get("/connected?origin=Pitsburg&destination=Dhuram")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$", is("No")));
		reset(routeService);
	}

    /**
     *
     * @throws Exception
     */
    @Test
	public void passing_null_origin_and_null_destination() throws Exception {
		mvc.perform(get("/connected?origin=&destination=")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$", is("No")));
	}

    /**
     *
     * @throws Exception
     */
    @Test
	public void passing_null_origin() throws Exception {
		mvc.perform(get("/connected?origin=LosAngels&destination=")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$", is("No")));
	}

    /**
     *
     * @throws Exception
     */
    @Test
	public void passing_null_destination() throws Exception {
		mvc.perform(get("/connected?origin=&destination=LosAngels")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$", is("No")));
	}
    private static final Logger LOG = Logger.getLogger(ConnectedCitiesControllerTest.class.getName());
}
