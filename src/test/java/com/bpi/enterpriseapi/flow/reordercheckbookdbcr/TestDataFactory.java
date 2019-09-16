package com.bpi.enterpriseapi.flow.reordercheckbookdbcr;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.bpi.enterpriseapi.dto.api.CheckbookRequest;
import com.bpi.enterpriseapi.service.ws.dbcr.CheckbookDbcrApi;
import com.bpi.framework.model.Response;
import com.bpi.framework.model.ResponseStatus;
import com.request.ibcb1in.ibcboc1a.ProgramInterface.WsiIbcboc01;
import com.response.ibcb1in.ibcboc1a.ProgramInterface.WsoIbcboc01;

public class TestDataFactory {


	@Autowired
	private static CheckbookDbcrApi eolNgCheckbookDbcrApi;
	
	public static CheckbookRequest prepareCheckbookRequest(String transactionType) throws Exception{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = format.parse("2019-03-21T15:40:10+0800");
        
        CheckbookRequest checkbookRequest = new CheckbookRequest();
        checkbookRequest.setSourceAccountNumber("00000010000001");
        checkbookRequest.setBranchCode("084");
        checkbookRequest.setConfirmationNumber("01234567890123456789");
        checkbookRequest.setCurrencyCode("001");
        checkbookRequest.setFee(new BigDecimal(50));
        checkbookRequest.setInstitutionCode("02");
        checkbookRequest.setNumberOfChecks(3);
        checkbookRequest.setRmNumber("00000000000001");
        checkbookRequest.setTransactionDate(date);
        checkbookRequest.setTransactionType(transactionType);
        checkbookRequest.setUserId("EOLNG001");
        return checkbookRequest;
	}
	
	public static WsiIbcboc01 prepareCheckbookSoapRequest(CheckbookRequest request) {
		WsiIbcboc01 soapRequest = new WsiIbcboc01();
		soapRequest.setWsiAccount(request.getSourceAccountNumber());
		soapRequest.setWsiAccountJai("");
		String amount = request.getFee().multiply(new BigDecimal(request.getNumberOfChecks())).toString();
		soapRequest.setWsiAmount(amount);
		soapRequest.setWsiCtl1(request.getInstitutionCode());
		soapRequest.setWsiCtl2(request.getCurrencyCode());
		soapRequest.setWsiCtl3(request.getBranchCode());
		soapRequest.setWsiCtl4("0000");
		soapRequest.setWsiMessage("");
		soapRequest.setWsiNoChecks(request.getNumberOfChecks());
		soapRequest.setWsiRmNumber(request.getRmNumber());
		return soapRequest;
	}
	
	public static WsoIbcboc01 prepareSoapResponse() {
		WsoIbcboc01 soapResponse = new WsoIbcboc01();
		soapResponse.setWsoAccount("00000010000001");
		soapResponse.setWsoAccountJai("");
		soapResponse.setWsoAmount(new BigDecimal(50).toString());
		soapResponse.setWsoCtl1("02");
		soapResponse.setWsoCtl2("001");
		soapResponse.setWsoCtl3("084");
		soapResponse.setWsoCtl4("0000");
		soapResponse.setWsoNoChecks(3);
		soapResponse.setWsoRmNumber("00000000000001");
		return soapResponse;
		
	
		
	}
}
