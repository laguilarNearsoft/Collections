package nearsoft.unitthree;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(JUnit4.class)
public class ReverseTest {

    @Test(expected = IllegalStateException.class)
    public void reverseStringTest(){
        final String reversedString = Reverse.reverse(null);
    }
}
