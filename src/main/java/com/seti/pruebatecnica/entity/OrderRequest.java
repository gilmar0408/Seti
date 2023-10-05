package com.seti.pruebatecnica.entity;

public class OrderRequest {

	private Order order;

	public OrderRequest() {

	}

	public OrderRequest(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderRequest [order=" + order + "]";
	}
	
	
}
