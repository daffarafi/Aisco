package aisco.paymentgateway.phonenumberewallet;

import aisco.paymentgateway.core.*;

public class PaymentGatewayImpl extends PaymentGatewayDecorator {
    
    protected String ewalletPhoneNumber;
    protected String walletType;

    public PaymentGatewayImpl(String name, String email, String phone, int amount, String ewalletPhoneNumber, String walletType) {
        super();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.amount = amount;
        this.paymentMethod = "PhoneNumberEWallet";
        this.ewalletPhoneNumber = ewalletPhoneNumber;
        this.walletType = walletType;
    }

    public void addTransaction() {
        String transactionInfo = " | Name: " + this.name
            + " | Email: " + this.email
            + " | Phone: " + this.phone
            + " | PaymentMethod: " + this.paymentMethod
            + " | EwalletPhoneNumber: " + this.ewalletPhoneNumber
            + " | WalletType: " + this.walletType
            + " | Amount: " + this.amount;
        
        transactionList.add(transactionInfo);
        System.out.println("\nTransaction added successfully.");
    }
}