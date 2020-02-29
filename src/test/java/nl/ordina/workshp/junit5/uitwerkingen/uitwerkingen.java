package nl.ordina.workshp.junit5.uitwerkingen;

import nl.ordina.workshop.junit5.PersoonArgumentProvider;
import nl.ordina.workshop.junit5.model.AgeValidator;
import nl.ordina.workshop.junit5.model.Occupation;
import nl.ordina.workshop.junit5.model.Persoon;
import nl.ordina.workshop.junit5.service.SalarisBetaalService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class uitwerkingen {

    private static int aantalKerenBeforeAll;
    private int aantalKerenBeforeEach;
    private static int aantalTestsRun;

    @BeforeAll
    static void setUpBeforeAll(){
        aantalKerenBeforeAll++;
    }

    @BeforeEach
    void aantalKerenBeforeEach(){
        aantalKerenBeforeEach++;
    }

    //the test must be displayed like 'is de data goed geinitialiseerd'
    @Test
    void testDataDeTestGoedIsGeinitialiseerd(){
        assertThat("aantal keren setUpBeforeAll onjuist",aantalKerenBeforeAll, is(1));
    }

    @Test
    void testTrueisTrue(){
        assertTrue(true);
    }

    @AfterEach
    void showWhichTestsDidRun(){
        aantalTestsRun++;
        System.out.println("Test " + aantalTestsRun +" did run!");
    }

    @AfterAll
    static void showHowManyTestsDidRun(){

        System.out.println("Total of " + aantalTestsRun +" tests did run!");
    }

    private SalarisBetaalService service;

    /**
     * initialize correctly
     */
    @BeforeEach
    void  setup(){
        service = new SalarisBetaalService();
    }

    /**
     * (3) Test the IllegalArgumentException of the SalarisBetaalService, make a test for the message
     */
    @Test
    void testExceptions(){
        IllegalArgumentException illegalArgumentException =Assertions.assertThrows(IllegalArgumentException.class,()->service.betaalSalaris(null));
        assertThat("", illegalArgumentException.getMessage(), is("empty list not allowed"));
    }

    /**
     * (4) The next test must fail, and all assertions should be hit
     */
    @Test
    void allAssertionMustGoOf(){
        assertAll(
                ()-> assertThat("this should be equal", 2, is(3)),
                ()->assertThat("this should be equal", 3, is(4)),
                ()->assertThat("this should be equal", 5, is(6))

        );
    }

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

    /** (8) matcher containsInAnyOrder
     javadoc: public static <T> Matcher<java.lang.Iterable<? extends T>> containsInAnyOrder(T... items)
     */
    @Test
    void  testExampleAllin(){

        List<String> groep1 = Arrays.asList("1", "2", "3");
        assertThat("Containing different elements", groep1, containsInAnyOrder("2", "3", "1"));
    }

    /** (9) matchesRegex
     * test your own dutch zipcode with the matchesRegex from hamcrest
     * regex = ^\d{4}\s?\w{2}$
     */
    @Test
    void testWithMatcherRegex(){
        assertThat("1234 AB", matchesRegex(Pattern.compile("^\\d{4}\\s?\\w{2}$")));
    }
    /** (10)
     * test has property with value
     * javadoc method: hasProperty(java.lang.String propertyName, Matcher<?> valueMatcher)
     */
    @Test
    void testWithMatcherHasProperty(){
        Persoon persoon = new Persoon("Jan", "Jansen", 25, 100, "123456");
        //Test persoon has property firstName with value Jan
        assertThat(persoon, hasProperty("firstName", is("Jan")));
    }


}
