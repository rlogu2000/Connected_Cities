package com.connected.cities.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.connected.cities.services.IRouteService;
import com.connected.cities.utility.CityUtility;
import com.connected.cities.utility.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@Api(value="findRoutes", description="The REST Api will be used to find whether connection exist between two cities")
public class ConnectedCitiesController {
	
	private  final Logger log = LoggerFactory.getLogger(this.getClass());
    
	@Autowired
	IRouteService service;
  
    @RequestMapping(value = "/connected", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Find Connection Exist between cities", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the Result"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public String findConnection(@RequestParam(name = "origin") String origin, @RequestParam(name = "destination") String destination) {
    	
    	if(origin==null ||origin.trim().length()==0 || destination==null ||  destination.trim().length()==0) {
    		log.info("Getting Origin and/or Destination as Null");
    		return new Result("No").toString();
    	}
    	if(CityUtility.isBothCitySame(origin, destination)) {
    		log.info("Ahha ,The question is not correct");
    		return new Result("No").toString();
    	}
    	
    	String result=service.findConnection(origin.trim().toLowerCase(),destination.trim().toLowerCase());
    	log.info(" The Result "+result);
    	return new Result(result).toString();
      
    }
}