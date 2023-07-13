package git.com.lucascastro94.purchaseapi.service;


import git.com.lucascastro94.purchaseapi.model.Purchase;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PurchaseProducerService {
    @Value("${app.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Purchase> customerKafkaTemplate;

    public PurchaseProducerService(KafkaTemplate<String, Purchase> customerKafkaTemplate) {
        this.customerKafkaTemplate = customerKafkaTemplate;
    }

    public void produce(Purchase purchase){
        customerKafkaTemplate.send(topic,String.valueOf(purchase.getPurchaseID()),purchase);
    }
}
