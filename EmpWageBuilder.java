public class EmpWageBuilder {
	public final int IS_FULL_TIME = 1;
        public final int IS_PART_TIME = 2;
	public int empHrs = 0;
	public final String company;
        public final int empRatePerHr;
	public final int maxWorkingDays;
	public final int maxWorkingHrsPerMonth;

	public EmpWageBuilder (String company, int empRatePerHr, int maxWorkingDays, int maxWorkingHrsPerMonth) {
		this.company = company;
		this.empRatePerHr = empRatePerHr;
		this.maxWorkingDays = maxWorkingDays;
		this.maxWorkingHrsPerMonth = maxWorkingHrsPerMonth;
	}

	public int computeEmpWageForCompany () {
                int totalEmpHrs = 0, day = 1;
                while (day <= maxWorkingDays && totalEmpHrs < maxWorkingHrsPerMonth) {
                        getWorkingHrs();
                        totalEmpHrs += empHrs;
                        day++;
                }
                int totalEmpWage = totalEmpHrs * empRatePerHr;
		System.out.println(company +" Employee wage for a month is " + totalEmpWage);
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
		EmpWageBuilder dMart = new  EmpWageBuilder("DMart",20,2,10);
		dMart.computeEmpWageForCompany();
		EmpWageBuilder reliance = new  EmpWageBuilder("Reliance",10,4,20);
		reliance.computeEmpWageForCompany();
        }
}
