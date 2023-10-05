package com.seti.pruebatecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seti.pruebatecnica.entity.OrderRequest;
import com.seti.pruebatecnica.entity.OrderResponse;
import com.seti.pruebatecnica.service.IAppService;

@RestController
@RequestMapping("/api/acme")
public class AppController {

	@Autowired
	private IAppService iAppService;

	@PostMapping("/enviarPedido")
	public ResponseEntity<OrderResponse> enviarPedido(@RequestBody OrderRequest orderRequest)
			throws JsonProcessingException {

		return new ResponseEntity<OrderResponse>(iAppService.sendOrder(orderRequest.getOrder()), HttpStatus.OK);
	}

}
