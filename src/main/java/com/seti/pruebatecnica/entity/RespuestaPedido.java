package com.seti.pruebatecnica.entity;

public class RespuestaPedido {

	private String codigoEnvio;
	private String estado;

	public RespuestaPedido() {

	}

	public RespuestaPedido(String codigoEnvio, String estado) {
		this.codigoEnvio = codigoEnvio;
		this.estado = estado;
	}

	public String getCodigoEnvio() {
		return codigoEnvio;
	}

	public void setCodigoEnvio(String codigoEnvio) {
		this.codigoEnvio = codigoEnvio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "RespuestaPedido [codigoEnvio=" + codigoEnvio + ", estado=" + estado + "]";
	}

}
