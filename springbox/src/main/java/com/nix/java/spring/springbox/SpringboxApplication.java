package com.nix.java.spring.springbox;

import com.nix.java.spring.springbox.databox.Account;
import com.nix.java.spring.springbox.databox.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringboxApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringboxApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringboxApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AccountRepository repository) {
		return (args) -> {
			// fetch all accounts
			log.info("Accounts found with findAll():");
			log.info("-------------------------------");
			for (Account account : repository.findAll()) {
				log.info(account.toString());
			}
			log.info("");

			// fetch an individual account by ID
			Account account = repository.findById(1);
			log.info("Account found with findById(1):");
			log.info("--------------------------------");
			log.info(account.toString());
			log.info("");

			// fetch accounts by last name
			log.info("Account found with findByNickname('onepuchman'):");
			log.info("--------------------------------------------");
			repository.findByName("pixel").forEach(pixel -> log.info(pixel.toString()));

			log.info(repository.findByNickname("onepuchman").toString());

			log.info("");
		};
	}

}
