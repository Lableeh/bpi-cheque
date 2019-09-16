package com.bpi.enterpriseapi.controller;

import org.springframework.http.ResponseEntity;

import com.bpi.enterpriseapi.dto.api.CheckbookRequest;
import com.bpi.framework.model.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
public interface ReorderCheckbookApi {

	 @ApiOperation(value="", notes = "Create record for number of checkbooks ordered", tags = {"Reorder Checkbook"} )
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Success", response = Response.class),
	            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
	            @ApiResponse(code = 401, message = "Unauthorized", response = Response.class),
	            @ApiResponse(code = 403, message = "Forbidden Access", response = Response.class),
	            @ApiResponse(code = 404, message = "Resource Not Found", response = Response.class),
	            @ApiResponse(code = 500, message = "Internal server error occurred", response = Response.class)})
	    ResponseEntity<Response<Void>> reorder(String apiKey, String apiSecret, String requestUID, String resourceOwnerId, String deviceHash, CheckbookRequest checkbookRequest);

}
