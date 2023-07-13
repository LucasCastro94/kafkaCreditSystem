package git.com.lucascastro94.paymentconfirmapi.utils;

import git.com.lucascastro94.paymentconfirmapi.model.Purchase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class PurchaseConsumer {
    @KafkaListener(topics = "${app.topic}")
    public void consumeCustomer(Purchase purchase, Acknowledgment acknowledgment){
        System.out.println("AQUIIIII"+purchase.getCreditCard());
        acknowledgment.acknowledge();
    }

}
