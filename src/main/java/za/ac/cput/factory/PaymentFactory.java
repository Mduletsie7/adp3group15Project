package za.ac.cput.factory;

import za.ac.cput.domain.Consultant;
import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;

public class PaymentFactory {
    public static Payment createPayment(String paymentAmount, String paymentDate) {
        if (Helper.isNullOrEmpty(paymentAmount) || Helper.isNullOrEmpty(paymentDate)) {
            return null;
        }

        String paymentId = Helper.generateId();

        Payment payment = new Payment.Builder()
                .setPaymentId(paymentId)
                .setPaymentAmount(paymentAmount)
                .setPaymentDate(paymentDate)
                .build();

        return payment;
    }
}
