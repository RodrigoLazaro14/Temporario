package com.groupg4.global.model;

public class UsuarioLogin {
	
	private String nomeUsuarioLogin;
	
	private String loginUsuarioLogin;
	
	private int tipoPessoa;
	
	private String senhaUsuarioLogin;
	
	private String tokenUsuarioLogin;
		
	//Getters and Setters

	public String getNomeUsuarioLogin() {
		return nomeUsuarioLogin;
	}

	public void setNomeUsuarioLogin(String nomeUsuarioLogin) {
		this.nomeUsuarioLogin = nomeUsuarioLogin;
	}

	public String getLoginUsuarioLogin() {
		return loginUsuarioLogin;
	}

	public void setLoginUsuarioLogin(String loginUsuarioLogin) {
		this.loginUsuarioLogin = loginUsuarioLogin;
	}

	public String getSenhaUsuarioLogin() {
		return senhaUsuarioLogin;
	}

	public void setSenhaUsuarioLogin(String senhaUsuarioLogin) {
		this.senhaUsuarioLogin = senhaUsuarioLogin;
	}

	public String getTokenUsuarioLogin() {
		return tokenUsuarioLogin;
	}

	public void setTokenUsuarioLogin(String tokenUsuarioLogin) {
		this.tokenUsuarioLogin = tokenUsuarioLogin;
	}
	
	public int getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(int tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
}
