package in.sp.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootProject7Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject7Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		myClass().printMessage("Sangam");
		
	}
	
	@Bean
	public MyClass myClass()
	{
	
		return new MyClass();
	}
}
