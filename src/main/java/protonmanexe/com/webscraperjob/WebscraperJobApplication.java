package protonmanexe.com.webscraperjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebscraperJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebscraperJobApplication.class, args);
		// System.exit(SpringApplication.exit(SpringApplication.run(WebscraperJobApplication.class, args)));
	}
}