package com.bpi.enterpriseapi;

import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockserver.integration.ClientAndServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bpi.framework.model.Response;
import com.bpi.framework.model.ResponseStatus;
import com.bpi.framework.model.helper.GenericRequestHeader;
import com.fasterxml.jackson.databind.ObjectMapper;
import static java.util.UUID.randomUUID;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

	protected static ClientAndServer mockServer;

    protected static final String RESOURCE_OWNER_ID = "INTERNAL";

    protected static final String API_KEY = "b251c518-d3dc-4f0f-b6dc-19ea588ba853";

    protected static final String API_SECRET = "4i2nhpS6OwIsCbD3dRPCtcmpH7E5JJKxPrpirzdyx66aeDThg0";

    protected static final String DEVICE_HASH = "s0m3r@nd0mH@sh";

    private static final String BASE_PATH = "/v1/cheque";

    protected static final String REORDER_CHECKBOOK_DBCR_PATH = BASE_PATH + "/retail/debitCredit";
    
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper mapper;
    
    @BeforeClass
    public static void beforeClass() {
        mockServer = ClientAndServer.startClientAndServer(1080);
    }
    

    @Before
    public void before() {
        mockServer.reset();
    }
    
    @After
    public void after() {
        //pdcWarehouseAuditRepository.deleteAll();
    }
    
    @AfterClass
    public static void afterClass() {
        mockServer.stop();
    }
    
    public static <T> Response<T> wrap(T body) {
        Response<T> response = new Response<T>();
        response.setStatus(ResponseStatus.SUCCESS);
        response.setCode("0");
        response.setDescription("Success");
        response.setBody(body);
        return response;
    }
    
    protected HttpHeaders generateHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(GenericRequestHeader.API_KEY, API_KEY);
        httpHeaders.add(GenericRequestHeader.API_SECRET, API_SECRET);
        httpHeaders.add(GenericRequestHeader.REQUEST_UID, String.valueOf(randomUUID()));
        httpHeaders.add(GenericRequestHeader.RESOURCE_OWNER_ID, RESOURCE_OWNER_ID);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));
        return httpHeaders;
    }

    
	@Test
	public void contextLoads() {
	}

}
