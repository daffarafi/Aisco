module aisco.product.charityschool {
    requires aisco.program.core;
    requires aisco.financialreport.core;
    requires aisco.donation.core;
    
    requires aisco.program.activity;
    requires aisco.program.operational;

    requires aisco.financialreport.income;
    requires aisco.financialreport.expense;
    
    requires aisco.donation.pgateway;
}