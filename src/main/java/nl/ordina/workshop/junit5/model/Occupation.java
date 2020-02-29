package nl.ordina.workshop.junit5.model;

public enum Occupation {

    TEACHER(1000),
    STUDENT(50),
    BUSDRIVER(500),
    CLERK(1500),
    GENERAL_MANAGER(2000);


    private final int maxSalary;
    Occupation(int maxSalary){
        this.maxSalary = maxSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }
}
