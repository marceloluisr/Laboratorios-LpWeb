package com.marcelor.fretes_api.controller.validators;

public class ErroValidacao {
	private String campo;
	private String mensagem;

	public ErroValidacao(String campo, String erro) {
		this.campo = campo;
		this.mensagem = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}
}
