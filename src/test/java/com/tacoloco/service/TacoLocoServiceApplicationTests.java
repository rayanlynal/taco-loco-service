package com.tacoloco.service;

import com.tacoloco.service.controller.TacoRestController;
import com.tacoloco.service.domain.TacoCalculateOrderItem;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.annotations.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(TacoLocoServiceApplicationTests.class)
public class TacoLocoServiceApplicationTests {
    TacoCalculateOrderItem mockTacoCalculateOrderItem = new TacoCalculateOrderItem(3, 1, 0, 1);
    String exampleCalculateOrderItemJson = "{\n" +
            " \"veggie\": 3,\n" +
            " \"chicken\": 1,\n" +
            " \"beef\": 0,\n" +
            " \"chorizo\": 1\n" +
            "}";
    @Autowired
    private MockMvc mvc;
    @MockBean
    private TacoRestController tacoRestController;

    @SuppressWarnings("unchecked")
    @Test
    public void retrieveTacoCalculateOrders() throws Exception {
        Mockito.when(tacoRestController.getTacoCalculateOrderItem(Mockito.any(TacoCalculateOrderItem.class))).thenReturn((Map<String, Double>) mockTacoCalculateOrderItem);
//
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/calculateOrders")
                .accept(MediaType.APPLICATION_JSON).content(exampleCalculateOrderItemJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        assertEquals("http://localhost:8080/calculateOrders", response.getHeader(HttpHeaders.LOCATION));
    }
}
