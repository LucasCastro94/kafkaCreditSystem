package git.com.lucascastro94.paymentconfirmapi.model;

import git.com.lucascastro94.Purchase;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentDTO {
    private long id_compra;
    private String creditCardNumber;


    public void setPaymentDTO(Purchase purchase)
    {
       this.id_compra = purchase.getPurchaseID();
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
