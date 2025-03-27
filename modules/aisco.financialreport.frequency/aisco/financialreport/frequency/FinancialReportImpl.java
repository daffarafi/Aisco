package aisco.financialreport.frequency;

import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.core.FinancialReportDecorator;
import aisco.financialreport.core.FinancialReportComponent;
import aisco.financialreport.frequency.DFrequency;


public class FinancialReportImpl extends DFrequency {
    
    public FinancialReportImpl(FinancialReportComponent record, String frequency) {
        super (record, frequency);
    }
}


