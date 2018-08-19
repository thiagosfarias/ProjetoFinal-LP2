package br.com.projetofinal.thiago.interfaces;

import br.com.projetofinal.thiago.bancodedados.BancoDeAtas;
import br.com.projetofinal.thiago.bancodedados.BancoDeFuncionarios;
import br.com.projetofinal.thiago.entidade.Ata;
import br.com.projetofinal.thiago.entidade.Funcionario;

public class Principal {
	public static void main(String[] args) {
		new Terminal().iniciaTerminal();
	}
}
