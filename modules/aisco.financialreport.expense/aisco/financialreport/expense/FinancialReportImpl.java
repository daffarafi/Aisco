package aisco.financialreport.expense;

import aisco.financialreport.core.FinancialReportDecorator;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.core.FinancialReportComponent;
import java.util.ArrayList;
import java.util.List;

public class FinancialReportImpl extends FinancialReportDecorator {

    public FinancialReportImpl(FinancialReportComponent record) {

        super(record);
    }

    public void printHeader() {
        System.out.println("\n=== Expense Report ===");
    }

    public int total(List<FinancialReport> expenses)
    {
        int sum = record.total(expenses);
        System.out.println("Total Expense: "+sum+"\n");
        return sum;
    }

}



