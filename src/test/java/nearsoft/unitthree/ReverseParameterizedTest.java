package nearsoft.unitthree;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ReverseParameterizedTest {

    private String stringToReverse;
    private String expectedReversedString;

    public ReverseParameterizedTest(String input, String expected) {
        this.stringToReverse = input;
        this.expectedReversedString = expected;
    }

    @Parameterized.Parameters
    public static final Collection<Object[]> getString(){
        return Arrays.asList(new Object[] []{
                {"hello word","drow olleh"},
                {"",""},
                {"   ","   "},
                {"123!@# 321!@#","#@!123 #@!321"}
        });
    }

    @Test
    public void reverseStringTest(){
        final String reversedString = Reverse.reverse(stringToReverse);
        Assert.assertEquals(expectedReversedString, reversedString);
    }
}
