package com.seti.pruebatecnica.entity;

public class Order {
	
	private String numPedido;
	private int cantidadPedido;
	private String codigoEAN;
	private String nombreProducto;
	private String numDocumento;
	private String direccion;
	
	public Order  () {
		
	}

	public Order(String numPedido, int cantidadPedido, String codigoEAN, String nombreProducto, String numDocumento,
			String direccion) {
		this.numPedido = numPedido;
		this.cantidadPedido = cantidadPedido;
		this.codigoEAN = codigoEAN;
		this.nombreProducto = nombreProducto;
		this.numDocumento = numDocumento;
		this.direccion = direccion;
	}

	public String getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(String numPedido) {
		this.numPedido = numPedido;
	}

	public int getCantidadPedido() {
		return cantidadPedido;
	}

	public void setCantidadPedido(int cantidadPedido) {
		this.cantidadPedido = cantidadPedido;
	}

	public String getCodigoEAN() {
		return codigoEAN;
	}

	public void setCodigoEAN(String codigoEAN) {
		this.codigoEAN = codigoEAN;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Order [numPedido=" + numPedido + ", cantidadPedido=" + cantidadPedido + ", codigoEAN=" + codigoEAN
				+ ", nombreProducto=" + nombreProducto + ", numDocumento=" + numDocumento + ", direccion=" + direccion
				+ "]";
	}
	

}
