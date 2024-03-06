package entities;

public class TaxPayer {

    private Double salaryIncome;
    private Double servicesIncome;
    private Double capitalIncome;
    private Double healthSpending;
    private Double educationSpending;

    public TaxPayer(){
    }
    public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending, Double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public Double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(Double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public Double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(Double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public Double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(Double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public Double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(Double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public Double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(Double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public Double salaryTax() {
        double monthlySalary = salaryIncome / 12;
        double salaryTax = 0.0;

        if (monthlySalary < 3000.0) {
            salaryTax = 0.0;
        } else if (monthlySalary < 5000.0) {
            salaryTax = salaryIncome * 0.1;
        }
        else {
            salaryTax = salaryIncome * 0.2;
        }
        return salaryTax;
    }

    public Double servicesTax() {
        return servicesIncome * 0.15;
    }
    public Double capitalTax() {
        return capitalIncome * 0.20;
    }
    public Double grossTax() {
        return salaryTax() + servicesTax() + capitalTax();
    }
    public Double taxRebate() {
        double maxDeductible = grossTax() * 0.30;
        double deductibleExpenses = healthSpending + educationSpending;
        return (deductibleExpenses > maxDeductible) ? maxDeductible : deductibleExpenses;
    }
    public Double netTax() {
       return grossTax() - taxRebate();
    }

    @Override
    public String toString() {
        return "\nImposto bruto total: " + String.format("%.2f", grossTax()) +
                "\nAbatimento: " + String.format("%.2f", taxRebate()) +
                "\nImposto devido: " + String.format("%.2f", netTax());
    }
}
