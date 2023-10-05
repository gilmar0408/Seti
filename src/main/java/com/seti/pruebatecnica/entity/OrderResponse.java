package com.seti.pruebatecnica.entity;

public class OrderResponse {

	private RespuestaPedido respuestaPedido;

	public OrderResponse() {

	}

	public OrderResponse(RespuestaPedido respuestaPedido) {
		this.respuestaPedido = respuestaPedido;
	}

	public RespuestaPedido getRespuestaPedido() {
		return respuestaPedido;
	}

	public void setRespuestaPedido(RespuestaPedido respuestaPedido) {
		this.respuestaPedido = respuestaPedido;
	}

	@Override
	public String toString() {
		return "OrderResponse [respuestaPedido=" + respuestaPedido + "]";
	}

}
