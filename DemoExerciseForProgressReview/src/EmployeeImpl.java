public abstract class EmployeeImpl implements Employee {

    private double salary;
    private String names;

    private Address address;

    private EmloyeeType type;

    public EmployeeImpl(EmloyeeType type, String names, Address address, double salary) {
        setNames(names);
        setSalary(salary);
        this.type = type;
        this.address = address;

    }

    private void setSalary(double salary) {
        if (salary < 0.10)
            throw new IllegalArgumentException("Too little money bro");

        this.salary = salary;
    }

    private void setNames(String names) {
        if (names.length() < 8 || names.length() > 40)
            throw new IllegalArgumentException("Invalid names");

        this.names = names;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }



    @Override
    public String getAddress() {
        return this.address.printAddress();
    }

    @Override
    public String getName() {
        return names;
    }
    private String str = "saasdfas";

    @Override
    public int getWorkingHours() {
        if (type == EmloyeeType.FULLTIME)
            return 8;
        return 4;
    }
    @Override
    public double getMonthlySalary() {
        if(type == EmloyeeType.FULLTIME) return (salary * 8) * 21;
        return (salary * 4) *21;
    }

    @Override
    public double getYearlySalary() {
        if(type == EmloyeeType.FULLTIME) return (salary * 8) * 252;
        return (salary * 4) *252;
    }

    public String printEmployee(){
        return String.format("""
                Names: %s
                Salary: %s
                Address: %s
                """, getName(), getSalary(), getAddress());
    }
}
