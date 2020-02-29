package nl.ordina.workshop.junit5.service;

import nl.ordina.workshop.junit5.model.AgeValidator;
import nl.ordina.workshop.junit5.model.Persoon;

import java.util.List;
import java.util.stream.Collectors;

public class SalarisBetaalService {

    private AgeValidator ageValidator = new AgeValidator();

    public List<Persoon> betaalSalaris(List<Persoon> personen){
        if (personen==null){
            throw new IllegalArgumentException("empty list not allowed");
        }
        return personen.stream().filter(ageValidator).collect(Collectors.toList());

    }


}
