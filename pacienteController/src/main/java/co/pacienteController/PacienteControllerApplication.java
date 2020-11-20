package co.pacienteController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableEurekaClient
public class PacienteControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacienteControllerApplication.class, args);
	}

}
