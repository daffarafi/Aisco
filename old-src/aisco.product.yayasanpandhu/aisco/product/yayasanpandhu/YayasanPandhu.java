package aisco.product.yayasanpandhu;

import aisco.program.core.Program;
import aisco.program.ProgramFactory;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.FinancialReportFactory;

import java.util.ArrayList;
import java.util.List;

public class YayasanPandhu {
    private static final int INDEX_GIFTS = 0;
    private static final int INDEX_ORPH = 1;

    private static FinancialReport income2;
    private static FinancialReport expense1;

    public static List<Program> addProgram()
    {   
        List<Program> programs = new ArrayList<>();
        Program sharegifts = ProgramFactory.createProgram("aisco.program.activity.ProgramImpl",1, "Share Gifts", "Sharing gifts to slum area", "50 persons", "Pandhu Volunteer", "https://www.yaysanpandhu.splelive.id/pandhu.jpg");
        Program orphanagecompetition = ProgramFactory.createProgram("aisco.program.activity.ProgramImpl",2, "Orphanage Competition", "Competition of Orphanage in Karawang", "30 orphanages", "Government", "https://www.yaysanpandhu.splelive.id/panti.jpg");
        Program withcategory = ProgramFactory.createProgram("aisco.program.category.ProgramImpl", sharegifts, "Program Dhuafa");
        programs.add(INDEX_GIFTS,sharegifts);
        programs.add(INDEX_ORPH, orphanagecompetition);
        return programs;
    }

    public static List<FinancialReport> addIncome(List<Program> programs)
    { 
        List<FinancialReport> incomes = new ArrayList<>();
        FinancialReport core1 = FinancialReportFactory.createFinancialReport
        ("aisco.financialreport.core.FinancialReportImpl","1", "12-11-2019", 2500000, 
        "Donation from Society", programs.get(INDEX_GIFTS), "11000");
        FinancialReport income1 = FinancialReportFactory.createFinancialReport
        ("aisco.financialreport.income.FinancialReportImpl", core1, "Cash");
        FinancialReport freq1 = FinancialReportFactory.createFinancialReport
        ("aisco.financialreport.incomewithfrequency.FinancialReportImpl",income1, "Monthly");
        incomes.add(freq1);

       income2= FinancialReportFactory.createFinancialReport("aisco.financialreport.income.FinancialReportImpl",
       FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl","2", "13-11-2019",
        300000, "Donation Raden", programs.get(INDEX_ORPH), "11000"), "Transfer");
       incomes.add(income2);
       incomes.add(FinancialReportFactory.createFinancialReport("aisco.financialreport.income.FinancialReportImpl",
       FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl","3", "14-11-2019",
       500000, "Donation Anonim", programs.get(INDEX_GIFTS), "110"), "Transfer"));

        // //Try DFrequency first and then DIncome
        // FinancialReport core2 = FinancialReportFactory.createFinancialReport
        // ("aisco.financialreport.core.FinancialReportImpl","2", "13-11-2019", 300000,
        // "Donation Raden", orphanagecompetition, "11000");
        // FinancialReport freq2 = FinancialReportFactory.createFinancialReport
        // ("aisco.financialreport.frequency.FinancialReportImpl",core2, "Monthly");
        // FinancialReport income2 = FinancialReportFactory.createFinancialReport
        // ("aisco.financialreport.income.FinancialReportImpl", freq2, "Cash");
        // incomes.add(income2);
        // //freq2.printHeader(); //original() call, output "FinancialReport"
        return incomes;
    }   

    public static List<FinancialReport> addExpense(List<Program> programs)
    {
        List<FinancialReport> expenses = new ArrayList<>();
        expense1 =FinancialReportFactory.createFinancialReport("aisco.financialreport.expense.FinancialReportImpl",FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl","10", "28-04-2020", 1000000, "Story Books", programs.get(INDEX_GIFTS), "50200"));
        FinancialReport freq2 = FinancialReportFactory.createFinancialReport
        ("aisco.financialreport.expensewithfrequency.FinancialReportImpl",expense1, "Yearly");
        expenses.add(freq2);

        FinancialReport expense2 =FinancialReportFactory.createFinancialReport("aisco.financialreport.expense.FinancialReportImpl",FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl","10", "12-12-2020", 500000, "Vitamins", programs.get(INDEX_ORPH), "50200"));
        FinancialReport freq3 = FinancialReportFactory.createFinancialReport("aisco.financialreport.expensewithfrequency.FinancialReportImpl",expense2, "Monthly");
        expenses.add(freq3);
        return expenses;
    }

    public static void main(String[] args) {
        System.out.println("Product Yayasan Pandhu");

        List<Program> programs = addProgram();
        System.out.println(programs);

        List<FinancialReport> incomes = addIncome(programs);
        income2.printHeader();
        System.out.println(incomes);
        int totalincome = income2.total(incomes);
        
        List<FinancialReport> expenses = addExpense(programs);
        expense1.printHeader();
        System.out.println(expenses);
        int totalexpense = expense1.total(expenses);
        int balance = totalincome-totalexpense;
        System.out.println("Balance: "+balance);
    
    }
}
