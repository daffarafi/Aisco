package aisco.financialreport.core;
import aisco.program.core.Program;
import java.util.List;

public interface FinancialReport {
    int getAmount();
    void printHeader();
    int total(List<FinancialReport> report);
}
