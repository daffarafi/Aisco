package aisco.financialreport.income;

import aisco.financialreport.core.FinancialReportDecorator;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.core.FinancialReportComponent;
import java.util.ArrayList;
import java.util.List;

public class FinancialReportImpl extends FinancialReportDecorator {
    // delta add attributes
    private String paymentMethod;
    
    // delta adds attributes, modifies the constructor
    public FinancialReportImpl(FinancialReportComponent record, String paymentMethod) {
        super(record);
        this.paymentMethod = paymentMethod;
    }

    // delta adds method
    public double adminfee(List<FinancialReport> incomes)
    {
        double fee=0;
        for(int i = 0; i < incomes.size(); i++){
            fee = fee+(0.01*incomes.get(i).getAmount());
        }
        return fee;
    }
    public String getPaymentMethod()
    {
        return paymentMethod;
    }

    // delta modifies method
    public void printHeader()
    {   
        System.out.println("\n=== Income Report ===");
    }

    public String toString() {
        return "" + record +  "Payment Method: " + paymentMethod + ".";
    }

    public int total(List<FinancialReport> incomes)
    {
        int sum =  record.total(incomes);
        int fee =  (int) adminfee(incomes);
        System.out.println("Total Income: "+sum+"\nAdmin Fee: "+fee);
        return (sum-fee);
    }
}