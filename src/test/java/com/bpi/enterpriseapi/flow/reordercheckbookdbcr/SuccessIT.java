package com.bpi.enterpriseapi.flow.reordercheckbookdbcr;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static com.bpi.enterpriseapi.flow.reordercheckbookdbcr.testmatcher.MockMvcJsonPathMatchers.status;
import static com.bpi.enterpriseapi.flow.reordercheckbookdbcr.testmatcher.MockMvcJsonPathMatchers.code;
import static com.bpi.enterpriseapi.flow.reordercheckbookdbcr.testmatcher.MockMvcJsonPathMatchers.description;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import com.bpi.enterpriseapi.ApplicationTest;
import com.bpi.enterpriseapi.dto.api.CheckbookRequest;
import com.bpi.enterpriseapi.flow.reordercheckbookdbcr.testmatcher.ReorderCheckbookDbcrArgumentMatcher;
import com.bpi.framework.model.Response;
import com.bpi.framework.model.ResponseStatus;
import com.bpi.framework.model.helper.GenericRequestHeader;
import com.ibcb1in.ibcboc1a.IBCBOC1APort;
import com.request.ibcb1in.ibcboc1a.ProgramInterface.WsiIbcboc01;
import com.response.ibcb1in.ibcboc1a.ProgramInterface.WsoIbcboc01;

import static java.util.UUID.randomUUID;
public class SuccessIT extends ApplicationTest{
	
	@MockBean
	private IBCBOC1APort reorderService;
	
	@Test
	public void testSuccess() throws Exception{
		CheckbookRequest checkbookRequest = TestDataFactory.prepareCheckbookRequest("FC");
		WsiIbcboc01 validSoapRequest = TestDataFactory.prepareCheckbookSoapRequest(checkbookRequest);
		WsoIbcboc01 validSoapResponse = TestDataFactory.prepareSoapResponse();
		Mockito.when(reorderService.ibcboc1AOperation(Mockito.argThat(new ReorderCheckbookDbcrArgumentMatcher(validSoapRequest))))
		.thenReturn(validSoapResponse);
				
		
		mockMvc.perform(post(REORDER_CHECKBOOK_DBCR_PATH)
				.servletPath(REORDER_CHECKBOOK_DBCR_PATH)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.header(GenericRequestHeader.API_KEY, API_KEY)
				.header(GenericRequestHeader.API_SECRET, API_SECRET)
				.header(GenericRequestHeader.REQUEST_UID, randomUUID())
				.header(GenericRequestHeader.RESOURCE_OWNER_ID, RESOURCE_OWNER_ID)
				.header(GenericRequestHeader.DEVICE_HASH, DEVICE_HASH)
				.content(mapper.writeValueAsString(checkbookRequest)))
				.andExpect(status().isOk())
				.andExpect(status(is(ResponseStatus.SUCCESS.getValue())))
				.andExpect(code(is("0")))
		        .andExpect(description(is("Success")))
		        .andDo(print())
		        .andReturn();
		
		Mockito.verify(reorderService).ibcboc1AOperation(Mockito.argThat(new ReorderCheckbookDbcrArgumentMatcher(validSoapRequest)));
	}


}
