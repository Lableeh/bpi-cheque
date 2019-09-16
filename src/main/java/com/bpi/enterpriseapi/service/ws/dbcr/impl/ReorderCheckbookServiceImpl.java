package com.bpi.enterpriseapi.service.ws.dbcr.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.bpi.enterpriseapi.dto.api.CheckbookRequest;
import com.bpi.enterpriseapi.errorcode.ChequeErrorCode;
import com.bpi.enterpriseapi.service.ReorderCheckbookService;
//import com.bpi.enterpriseapi.service.biz.dbcr.RetailCheckbookDbcrService;
import com.bpi.enterpriseapi.service.ws.dbcr.CheckbookDbcrApi;
import com.bpi.enterpriseapi.service.ws.dbcr.builder.CheckbookDbcrApiRequestBuilder;
import com.bpi.framework.model.helper.GenericRequestHeader;
import com.bpi.framework.model.helper.RestResponseContentWrapper;
import com.request.ibcb1in.ibcboc1a.ProgramInterface.WsiIbcboc01;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReorderCheckbookServiceImpl implements ReorderCheckbookService {

	@Autowired
	private CheckbookDbcrApi eolNgCheckbookDbcrApi;

	@Override
    public RestResponseContentWrapper<HttpHeaders, Void> reorder(CheckbookRequest checkbookRequest, GenericRequestHeader header) {
        log.info("Perform checkbook reorder");

        RestResponseContentWrapper<HttpHeaders, Void> wrapper = new RestResponseContentWrapper<>();
        try {
        	WsiIbcboc01 wsiIbcboc01 = new WsiIbcboc01();
            wsiIbcboc01.setWsiCtl3(checkbookRequest.getBranchCode());
            wsiIbcboc01.setWsiCtl2(checkbookRequest.getCurrencyCode());
            String amount = checkbookRequest.getFee().multiply(new BigDecimal(checkbookRequest.getNumberOfChecks())).toString();
            wsiIbcboc01.setWsiAmount(amount);
            wsiIbcboc01.setWsiCtl1(checkbookRequest.getInstitutionCode());
            wsiIbcboc01.setWsiNoChecks(checkbookRequest.getNumberOfChecks());
            wsiIbcboc01.setWsiRmNumber(checkbookRequest.getRmNumber());
            wsiIbcboc01.setWsiAccount(checkbookRequest.getSourceAccountNumber());
            wsiIbcboc01.setWsiAccountJai("");
            wsiIbcboc01.setWsiMessage("OKOKOK");
            wsiIbcboc01.setWsiCtl4("0000");      
            eolNgCheckbookDbcrApi.reorder(wsiIbcboc01);
           
            
            wrapper.setWarningParent(ChequeErrorCode.PARTIAL_SUCCESS_REORDER_CHECKBOOK_DBCR);
            log.info("Successfully executed dbcr checkbook reorder. Perform financial transaction log");
        } catch (Exception e) {
            log.error("Failed to perform dbcr checkbook reorder", e);
        }

        return wrapper;
    }

}
