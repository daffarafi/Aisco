package aisco.donation.core;

public abstract class DonationComponent implements Donation
{
    protected String name;
    protected String email;
    protected String phone;
    protected int amount;
    protected String paymentMethod;

    public DonationComponent()
    {
    }

    public DonationComponent (String name, String email, String phone, int amount, String paymentMethod)
    {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public abstract void addDonation();
    public abstract void getDonation();

}