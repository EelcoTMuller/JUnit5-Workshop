package nl.ordina.workshop.junit5;

import nl.ordina.workshop.junit5.model.AgeValidator;
import nl.ordina.workshop.junit5.model.Occupation;
import nl.ordina.workshop.junit5.model.Persoon;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Oefening3_argumenten {


    /**
     * (5) Use PersoonArgumentProvider to test every item
     */
    @ParameterizedTest
    @ArgumentsSource(PersoonArgumentProvider.class)
    void testAllPersons(Persoon person){
       assertNotNull(person.getBankrekening());
    }

    /**
     * (6) Make the test parameterized use the file argumentresultaat.csv
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/leeftijdresultaat.csv", numLinesToSkip = 1)
    void testAgeValidator(int age, boolean resultaat){
        Persoon persoon = new Persoon("","",age, 0.0, null);
        AgeValidator validator = new AgeValidator();
         //Add Assertion
        assertThat("wrong result agevalidator", validator.test(persoon), is(resultaat));
    }

    /**
     * (7) Test the occupation enumeration
     */
    @ParameterizedTest
    @EnumSource(Occupation.class)
    void testAllMaxSalariesGreaterThanZero(Occupation occupation){
        assertThat(occupation.getMaxSalary(),greaterThan(0));
    }

}
