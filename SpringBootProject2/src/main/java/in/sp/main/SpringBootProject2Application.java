package in.sp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProject2Application {

	public static void main(String[] args) {
		System.out.println("application started..");
		SpringApplication.run(SpringBootProject2Application.class, args);
		System.out.println("application ended..");
	}

}
