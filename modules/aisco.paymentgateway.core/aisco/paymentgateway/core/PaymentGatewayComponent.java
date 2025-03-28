package aisco.paymentgateway.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class PaymentGatewayComponent implements PaymentGateway {
	
	protected String name;
	protected String email;
	protected String phone;
	protected int amount;
	protected String paymentMethod;
    
    public PaymentGatewayComponent()
    {

    }
    public PaymentGatewayComponent(String name, String email, String phone, int amount, String paymentMethod) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }
    
    public void addTransaction() {
        System.out.println("Transaction added successfully.");
    }
   

    protected List<String> transactionList = new ArrayList<>();

    public void getTransaction() {
    	if (transactionList.isEmpty()) {
            System.out.println("\nNo transactions available.");
        } else {
            for (String transaction : transactionList) {
                System.out.println(transaction);
            }
        }
    };
   
    public String getName() {
    	return this.name;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public String getPhone() {
    	return this.phone;
    }
    
    public int getAmount() {
    	return this.amount;
    }
    
    public String getPaymentMethod() {
    	return this.paymentMethod;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setPaymentMethod(String paymentMethod) {
    	this.paymentMethod = paymentMethod;
    }
}
