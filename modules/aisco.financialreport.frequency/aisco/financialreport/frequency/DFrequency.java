package aisco.financialreport.frequency;

import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.core.FinancialReportDecorator;
import aisco.financialreport.core.FinancialReportComponent;
import java.util.List;

public abstract class DFrequency extends FinancialReportDecorator {
    // delta add attributes
    private String frequency;

    // delta adds attributes, modifies the constructor
    public DFrequency(FinancialReportComponent record, String frequency) {
        super(record);
        this.frequency = frequency;
    }

     public String toString() {
        return record + " Frequency: " +frequency + ".";
     }

    // delta original call
    public void printHeader()
    {
        record.printHeader();
    }  

    public int total(List<FinancialReport> report)
    {
        int sum = record.total(report);
        return sum;
    }
}


