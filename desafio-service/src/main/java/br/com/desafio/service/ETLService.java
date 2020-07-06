package br.com.desafio.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.desafio.mapper.CnesMapper;
import br.com.desafio.persistence.model.Cnes;
import br.com.desafio.util.ConstantesUtil;

/**
 * Classe responsável por manipular o dataset e criar os objetos referentes ao
 * {@link Cnes}
 * 
 * @author wemerson.vitalporto
 *
 */
@LocalBean
@Stateless
public class ETLService {
	private static final String SOURCE_FILE = "cnes_ativonone.csv";

	@EJB
	private CnesService cnesService;

	/**
	 * Inicia o processo de ETL dos dados do dataset no formato CSV
	 */
	public void execute() {
		BufferedReader buffer = getFile(SOURCE_FILE);
		converterArquivoToObjeto(buffer);
	}

	/**
	 * Método converto as linhas do arquivo em objeto do tipo {@link Cnes}
	 * 
	 * @param buffer
	 * @return {@link List<Cnes>} lista de objetos
	 */
	private List<Cnes> converterArquivoToObjeto(BufferedReader buffer) {
		List<Cnes> lista = new ArrayList<>();
		int interacao = 0;
		if (buffer == null) {
			return null;
		}
		System.out.println(">>>>>>>>>>>>>> INICIANDO A LEITURA");		
		String linhaAtual = null;
		try {
			while(( linhaAtual = buffer.readLine()) != null) {
				String[] linha = getLinhaArquivo(linhaAtual);
				// Verifica se é a linha do cabçalho do arquivo e ignora.
				if (interacao == 0) {
					interacao++;
					continue;
				}
				// Preenche a lista final com os objetos convertidos
				cnesService.gravar(CnesMapper.mapperToLinha((linha)));
			}
		} catch (IOException e) {
			throw new IllegalArgumentException(ConstantesUtil.ARQUIVO_NAO_ENCONTRADO);
		}
		System.out.println(">>>>>>>>>>>>>> FINALIZADO A LEITURA");		
		return lista;
		
	}

	/**
	 * Recupera o arquivo do resource
	 * 
	 * @param fileName
	 * @return {@link File}
	 */
	private BufferedReader getFile(String fileName) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream input = loader.getResourceAsStream(fileName);
		if (input == null) {
			throw new IllegalArgumentException(ConstantesUtil.ARQUIVO_NAO_ENCONTRADO);
		} else {
			return new BufferedReader(new InputStreamReader(input));
		}

	}

	/**
	 * Método recebe a linha do arquivo e converte para uma lista de String para
	 * construção do objeto
	 * 
	 * @param itemAtual linha sem com formatação orginal
	 * @return {@link List<String} linha lida do csv
	 */
	private String[] getLinhaArquivo(String itemAtual) {
		itemAtual = itemAtual.replaceAll(ConstantesUtil.ASPAS_DUPLAS, "");
		return itemAtual.split(ConstantesUtil.DEFAULT_SEPARADOR);
	}
}
