package nl.ordina.workshop.junit5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Oefening1b_ConvertAJunit4Test {

    /**
     * (2) Convert the test to Junit5 and remove the dependency
     */

    private String testData;

    @Before
    public void setup(){
        this.testData = "Hallo allemaal";
    }


    @Test
    public void testAllIsRight(){
        assertThat("",  this.testData, is("Hallo allemaal"));
    }

    @After
    public void goodbye(){
        System.out.println("Goodbye everyone");
    }


}
