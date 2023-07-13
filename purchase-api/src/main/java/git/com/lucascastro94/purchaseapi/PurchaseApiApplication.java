package git.com.lucascastro94.purchaseapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class PurchaseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseApiApplication.class, args);
	}

}
