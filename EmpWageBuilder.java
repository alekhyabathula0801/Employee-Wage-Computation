import java.util.*;
public class EmpWageBuilder {
	public static final int IS_FULL_TIME = 1;
        public static final int IS_PART_TIME = 2;

	public int empHrs = 0;
	private int numOfCompany = 0;
	private ArrayList<CompanyEmpWage> companyEmpWageArrayList = new ArrayList<CompanyEmpWage>();

	private void addCompanyEmpWage (String company, int empRatePerHr, int maxWorkingDays, int maxWorkingHrsPerMonth) {
		CompanyEmpWage companyEmpWageDetails = new CompanyEmpWage(company, empRatePerHr, maxWorkingDays, maxWorkingHrsPerMonth);
		companyEmpWageArrayList.add(companyEmpWageDetails);
		numOfCompany++;
	}

	private	void computeEmpWageForCompany () {
		for(int company = 0; company< numOfCompany; company++ ) {
			int totalEmpWage = this.computeEmpWageForCompany(companyEmpWageArrayList.get(company));
                }
	}

        public  int computeEmpWageForCompany (CompanyEmpWage companyEmpWage) {
		int totalEmpHrs = 0, day = 1;
                while (day <= companyEmpWage.maxWorkingDays && totalEmpHrs < companyEmpWage.maxWorkingHrsPerMonth) {
                        getWorkingHrs();
                        totalEmpHrs += empHrs;
                        day++;
                }
           		int totalEmpWage = totalEmpHrs * companyEmpWage.empRatePerHr;
			System.out.println(companyEmpWage.company +" Employee wage for a month is " + totalEmpWage);
		return totalEmpWage;
	}

        public void getWorkingHrs () {
		int empCheck = (int) Math.floor(Math.random() * 10) % 3;
                switch (empCheck) {
                case IS_FULL_TIME:
                        empHrs = 8;
                        break;
                case IS_PART_TIME:
                        empHrs = 4;
                        break;
                default :
                        empHrs = 0;
                        break;
                }
	}

	public static void main (String[] args) {
		EmpWageBuilder empWageBuilder = new  EmpWageBuilder();
                empWageBuilder.addCompanyEmpWage("Amazon",15,22,70);
		empWageBuilder.addCompanyEmpWage("DMart",20,15,60);
                empWageBuilder.addCompanyEmpWage("Reliance",10,25,100);
		empWageBuilder.addCompanyEmpWage("STAR BUCKS",30,20,80);
		empWageBuilder.addCompanyEmpWage("McDonald's",20,24,100);
		empWageBuilder.computeEmpWageForCompany();
	}
}
