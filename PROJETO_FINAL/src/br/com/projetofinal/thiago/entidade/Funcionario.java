package br.com.projetofinal.thiago.entidade;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.projetofinal.thiago.util.DataUtil;

public class Funcionario extends Pessoa {
	private  String email;
	
	public Funcionario(String nome) {
		super(nome);
	}
	
	public Funcionario(String nome, String email) {
		super(nome);
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public void setNome(String nome) {
		super.setNome(nome);
	}
	
	public String toString() {
		return "Nome do funcionario: " + super.getNome();
	}
}
