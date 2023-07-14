package git.com.lucascastro94.purchaseapi.service;


import git.com.lucascastro94.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PurchaseProducerService {
    @Value("${topic.name.producer}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Purchase> customerKafkaTemplate;

    public PurchaseProducerService(KafkaTemplate<String, Purchase> customerKafkaTemplate) {
        this.customerKafkaTemplate = customerKafkaTemplate;
    }

    public void produce(Purchase purchase){
        customerKafkaTemplate.send(topic,purchase);
    }
}
