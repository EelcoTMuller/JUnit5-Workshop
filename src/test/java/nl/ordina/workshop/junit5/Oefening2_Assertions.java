package nl.ordina.workshop.junit5;

import nl.ordina.workshop.junit5.service.SalarisBetaalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Oefening2_Assertions {

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
}
