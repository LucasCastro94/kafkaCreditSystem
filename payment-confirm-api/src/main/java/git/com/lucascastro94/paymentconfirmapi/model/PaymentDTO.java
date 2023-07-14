package git.com.lucascastro94.paymentconfirmapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import git.com.lucascastro94.Purchase;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDTO {

    private long purchaseId;
    private String creditCardNumber;


    public void setPaymentDTO(Purchase purchase)
    {
       this.purchaseId = purchase.getPurchaseID();
       this.creditCardNumber = mask(purchase.getCreditCard().toString());
    }

    private String mask(String str) {
        int length = str.length();
        if (length <= 3) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length - 3; i++) {
            result.append("*");
        }

        result.append(str.substring(length - 3));
        return result.toString();
    }

}
