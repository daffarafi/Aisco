package aisco.financialreport.core;

import aisco.program.core.Program;
import java.util.ArrayList;
import java.util.List;

public abstract class FinancialReportDecorator extends FinancialReportComponent {
    public FinancialReportComponent record;

    public FinancialReportDecorator (FinancialReportComponent record) {
        this.record = record;
    }

    public int getAmount()
    {
        return record.getAmount();
    }

    public String getDescription()
    {
        return record.getDescription();
    }

    public Program getProgram ()
    {

        return record.getProgram();
    }


    public abstract void printHeader();

    public String toString() {
        return "\n - " + record.getDescription() + ": " + record.getAmount() + " for Program" + record.getProgram() + ".\n";
    }

    /* delta adds method */
    public void totalAmount() {
        System.out.println("Balance is "+balance);
    }
}
