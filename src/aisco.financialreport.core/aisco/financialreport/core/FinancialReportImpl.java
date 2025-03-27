package aisco.financialreport.core;
import aisco.program.core.Program;
import java.util.List;

public class FinancialReportImpl extends FinancialReportComponent {

 
    public FinancialReportImpl(String id, String dateStamp, int amount, String description, Program idProgram, String idCoa){
      super (id, dateStamp, amount, description, idProgram, idCoa);  
    }

    public void printHeader(){

        System.out.println("Financial Report");
    }

    public int total(List<FinancialReport> records){
      int sum = 0;
      for(int i = 0; i < records.size(); i++){
        int o = (records.get(i)).getAmount();
        sum = sum+o;
      }
      return sum;
    }
}








