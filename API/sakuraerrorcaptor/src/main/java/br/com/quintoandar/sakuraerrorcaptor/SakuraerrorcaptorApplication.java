package br.com.quintoandar.sakuraerrorcaptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SakuraerrorcaptorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakuraerrorcaptorApplication.class, args);
	}

}
