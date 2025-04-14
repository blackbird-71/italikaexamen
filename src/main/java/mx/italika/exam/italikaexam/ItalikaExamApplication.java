package mx.italika.exam.italikaexam;

import mx.italika.exam.italikaexam.services.ProductService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ItalikaExamApplication
		implements CommandLineRunner
{

	@Autowired
	PasswordEncoder passwordEncoder;

	private static final Logger log = LoggerFactory.getLogger(ItalikaExamApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ItalikaExamApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("user : {}", this.passwordEncoder.encode("to_be_encoded"));
		log.info("client : {}", this.passwordEncoder.encode("secret"));

	}

}
