package site.tj.program;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"site.tj.program.mapper",})
public class TjApplication {

	public static void main(String[] args) {
		SpringApplication.run(TjApplication.class, args);
	}
}
