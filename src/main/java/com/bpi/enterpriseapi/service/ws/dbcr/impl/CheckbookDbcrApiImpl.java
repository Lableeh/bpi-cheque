package com.bpi.enterpriseapi.service.ws.dbcr.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpi.enterpriseapi.service.ws.dbcr.CheckbookDbcrApi;
import com.bpi.framework.exception.HostException;
import com.ibcb1in.ibcboc1a.IBCBOC1APort;
import com.request.ibcb1in.ibcboc1a.ProgramInterface.WsiIbcboc01;
import com.response.ibcb1in.ibcboc1a.ProgramInterface.WsoIbcboc01;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CheckbookDbcrApiImpl implements CheckbookDbcrApi {

	private static final String SUCCESS_MESSAGE = "OKOKOK";

	@Autowired
	private IBCBOC1APort port;

	@Override
	public WsoIbcboc01 reorder(WsiIbcboc01 request) throws HostException {

		log.info("Calling checkbook dbcr of eolNg");

			WsoIbcboc01 response = port.ibcboc1AOperation(request);
			log.info("RESPONSE CONTAINS {}", response.getWsoMessage());
		
			if (response.getWsoMessage().equals(SUCCESS_MESSAGE)) {
				return response;
			}
			throw new HostException("", response.getWsoMessage());
		
	}
}
