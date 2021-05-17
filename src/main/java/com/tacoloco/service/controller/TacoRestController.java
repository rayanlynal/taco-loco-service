package com.tacoloco.service.controller;

import com.tacoloco.service.domain.TacoCalculateOrderItem;
import com.tacoloco.service.domain.TacoCalculateOrders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TacoRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TacoRestController.class.getName());

    @RequestMapping("/")
    public String greeting() {
        return "WELCOME TO TACO LOCO BACKEND API SERVICE :: Please provide POST REQUEST via POSTMAN etc";
    }

    @PostMapping("/calculateOrders")
    public Map<String, Double> getTacoCalculateOrders(@RequestBody TacoCalculateOrders order) {
        LOGGER.info("----REST API CALLING //calculateOrders----------");
        Assert.notNull(order, "THIS ORDER CANNOT BE NULL");
        HashMap<String, Double> orderTotalPrice = new HashMap<>();
        orderTotalPrice.put("ORDER TOTAL", order.getTacoOrderTotal());
        return orderTotalPrice;
    }

    @PostMapping("/calculateOrderItem")
    public Map<String, Double> getTacoCalculateOrderItem(@RequestBody TacoCalculateOrderItem order) {
        LOGGER.info("----REST API CALLING //CalculateOrderItem----------");
        Assert.notNull(order, "order cannot be null");
        HashMap<String, Double> map = new HashMap<>();
        map.put("order total", order.getCalculateOrderTotal());
        return map;
    }
}
