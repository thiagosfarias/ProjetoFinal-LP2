package br.com.projetofinal.thiago.bancodedados;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import br.com.projetofinal.thiago.entidade.Ata;
import br.com.projetofinal.thiago.entidade.Funcionario;


public class BancoDeAtas implements Serializable{
	private HashSet<Ata> atas = new HashSet<Ata>();
	

	public void adicionaAtaAoBancoDeAtas(Ata ata) {
		atas.add(ata);
		try {
			FileOutputStream arquivoDasAtas = new FileOutputStream("Atas");
			ObjectOutputStream objetoDasAtas;
			objetoDasAtas = new ObjectOutputStream(arquivoDasAtas);
			objetoDasAtas.writeObject(atas);
			objetoDasAtas.flush();
		} catch (IOException erro) {
			System.err.println("Erro de gravação no arquivo" + erro);
		}
	}

	public void removeAtaDoBancoPorNome(String nome) {
		for (Ata ata : atas) {
			if (ata.getFuncionarioEmissor().getNome().equalsIgnoreCase(nome))
				atas.remove(ata);
		}
	}
	
	public Ata buscaAtaPorNome(String nome) {
		for (Ata ata : atas) {
			if (ata.getFuncionarioEmissor().getNome().equalsIgnoreCase(nome))
				return ata;
		}
		return null;
	}
	

	public double percentualDeAtasPorSetor(String setor) {
		int totalPorSetor = 0;
		for (Ata ata : atas) {
			if (ata.getSetorResponsavel().equalsIgnoreCase(setor))
				totalPorSetor =+ 1;
		}
		return (totalPorSetor / this.totalDeAtas()) * 100;
	}

	public int totalDeAtas() {
		int totalDeAtas = 0;
		for (Ata ata : atas) {
			totalDeAtas++;
		}
		return totalDeAtas;
	}

	public double percentualDeAtasPorFuncionario(String nome) {
		int totalDeAtasPorFuncionario = 0;
		for (Ata ata : atas) {
			if (ata.getFuncionarioEmissor().getNome().equalsIgnoreCase(nome))
				totalDeAtasPorFuncionario = +1;
		}
		return (totalDeAtasPorFuncionario / this.totalDeAtas()) * 100;
	}
}
