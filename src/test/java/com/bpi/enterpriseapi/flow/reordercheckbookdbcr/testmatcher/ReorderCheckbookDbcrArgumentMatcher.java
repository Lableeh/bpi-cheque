package com.bpi.enterpriseapi.flow.reordercheckbookdbcr.testmatcher;

import org.mockito.ArgumentMatcher;

import com.request.ibcb1in.ibcboc1a.ProgramInterface.WsiIbcboc01;

public class ReorderCheckbookDbcrArgumentMatcher implements ArgumentMatcher<WsiIbcboc01>{
	private WsiIbcboc01 request;

    public ReorderCheckbookDbcrArgumentMatcher(WsiIbcboc01 request) {
    	this.request = request;
    }
    
    
	@Override
	public boolean matches(WsiIbcboc01 argument) {
		return request.getWsiAccount().equals(argument.getWsiAccount()) &&
			   request.getWsiCtl1().equals(argument.getWsiCtl1()) &&
			   request.getWsiCtl2().equals(argument.getWsiCtl2()) &&
			   request.getWsiCtl3().equals(argument.getWsiCtl3()) &&
			   request.getWsiCtl4().equals(argument.getWsiCtl4()) &&
			   request.getWsiNoChecks() == argument.getWsiNoChecks() &&
			   request.getWsiRmNumber().equals(argument.getWsiRmNumber());
	}
}
