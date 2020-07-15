package site.part.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MangerSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangerSystemApplication.class, args);
	}

}
