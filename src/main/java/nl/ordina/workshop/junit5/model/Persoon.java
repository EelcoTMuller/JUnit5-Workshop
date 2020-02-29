package nl.ordina.workshop.junit5.model;

import java.math.BigDecimal;



public class Persoon {


    private String firstName;
    private String lastName;
    private int age;
    private double salaris;
    private String bankrekening;

    public Persoon(String firstName, String lastName, int age, double salaris, String bankrekening) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salaris = salaris;
        this.bankrekening = bankrekening;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalaris() {
        return salaris;
    }

    public void setSalaris(double salaris) {
        this.salaris = salaris;
    }

    public String getBankrekening() {
        return bankrekening;
    }

    public void setBankrekening(String bankrekening) {
        this.bankrekening = bankrekening;
    }
}
