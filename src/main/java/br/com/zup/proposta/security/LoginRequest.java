package br.com.zup.proposta.security;

public class LoginRequest {

	private String username;
	private String password;
	private String clientId;
	private String scope;
	
	public LoginRequest(String username, String password, String clientId, String scope) {
		super();
		this.username = username;
		this.password = password;
		this.clientId = clientId;
		this.scope = scope;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getClientId() {
		return clientId;
	}

	public String getScope() {
		return scope;
	}	
}
