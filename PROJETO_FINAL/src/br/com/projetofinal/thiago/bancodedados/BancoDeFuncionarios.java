package br.com.projetofinal.thiago.bancodedados;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import br.com.projetofinal.thiago.entidade.Funcionario;

public class BancoDeFuncionarios {
	private HashSet<Funcionario> funcionarios;
	
	public BancoDeFuncionarios() {
		this.funcionarios = new HashSet<Funcionario>();
	}
	
	public void adicionaFuncionario() {
		try {
			Scanner sc = new Scanner(new File("C:\\Users\\Farias\\Desktop\\LP2_PROJETO_FINAL\\Funcionarios\\bancoDeFuncionarios.txt"));
			
			while (sc.hasNext()) {
				String strRead = sc.nextLine();
				StringTokenizer st = new StringTokenizer(strRead, "\n");
				String nome = st.nextToken();
				this.funcionarios.add(new Funcionario(nome));
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Funcionario buscaFuncionario(String nome) {
		for (Funcionario funcionario : funcionarios) {
			if(funcionario.getNome().equalsIgnoreCase(nome)) return funcionario;
		}
		return null;
	}
	
	public void exibeTodosOsFuncionarios() {
		for(Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.toString());
		}
	}
}


