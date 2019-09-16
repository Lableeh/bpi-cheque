package com.bpi.enterpriseapi.service.ws.dbcr;

import com.request.ibcb1in.ibcboc1a.ProgramInterface.WsiIbcboc01;
import com.response.ibcb1in.ibcboc1a.ProgramInterface.WsoIbcboc01;

public interface CheckbookDbcrApi {

	WsoIbcboc01 reorder(WsiIbcboc01 request) throws Exception;
}
