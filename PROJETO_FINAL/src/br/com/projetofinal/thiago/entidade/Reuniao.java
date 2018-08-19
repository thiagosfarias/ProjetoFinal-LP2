package br.com.projetofinal.thiago.entidade;

import java.util.Calendar;
import java.util.Date;

import br.com.projetofinal.thiago.util.DataUtil;

public class Reuniao {
	private String tituloDaReuniao;
	private DataUtil dataDaReuniao;
	private String pautaDaReuniao;
	private String descricaoDaReuniao;
	private Date horarioDeInicioDaReuniao;
	private Date horarioDeTerminoDaReuniao;

	public Reuniao(String tituloDaReuniao, String pautaDaReuniao, String descricao) {
		this.tituloDaReuniao = tituloDaReuniao;
		this.pautaDaReuniao = pautaDaReuniao;
		this.descricaoDaReuniao = descricao;
	}

	public DataUtil getDataDaReuniao() {
		return this.dataDaReuniao;
	}

	public String getDescricaoDaReuniao() {
		return this.descricaoDaReuniao;
	}

	public Date getHorarioDeInicioDaReuniao() {
		return this.horarioDeInicioDaReuniao;
	}

	public Date getHorarioDeTerminoDaReuniao() {
		return this.horarioDeTerminoDaReuniao;
	}

	public String getPautaDaReuniao() {
		return this.pautaDaReuniao;
	}

	public String getTituloDaReuniao() {
		return this.tituloDaReuniao;
	}

	public void setTituloDaReuniao(String tituloDaReuniao) {
		this.tituloDaReuniao = tituloDaReuniao;
	}
	
	public String toString() {
		return "DATA DA REUNIAO: " + this.dataDaReuniao.getCurrentDate() + "\n"
				+ "HORARIO DE INICIO: " + this.horarioDeInicioDaReuniao.getHours() +  ":" + this.horarioDeInicioDaReuniao.getMinutes() + "\n" 
				+ "HORARIO DE TERMINO: " + this.horarioDeTerminoDaReuniao.getHours() + ":" + this.horarioDeTerminoDaReuniao.getMinutes() + "\n"
				+ "PAUTA: " + this.getPautaDaReuniao() + "\n" + "DESCRICAO: " + this.getDescricaoDaReuniao();
	}
}
