package aisco.paymentgateway.paypal;

import java.util.List;
import aisco.paymentgateway.core.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class PaymentGatewayImpl extends PaymentGatewayDecorator {
    protected String paypalInvoice;

    public PaymentGatewayImpl(String name, String email, String phone, int amount) {
    	super();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.amount = amount;
        this.paymentMethod = "Paypal";
        this.generatePaypalInvoice();
    }

    public void generatePaypalInvoice() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        this.paypalInvoice = "PAYPAL-" + name.toUpperCase().replaceAll("\\s+", "") + "-" + timestamp;
    }

    public void addTransaction() {
        String transactionInfo = " | Name: " + this.name
            + " | Email: " + this.email
            + " | Phone: " + this.phone
            + " | PaymentMethod: " + this.paymentMethod
            + " | PaypalInvoice: " + this.paypalInvoice
            + " | Amount: " + this.amount;
        
        transactionList.add(transactionInfo);
        System.out.println("\nTransaction added successfully.");
    }

    
    public void getTransaction() {
    	if (this.transactionList.isEmpty()) {
            System.out.println("\nNo transactions available.");
        } else {
            for (String transaction : this.transactionList) {
                System.out.println(transaction);
            }
        }
    };
}
