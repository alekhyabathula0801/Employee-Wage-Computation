import java.util.*;
public class EmpWageBuilder {
	//constants
	public static final int IS_FULL_TIME = 1;
        public static final int IS_PART_TIME = 2;
	//variables
	public int empHrs = 0;
	private int numOfCompany = 0;
	private ArrayList<CompanyEmpWage> companyEmpWageArrayList = new ArrayList<CompanyEmpWage>();
	public Map<Integer, Integer> empDailyWage = new HashMap<Integer, Integer>();
        public static Map<String, Object> empDailyWageWithCompany = new HashMap<>();
	public static HashMap<String, Integer> monthlyEmpWage = new HashMap<>();

	private void addCompanyEmpWage (String company, int empRatePerHr, int maxWorkingDays, int maxWorkingHrsPerMonth) {
		CompanyEmpWage companyEmpWageDetails = new CompanyEmpWage(company, empRatePerHr, maxWorkingDays, maxWorkingHrsPerMonth);
		companyEmpWageArrayList.add(companyEmpWageDetails);
		numOfCompany++;
	}

	private	void computeEmpWageForCompany () {
		for(int company = 0; company< numOfCompany; company++ ) {
			int totalEmpWage = this.computeEmpWageForCompany(companyEmpWageArrayList.get(company));
			monthlyEmpWage.put(companyEmpWageArrayList.get(company).company, totalEmpWage);
                }
	}

        public  int computeEmpWageForCompany (CompanyEmpWage companyEmpWage) {
		int totalEmpHrs = 0, day = 1;
                while (day <= companyEmpWage.maxWorkingDays && totalEmpHrs < companyEmpWage.maxWorkingHrsPerMonth) {
                        getWorkingHrs();
			empDailyWage.put(day, (empHrs * companyEmpWage.empRatePerHr));
                        totalEmpHrs += empHrs;
                        day++;
                }
		empDailyWageWithCompany.put(companyEmpWage.company, empDailyWage);
		empDailyWage = new HashMap<Integer, Integer>();
           	return (totalEmpHrs * companyEmpWage.empRatePerHr);
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

	public void listOfCompanies () {
		System.out.println("List of companies");
                for(String key : monthlyEmpWage.keySet()) {
                	System.out.println(key);
                }
		System.out.println("Please enter valid company name from the list");
	}

	public void getTotalEmpWage (String companyName) {
		try {
			if ( companyName.length() == 0 ) {
                                System.out.println("Entered empty");
				listOfCompanies();
			} else if ( monthlyEmpWage.get(companyName) != null ) {
				int totalWage = (int)monthlyEmpWage.get(companyName);
                	        System.out.println(companyName +" Employee wage for a month is " + totalWage);
                	} else {
				System.out.println("Entered invalid company name");
				listOfCompanies();
                	}
		} catch (NullPointerException e) {
			System.out.println("Entered Null");
			listOfCompanies();
		}
	}

	public static void main (String[] args) {
		EmpWageBuilder empWageBuilder = new  EmpWageBuilder();
                empWageBuilder.addCompanyEmpWage("Amazon",15,8,8);
		empWageBuilder.addCompanyEmpWage("DMart",20,5,10);
                empWageBuilder.addCompanyEmpWage("Reliance",10,3,12);
		empWageBuilder.addCompanyEmpWage("Starbucks",30,2,8);
		empWageBuilder.addCompanyEmpWage("McDonald's",20,4,16);

		empWageBuilder.computeEmpWageForCompany();

		System.out.println(": Daily employee wage :");
		System.out.println(empDailyWageWithCompany);

		empWageBuilder.getTotalEmpWage("Starbucks");
		empWageBuilder.getTotalEmpWage("DMart");
		empWageBuilder.getTotalEmpWage("Reliance");
		empWageBuilder.getTotalEmpWage("Amazon");
		empWageBuilder.getTotalEmpWage("McDonald's");
		empWageBuilder.getTotalEmpWage("reliance");
		empWageBuilder.getTotalEmpWage("");
		empWageBuilder.getTotalEmpWage(null);
	}
}
