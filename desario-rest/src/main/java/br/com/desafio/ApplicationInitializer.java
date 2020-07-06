package br.com.desafio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.desafio.service.ETLService;

@Startup
@Singleton
public class ApplicationInitializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationInitializer.class);

	@EJB
	private ETLService etlService;

	@PostConstruct
	private void init() {
		LOGGER.info(">>>>>>>>>>>>> INICIANDO LEITURA DO ARQUIVO DATASET");
		//this.etlService.execute();
		LOGGER.info(">>>>>>>>>>>>> LEITURA CONCLUIDA DO ARQUIVO DATASET");
	}

}