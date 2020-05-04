public class CompanyEmpWage {
        public final String company;
        public final int empRatePerHr;
        public final int maxWorkingDays;
        public final int maxWorkingHrsPerMonth;

        public CompanyEmpWage (String company, int empRatePerHr, int maxWorkingDays, int maxWorkingHrsPerMonth) {
                this.company = company;
                this.empRatePerHr = empRatePerHr;
                this.maxWorkingDays = maxWorkingDays;
                this.maxWorkingHrsPerMonth = maxWorkingHrsPerMonth;
        }
}
