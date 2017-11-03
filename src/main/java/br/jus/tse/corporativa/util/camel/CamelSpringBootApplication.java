package br.jus.tse.corporativa.util.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@SpringBootApplication
@Configuration
@ImportResource({ "classpath:META-INF/spring/camel-context.xml" })
public class CamelSpringBootApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(CamelSpringBootApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		VersionResourceResolver versionResolver = new VersionResourceResolver().addContentVersionStrategy("/**");
		registry.addResourceHandler("/target/**").addResourceLocations("/target/", "file:target/").resourceChain(true).addResolver(versionResolver);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/target/work/*.json");
	}

}
