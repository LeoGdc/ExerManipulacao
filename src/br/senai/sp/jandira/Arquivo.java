package br.senai.sp.jandira;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {

	// cria o arquivo quando esse não exitir e grava dados
	// no arquivo
	public boolean escrever(String caminho, String texto) {
		try {

			// objeto que representa o arquivo
			FileWriter arquivo = new FileWriter(caminho);

			// objeto que representa a manipulação (escrever) dos dados
			PrintWriter escreverArq = new PrintWriter(arquivo);

			escreverArq.append(texto);
			escreverArq.close();
			return true;

		} catch (IOException e) {

			System.out.println("ERRO: " + e.getMessage());

			return false;
		}
	}

	public String ler(String caminho) {

		String conteudo = "";

		try {
			// representa o arquivo em modo de leitura
			FileReader arquivo = new FileReader(caminho);

			// representa o dado de leitura na memoria principal do programa
			BufferedReader lerArquivo = new BufferedReader(arquivo);

			String linha = lerArquivo.readLine();
			while (linha != null) {
				conteudo += linha + "\n";
				linha = lerArquivo.readLine();
			}
			arquivo.close();
			return conteudo;

		} catch (IOException e) {
			System.out.println("ERRO: " + e.getMessage());
			return "";
		}
	}
}