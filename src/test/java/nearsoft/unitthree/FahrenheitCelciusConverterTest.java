package nearsoft.unitthree;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FahrenheitCelciusConverterTest {

    private int celcius;
    private int fahrenheit;

    public FahrenheitCelciusConverterTest(int celcius, int fahrenheit) {
        this.celcius = celcius;
        this.fahrenheit = fahrenheit;
    }

    @Parameterized.Parameters
    public static final Collection<Object[]> getString(){
        return Arrays.asList(new Object[] []{
                {32, 0}, {104, 40}, {212, 100}
        });
    }

    @Test
    public void shouldConvertCelciusToFahrenheit() {
        assertEquals(celcius, FahrenheitCelciusConverter.toFahrenheit(fahrenheit));
        assertEquals(fahrenheit, FahrenheitCelciusConverter.toCelcius(celcius));
    }
}
