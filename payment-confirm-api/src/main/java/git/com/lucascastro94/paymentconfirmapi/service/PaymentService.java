package git.com.lucascastro94.paymentconfirmapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import git.com.lucascastro94.paymentconfirmapi.model.Payment;
import git.com.lucascastro94.paymentconfirmapi.model.PaymentDTO;
import git.com.lucascastro94.paymentconfirmapi.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    private final  ObjectMapper objectMapper = new ObjectMapper();

    public void savePayment(PaymentDTO paymentDTO)
    {

        Payment payment = objectMapper.convertValue(paymentDTO,Payment.class);
        paymentRepository.save(payment);
    }

    public List<PaymentDTO> listAll() {
       return paymentRepository.findAll()
               .stream()
               .map(payment -> objectMapper.convertValue(payment,PaymentDTO.class))
               .toList();
    }

    public PaymentDTO findByPurchaseId(long purchaseId) {

            return objectMapper.convertValue(paymentRepository.findByPurchaseId(purchaseId), PaymentDTO.class);
        }

    }



