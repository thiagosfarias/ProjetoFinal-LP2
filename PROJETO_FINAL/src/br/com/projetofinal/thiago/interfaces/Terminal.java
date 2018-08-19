package br.com.projetofinal.thiago.interfaces;

import java.io.IOException;
import java.util.Scanner;

import br.com.projetofinal.thiago.bancodedados.BancoDeAtas;
import br.com.projetofinal.thiago.bancodedados.BancoDeFuncionarios;
import br.com.projetofinal.thiago.entidade.Ata;
import br.com.projetofinal.thiago.entidade.Funcionario;

public class Terminal {
	
	

	public void iniciaTerminal() {
		BancoDeAtas bancoDeAtas = new BancoDeAtas();
		BancoDeFuncionarios bancoDeFuncionarios = new BancoDeFuncionarios();
		bancoDeFuncionarios.adicionaFuncionario();

		int opcao = 0;
		while (opcao != 5) {
			opcao = getTypedInt(
					"0 - Gerar Ata, 1 - Alterar estado de visbilidade da Ata, 2 - Visualizar Ata, 3 - Remover Ata, 4 - Estatisticas, 5 - Buscar Funcionario, 6 - Voltar");
			if (opcao == 0) {
				opcao = getTypedInt("0 - Reuniao excluisva com funcionarios, 1 - Reuniao com participantes externos");
				if (opcao == 0) {
					bancoDeAtas.adicionaAtaAoBancoDeAtas(new Ata(getTypedString("TITULO DA REUNIAO: "),
							getTypedString("EMISSOR: "), getTypedString("NOMES DOS FUNCIONARIOS PARTICIPANTES: "),
							getTypedString("EMAILS: "), getTypedString("PAUTA: "), getTypedString("SETOR: "),
							getTypedString("DESCRICAO: ")));
				}

				else if (opcao == 1) {
					bancoDeAtas.adicionaAtaAoBancoDeAtas(new Ata(getTypedString("TITULO DA REUNIAO: "),
							getTypedString("EMISSOR: "), getTypedString("NOMES DOS FUNCIONARIOS PARTICIPANTES: "),
							getTypedString("EMAILS: "), getTypedString("NOMES DO PARTICIPANTES EXTERNOS: "),
							getTypedString("E-MAILS: "), getTypedString("EMPRESA: "), getTypedString("PAUTA: "),
							getTypedString("SETOR: "), getTypedString("DESCRICAO: ")));
				}

			} else if (opcao == 1) {
				Ata ata = bancoDeAtas.buscaAtaPorNome("INFORME SEU NOME: ");
				if (ata.getFuncionarioEmissor() != null) {
					System.out.println("STATUS - 0: Pública, 1: Privada");
					System.out.println(ata.toString());
					opcao = getTypedInt("DIGITE 0 ou 1 PARA ALTERAR VISIBILIDADE DA ATA: ");
					if (opcao == 1) {
						ata.setEstadoDeVisibilidadeDaAta(opcao);
						System.out.println("ALTERADO COM SUCESSO PARA PRIVADO!");
					} else if (opcao == 0) {
						ata.setEstadoDeVisibilidadeDaAta(opcao);
						System.out.println("ALTERADO COM SUCESSO PARA PUBLICO!");
					} else {
						System.err.println("DIGITE 0 ou 1");
					}
				}
			} else if (opcao == 2) {
				String nome = getTypedString("INFORME SEU NOME: ");
				Ata ata = bancoDeAtas.buscaAtaPorNome(nome);
				if (nome.equalsIgnoreCase(ata.getFuncionarioEmissor().getNome()) || !(("Pré-emissao").equals(ata.getEstadoDeEmissao())))
					System.out.println(ata.toString());
				else {
					System.err.println("ACESSO NEGADO!");
				}
				opcao = getTypedInt("Deseja alterar o estado de emissao? 0 - Não, 1 - Sim");
				if (opcao == 0)
					break;
				else if (opcao == 1) {
					String opcaoDeStatus = getTypedString(
							"Digite: Processo em Revisao (Uma copia da ata será enviada para os participantes por email para ser avaliada) ou Emitida(sendo fechada as sugestoes)");
					if (!("Processo em Revisao").equalsIgnoreCase(opcaoDeStatus)
							|| !("Emitida").equalsIgnoreCase(opcaoDeStatus)) {
						System.err.println("Status invalido!");
					} else {
						try {
							ata.avisoPorEmail(getTypedString("ASSUNTO: "), getTypedString("TITULO DO EMAIL EM TXT: "),
									getTypedString(ata.getFuncionariosParticipantes().getEmail()));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} else if (opcao == 3) {
				bancoDeAtas.removeAtaDoBancoPorNome(getTypedString("INFORME SEU NOME"));
				System.out.println("REMOÇÃO FEITA COM SUCESSO");
			} else if (opcao == 4) {
				opcao = (getTypedInt("0 - MEDIA DE ATAS POR SETOR, 1 - MEDIA DE ATAS POR FUNCIONARIO"));
				if (opcao == 0) {
					double mediaDeAtasPorSetor = bancoDeAtas.percentualDeAtasPorSetor(getTypedString("SETOR: "));
					System.out.println(mediaDeAtasPorSetor + "%");
				} else if (opcao == 1) {
					double mediaDeAtasPorFuncionario = bancoDeAtas.percentualDeAtasPorFuncionario(getTypedString("INFORME SEU NOME: "));
					System.out.println(mediaDeAtasPorFuncionario + "%");
				} else {
					System.err.println("DIGITE 0 ou 1");
				}
			} else if (opcao == 5) {
				Funcionario funcionario = bancoDeFuncionarios.buscaFuncionario(getTypedString("DIGITE O NOME: "));
				if (funcionario != null) {
					System.out.println("Funcionario existe!");
					System.out.println(funcionario.toString());
				}
				else System.err.println("Funcionario não existe!");
			} 
			
		}
	}

	private int getTypedInt(String string) {
		Scanner scanInt = new Scanner(System.in);
		System.out.println(string);
		if (scanInt.hasNextInt()) {
			return scanInt.nextInt();
		}
		String st = scanInt.next();
		System.err.println("ERRO");
		return 0;
	}

	private String getTypedString(String string) {
		Scanner scanString = new Scanner(System.in);
		System.out.println(string);
		if (scanString.hasNextLine()) {
			return scanString.nextLine();
		}
		String st = scanString.next();
		System.err.println("ERRO");
		return null;
	}

}
