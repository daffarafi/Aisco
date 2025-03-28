package aisco.paymentgateway.core;

import java.util.List;

public class PaymentGatewayImpl extends PaymentGatewayComponent {
    List<Object> paymentList;

    public PaymentGatewayImpl(String name, String email, String phone, int amount, String paymentMethod) {
        super(name, email, phone, amount, paymentMethod);
    }

    public void addTransaction() {
        transactionList.add("Payment from Alice - QRIS - 50,000");
        transactionList.add("Payment from Bob - BANK TRANSFER - 60,000");
        transactionList.add("Payment from Charlie - EWALLET - 70,000");
    }

    public void getTransaction() {
        System.out.println("Payments have a fee of 0 IDR");
        super.getTransaction();
    }
}
