package git.com.lucascastro94.paymentconfirmapi.service;

import git.com.lucascastro94.paymentconfirmapi.model.Payment;
import git.com.lucascastro94.paymentconfirmapi.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public void savePayment(Payment payment)
    {
        int a = 2;
        paymentRepository.save(payment);
    }

}
