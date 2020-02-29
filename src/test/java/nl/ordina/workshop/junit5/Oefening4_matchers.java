package nl.ordina.workshop.junit5;

import nl.ordina.workshop.junit5.model.Persoon;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Oefening4_matchers {

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
