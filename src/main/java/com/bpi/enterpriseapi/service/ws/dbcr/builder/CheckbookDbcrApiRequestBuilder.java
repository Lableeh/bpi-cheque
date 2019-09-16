package com.bpi.enterpriseapi.service.ws.dbcr.builder;

import java.math.BigDecimal;

import com.request.ibcb1in.ibcboc1a.ProgramInterface.WsiIbcboc01;

import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(fluent = true)
public class CheckbookDbcrApiRequestBuilder {
	
	private String institutionCode;

	private String branchCode;

	private String currencyCode;

	private String control4;

	private String rmNumber;

	private String sourceAccountNumber;

	private Integer numberOfChecks;

	private BigDecimal fee;

	private String accountJai;

	private String message;
	
	public WsiIbcboc01 build() {
        String amount = (fee.multiply(new BigDecimal(numberOfChecks))).toString();
        WsiIbcboc01 checkbookData = new WsiIbcboc01();
        checkbookData.setWsiAccount(sourceAccountNumber);
        checkbookData.setWsiAccountJai(accountJai);
        checkbookData.setWsiAmount(amount);
        checkbookData.setWsiCtl1(institutionCode);
        checkbookData.setWsiCtl2(currencyCode);
        checkbookData.setWsiCtl3(branchCode);
        checkbookData.setWsiCtl4(control4);
        checkbookData.setWsiMessage(message);
        checkbookData.setWsiNoChecks(numberOfChecks);
        checkbookData.setWsiRmNumber(rmNumber);
        return checkbookData;
    }
}
