package nearsoft.unitthree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;

@RunWith(JUnit4.class)
public class HashMapTest {

    private HashMap<String, String> map;
    final String key = "key";
    final String value = "value";

    @Before
    public void setUp(){
        map = new HashMap<String, String>();
        map.put(key,value);
    }


    @Test
    public void testPutMethod(){
        Assert.assertSame(value, map.get(key));
    }

    @Test
    public void replace(){

        final String secondValue = "value2";
        map.put(key, secondValue);
        Assert.assertSame(secondValue, map.get(key));
    }

    @Test
    public void testClearMethod(){

        map.clear();
        Assert.assertNull(map.get(key));
        Assert.assertTrue( map.size() == 0);
    }

    @Test
    public void testNullKey(){

        final String someValue = "something";
        map.put(null, someValue);
        Assert.assertSame(someValue, map.get(null));
    }

}
