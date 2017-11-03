package br.jus.tse.corporativa.util.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:META-INF/spring/camel-context.xml"})
public class CamelSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelSpringBootApplication.class, args);
	}
	
}
