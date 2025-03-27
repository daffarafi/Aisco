package aisco.product.hilfuns;
import aisco.program.core.Program;
import aisco.program.ProgramFactory;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.FinancialReportFactory;
import payment.product.charity.*;
import java.util.ArrayList;
import java.util.List;

public class Hilfe {
    private static final int INDEX_DISASTER = 0;
    private static final int INDEX_MEDICINE = 1;

    private static FinancialReport income1;

    public static List<Program> addProgram()
    {   
        System.out.println("\n Programs: ");
        List<Program> programs = new ArrayList<>();
        Program disasterrelief= ProgramFactory.createProgram("aisco.program.activity.ProgramImpl", 1, "Flood in Bogor", "Helping flood victims", "100 families", "Fast Furious", "https://www.hilfe.splelive.id/logohilfe");
        Program freemedicine = ProgramFactory.createProgram("aisco.program.activity.ProgramImpl", 2, "Free Medicine", "Free treatment and medicine for poor people", "50 persons", "Healthy Clinic", "https://www.hilfe.splelive.id/logopengobatan");
        programs.add(INDEX_DISASTER, disasterrelief);
        programs.add(INDEX_MEDICINE, freemedicine);
        return programs;
    }

    public static List<FinancialReport> addIncome(List<Program> programs)
    {
        List<FinancialReport> incomes = new ArrayList<>();
        income1 = FinancialReportFactory.createFinancialReport("aisco.financialreport.income.FinancialReportImpl",FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl","1", "23-11-2019", 1000000, "Donation Nadia", programs.get(INDEX_DISASTER), "42010"), "Transfer");
        incomes.add(income1);
        incomes.add(FinancialReportFactory.createFinancialReport("aisco.financialreport.income.FinancialReportImpl", FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl","2", "25-11-2019", 800000, "Donation Lentera", programs.get(INDEX_MEDICINE), "42010"), "Cash"));
        incomes.add(FinancialReportFactory.createFinancialReport("aisco.financialreport.income.FinancialReportImpl",FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl","3", "29-11-2019", 5000000, "Fundraising Mitra University", programs.get(INDEX_DISASTER), "42000"), "Transfer"));
        return incomes;
    }


    public static void main(String[] args) {
        System.out.println("Product Hilfuns");
        List<Program> programs = addProgram();
        System.out.println(programs);
        
        List<FinancialReport> incomes = addIncome(programs);
        income1.printHeader();
        System.out.println(incomes);
        int totalincome = ((aisco.financialreport.income.FinancialReportImpl)income1).total(incomes);

        PaymentCharity charity = new PaymentCharity();
        System.out.println("Balance: "+totalincome);
      
    }
}
