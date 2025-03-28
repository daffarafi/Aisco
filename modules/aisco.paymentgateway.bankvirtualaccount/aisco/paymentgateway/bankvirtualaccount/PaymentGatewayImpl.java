package aisco.paymentgateway.bankvirtualaccount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import aisco.paymentgateway.core.*;

public class PaymentGatewayImpl extends PaymentGatewayDecorator {
    protected String bankCode;
    protected String virtualAccountNumber;

    public PaymentGatewayImpl(String name, String email, String phone, int amount, String bankCode) {
        super();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.amount = amount;
        this.paymentMethod = "BankVirtualAccount";
        this.bankCode = bankCode;
        this.generateVA();
    }

    public void generateVA() {
        // Format: BANKCODE + yyMMddHHmmss + random 3-digit
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String timeStamp = LocalDateTime.now().format(formatter);
        int randomDigits = new Random().nextInt(900) + 100; // 100–999
        this.virtualAccountNumber = bankCode + timeStamp + randomDigits;
    }

    public void addTransaction() {
        String transactionInfo = " | Name: " + this.name
            + " | Email: " + this.email
            + " | Phone: " + this.phone
            + " | PaymentMethod: " + this.paymentMethod
            + " | BankCode: " + this.bankCode
            + " | VirtualAccountNumber: " + this.virtualAccountNumber
            + " | Amount: " + this.amount;
        
        transactionList.add(transactionInfo);
        System.out.println("\nTransaction added successfully.");
    }
}