package br.com.projetofinal.thiago.entidade;

import br.com.projetofinal.thiago.util.DataUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

public class Ata implements Serializable{
	private String setorResponsavel;
	private Funcionario funcionarioEmissor;
	private int estadoDeVisibilidadeDaAta;
	private Reuniao reuniao;
	private Funcionario funcionariosParticipantes;
	private ParticipanteExterno participante;
	private String estadoDeEmissao;
	
	public Ata(String titulo, String pauta, String descricao) {
		this.reuniao = new Reuniao(titulo, pauta, descricao);
	}

	public Ata(String titulo, String funcionarioEmissor, String funcionariosParticipantes, String email, String pauta,
			String setorResponsavel, String descricao) {
		this.reuniao = new Reuniao(titulo, pauta, descricao);
		this.funcionarioEmissor = new Funcionario(funcionarioEmissor);
		this.funcionariosParticipantes = new Funcionario(funcionariosParticipantes, email);
		this.setorResponsavel = setorResponsavel;
		this.estadoDeEmissao = "Pré-emitida";
	}

	public Ata(String titulo, String funcionarioEmissor, String funcionariosParticipantes, String email, String nomesExternos,
			String emails, String empresa, String pauta, String setorResponsavel, String descricao) {
		this.reuniao = new Reuniao(titulo, pauta, descricao);
		this.funcionarioEmissor = new Funcionario(funcionarioEmissor);
		this.funcionariosParticipantes = new Funcionario(funcionariosParticipantes, email);
		this.participante = new ParticipanteExterno(nomesExternos, emails, empresa);
		this.setorResponsavel = setorResponsavel;
		this.estadoDeEmissao = "Pré-emitida";
	}

	public Reuniao getReuniao() {
		return this.reuniao;
	}
	
	public Funcionario getFuncionariosParticipantes() {
		return this.funcionariosParticipantes;
	}
	
	public void setEstadoDeEmissao(String estadoDeEmissao) {
		this.estadoDeEmissao = estadoDeEmissao;
	}

	public Funcionario getFuncionarioEmissor() {
		return this.funcionarioEmissor;
	}

	public String getSetorResponsavel() {
		return this.setorResponsavel;
	}

	public int getEstadoDeVisibilidadeDaAta() {
		return this.estadoDeVisibilidadeDaAta;
	}
	
	public String getEstadoDeEmissao() {
		return this.estadoDeEmissao;
	}

	public void setEstadoDeVisibilidadeDaAta(int estadoDeVisibilidadeDaAta) {
		this.estadoDeVisibilidadeDaAta = estadoDeVisibilidadeDaAta;
	}

	public void avisoPorEmail(String tituloDoEmail, String tituloDoEmailTXT, String destinatarios)
			throws IOException {
		Scanner sc = new Scanner(new File("C:\\Users\\Farias\\Desktop\\LP2_PROJETO_FINAL\\E-mails"));
		FileWriter fw = new FileWriter(tituloDoEmailTXT, false);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Assunto: " + tituloDoEmail);
		bw.newLine();
		bw.write("DESTINATARIOS: " + destinatarios);
		bw.write("ATA ESTÁ EM ESTADO EM PROCESSO DE REVISAO< SUBMETA SUA SUGESTAO ATRAVES DO SISTEMA!");
		bw.close();
	}

	public String toString() {
		return  "\n" + "EMISSOR: " + this.getFuncionarioEmissor().getNome() + "SETOR RESPONSAVEL: " + this.getSetorResponsavel() + "\n"
				+ this.getReuniao().toString() + "\n" + "STATUS DE VISIBILIDADE: " + this.getEstadoDeVisibilidadeDaAta() + "\n" + "STATUS DE EMISSAO: " + this.getEstadoDeEmissao(); 
	}

}
