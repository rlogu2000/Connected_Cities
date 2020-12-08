package com.connected.cities;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.connected.cities.application.ConnectedCitiesApplication;
import com.connected.cities.services.IRouteService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ConnectedCitiesApplication.class)
@AutoConfigureMockMvc 
@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
public class ConnectedCitiesControllerTest  {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
    private IRouteService routeService;
		
    @Test
    public void isConnected_Return_No()throws Exception {
        mvc.perform(get("/connected?origin=NewYork&destination=NewYork"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$", is("No")));
    }
    @Test
    public void isConnected_Return_Yes()throws Exception {
    	given(routeService.findConnection(Mockito.eq("NewYork".toLowerCase()),Mockito.startsWith("LosAngels".toLowerCase()))).willReturn("Yes");
        mvc.perform(get("/connected?origin=NewYork&destination=LosAngels"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$", is("Yes")));
         reset(routeService);
    }
    @Test
    public void isConnected_Return_No_For_Pitsburg_to_Dhuram()throws Exception {
    	given(routeService.findConnection(Mockito.eq("Pitsburg".toLowerCase()),Mockito.eq("Dhuram".toLowerCase()))).willReturn("No");
        mvc.perform(get("/connected?origin=Pitsburg&destination=Dhuram"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$", is("No")));
         reset(routeService);
    }
    @Test
    public void passing_null_origin_and_null_destination()throws Exception {
        mvc.perform(get("/connected?origin=&destination="))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$", is("No")));
     }
    @Test
    public void passing_null_origin()throws Exception {
        mvc.perform(get("/connected?origin=LosAngels&destination="))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$", is("No")));
     }
    @Test
    public void passing_null_destination()throws Exception {
        mvc.perform(get("/connected?origin=&destination=LosAngels"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$", is("No")));
     }
}
