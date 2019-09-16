package com.bpi.enterpriseapi.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


import com.bpi.enterpriseapi.dto.api.CheckbookRequest;
import com.bpi.enterpriseapi.service.ReorderCheckbookService;
import com.bpi.framework.model.Response;
import com.bpi.framework.model.helper.GenericRequestHeader;
import com.bpi.framework.model.helper.ResponseConverter;

import io.swagger.annotations.ApiParam;
//import com.bpi.api.common.framework.interceptor.annotation.EnableAccessPolicies;

//@EnableAccessPolicies
@Controller
@RequestMapping("/v1/cheque")
public class ReorderCheckbookApiController implements ReorderCheckbookApi{

	@Autowired
    private ReorderCheckbookService reorderCheckbookService;
	
	 @PostMapping("/retail/debitCredit")
	    @Override
	    public ResponseEntity<Response<Void>> reorder(
	            @ApiParam(value = "The apiKey used to authenticate access", required = true) @RequestHeader String apiKey,
	            @ApiParam(value = "The apiSecret used to authenticate access", required = true) @RequestHeader String apiSecret,
	            @ApiParam(value = "Request Unique ID", required = true) @RequestHeader String requestUID,
	            @ApiParam(value = "Resource Owner ID - Online or Mobile", required = true) @RequestHeader String resourceOwnerId,
	            @ApiParam(value = "The device hash", required = false) @RequestHeader(required = false) String deviceHash,
	            @ApiParam(value = "Reorder Checkbook Request", required = true) @Valid @RequestBody CheckbookRequest checkbookRequest) {
	        return ResponseConverter.convert(reorderCheckbookService.reorder(checkbookRequest,
	                GenericRequestHeader.builder()
	                        .resourceOwnerId(resourceOwnerId)
	                        .deviceHash(deviceHash)
	                        .build()));
	    }

}
