package nl.ordina.workshop.junit5.model;

import java.util.function.Predicate;

public class AgeValidator implements Predicate<Persoon> {
    @Override
    public boolean test(Persoon persoon) {
        return (persoon.getAge() >= 18  && persoon.getAge() < 68);
    }
}
