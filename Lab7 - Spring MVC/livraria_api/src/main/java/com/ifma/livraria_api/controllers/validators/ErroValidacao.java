package com.ifma.livraria_api.controllers.validators;

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