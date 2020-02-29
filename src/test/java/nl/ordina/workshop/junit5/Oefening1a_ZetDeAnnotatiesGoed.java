package nl.ordina.workshop.junit5;

import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
  Fill in the annotations so the test runs correctly

Test 1 did run!


Test 2 did run!

Total of 2 tests did run!
 */

public class Oefening1a_ZetDeAnnotatiesGoed {

    /**
     * (1) Place all annotations on right place
     */

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
}
