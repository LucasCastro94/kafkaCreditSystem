package git.com.lucascastro94.paymentconfirmapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class PaymentConfirmApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentConfirmApiApplication.class, args);
	}

}
