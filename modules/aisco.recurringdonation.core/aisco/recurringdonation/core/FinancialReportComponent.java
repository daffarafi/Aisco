package aisco.financialreport.core;
import aisco.program.core.Program;
import java.util.List;

public abstract class FinancialReportComponent implements FinancialReport {

    protected String idRecord;
    protected String dateStamp;
    protected int amount;
    protected String description;
    protected Program idProgram;
    protected String idCoa;
    public static int balance;
    
    public FinancialReportComponent()
    {

    }
    public FinancialReportComponent(String id, String dateStamp, int amount, String description, Program idProgram, String idCoa) {
        this.idRecord = id;
        this.dateStamp = dateStamp;
        this.amount = amount;
        this.description = description;
        this.idProgram = idProgram;
        this.idCoa = idCoa;
    }
    public String getDescription()
    {

        return description;
    }

    public int getAmount()
    {

        return amount;
    }

    public Program getProgram ()
    {

        return idProgram;
    }

    public abstract void printHeader();

    public String toString() {

        return "\n - " + description + ": " + amount + " for Program" + idProgram + "\n";
    }
    public abstract int total(List<FinancialReport> report);

}
