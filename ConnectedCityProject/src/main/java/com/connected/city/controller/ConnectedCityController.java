package com.connected.city.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.connected.city.services.IRouteService;
import com.connected.city.utility.CityUtility;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@Api(value="findRoutes", description="The REST Api will be used to find whether connection exist between two cities")
public class ConnectedCityController {
    
	@Autowired
	IRouteService service;
    @RequestMapping("/connected")
    @ApiOperation(value = "Find Connection Exist between cities", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the Result"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public String findConnection(@RequestParam(name = "origin") String origin, @RequestParam(name = "destination") String destination) {
    	
    	if(CityUtility.checkBothSameCity(origin, destination)) {
    		System.out.println("StupidQuestion");
    		return "No";
    	}
    	
    	return service.checkConnection(origin,destination);
      
    }
}