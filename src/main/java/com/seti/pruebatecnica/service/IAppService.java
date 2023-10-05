package com.seti.pruebatecnica.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seti.pruebatecnica.entity.Order;
import com.seti.pruebatecnica.entity.OrderResponse;

public interface IAppService {
	
	OrderResponse sendOrder(Order order) throws JsonProcessingException;

}
