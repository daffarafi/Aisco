package aisco.donation.pgateway;
import aisco.donation.core.DonationComponent;
import payment.page.core.*;
import payment.page.PaymentPageFactory;

public class DonationImpl extends DonationComponent {
    PaymentPage payment;

    public DonationImpl() {
        System.out.println("\nDonation via Payment Gateway");
        payment = PaymentPageFactory.createPaymentPage("payment.page.core.PaymentPageImpl");
    }

    public void getDonation(){ 

        payment.getTransaction();
    }

    public void addDonation(){

        payment.addTransaction();
    }

}
