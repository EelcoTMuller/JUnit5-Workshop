package nl.ordina.workshop.junit5;

import nl.ordina.workshop.junit5.model.Persoon;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import java.util.stream.Stream;

public class PersoonArgumentProvider implements ArgumentsProvider{


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                new Persoon("Pipo", "de Clown", 50, 3.15, "1234567"),
                new Persoon("Doris", "Day", 90, 3000, "999999999"),
                new Persoon("Lady", "Gaga", 40, 10000, "33333333"),
                new Persoon("Flip", "Flipsen", 33, 200, "111111"),
                new Persoon("Jantje", "Klaassen", 5, 20, "444444444")
                ).map(Arguments::of);
    }


}
