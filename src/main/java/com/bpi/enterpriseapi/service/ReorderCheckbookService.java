package com.bpi.enterpriseapi.service;

import org.springframework.http.HttpHeaders;

import com.bpi.enterpriseapi.dto.api.CheckbookRequest;
import com.bpi.framework.model.helper.GenericRequestHeader;
import com.bpi.framework.model.helper.RestResponseContentWrapper;

public interface ReorderCheckbookService {

	RestResponseContentWrapper<HttpHeaders, Void> reorder(CheckbookRequest checkbookRequest, GenericRequestHeader header);
}
