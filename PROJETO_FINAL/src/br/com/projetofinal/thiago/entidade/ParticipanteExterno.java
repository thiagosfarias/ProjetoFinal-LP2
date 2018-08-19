package br.com.projetofinal.thiago.entidade;

public class ParticipanteExterno extends Pessoa{
	private String email;
	private String empresa;

	public ParticipanteExterno(String nome, String email, String empresa) {
		super(nome);
		this.email = email;
		this.empresa = empresa;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getEmpresa() {
		return this.empresa;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

}
