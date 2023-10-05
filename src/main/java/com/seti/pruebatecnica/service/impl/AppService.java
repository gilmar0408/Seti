package com.seti.pruebatecnica.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seti.pruebatecnica.entity.Order;
import com.seti.pruebatecnica.entity.OrderResponse;
import com.seti.pruebatecnica.entity.RespuestaPedido;
import com.seti.pruebatecnica.service.IAppService;

import org.json.JSONObject;
import org.json.XML;

@Service
public class AppService implements IAppService {

	@Override
	public OrderResponse sendOrder(Order order) throws JsonProcessingException {

		// Convertimos JSON a XML

		String xmlString = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:env=\"http://WSDLs/EnvioPedidos/EnvioPedidosAcme\">\r\n"
				+ "   <soapenv:Header/>\r\n" + "   <soapenv:Body>\r\n" + "      <env:EnvioPedidoAcme>\r\n"
				+ "         <!--1 or more repetitions:-->\r\n" + "         <EnvioPedidoRequest>\r\n"
				+ "            <!--Optional:-->\r\n" + "            <pedido>" + order.getNumPedido() + "</pedido>\r\n"
				+ "            <!--Optional:-->\r\n" + "            <Cantidad>"
				+ String.valueOf(order.getCantidadPedido()) + "</Cantidad>\r\n" + "            <!--Optional:-->\r\n"
				+ "            <EAN>" + order.getCodigoEAN() + "</EAN>\r\n" + "            <!--Optional:-->\r\n"
				+ "            <Producto>" + order.getCodigoEAN() + "</Producto>\r\n"
				+ "            <!--Optional:-->\r\n" + "            <Cedula>" + order.getNumDocumento()
				+ "</Cedula>\r\n" + "            <!--Optional:-->\r\n" + "            <Direccion>"
				+ order.getDireccion() + "</Direccion>\r\n" + "         </EnvioPedidoRequest>\r\n"
				+ "      </env:EnvioPedidoAcme>\r\n" + "   </soapenv:Body>\r\n" + "</soapenv:Envelope>";

		RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		
		messageConverters.add(new StringHttpMessageConverter());
		
		restTemplate.setMessageConverters(messageConverters);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> request = new HttpEntity<String>(xmlString, headers);

		final ResponseEntity<String> response = restTemplate
				.postForEntity("https://run.mocky.io/v3/19217075-6d4e-4818-98bc-416d1feb7b84", request, String.class);

		System.out.println(response.getBody());

		JSONObject json = XML.toJSONObject(response.getBody());

		System.out.println(json);

		String Mensaje = json.getJSONObject("soapenv:Envelope").getJSONObject("soapenv:Body")
				.getJSONObject("env:EnvioPedidoAcmeResponse").getJSONObject("EnvioPedidoResponse").getString("Mensaje");

		int codigo = json.getJSONObject("soapenv:Envelope").getJSONObject("soapenv:Body")
				.getJSONObject("env:EnvioPedidoAcmeResponse").getJSONObject("EnvioPedidoResponse").getInt("Codigo");
		
		return new OrderResponse(new RespuestaPedido(String.valueOf(codigo), Mensaje));
	}

}
