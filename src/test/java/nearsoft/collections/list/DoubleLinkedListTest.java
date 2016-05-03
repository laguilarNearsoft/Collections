package nearsoft.collections.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by laguilar on 5/2/16.
 */
public class DoubleLinkedListTest {

    @Test
    public void addOperationTest(){

        DoubleLinkedList<Long> linkedList = new DoubleLinkedList<Long>();

        final Long cero = new Long(1);

        linkedList.add(cero);
        Assert.assertEquals(cero, linkedList.get(0));
    }

    @Test
    public void getOperationTest(){

        DoubleLinkedList<Long> linkedList = new DoubleLinkedList<Long>();

        final Long cero = new Long(1);
        final Long one = new Long(2);
        final Long two = new Long(3);

        linkedList.add(cero);
        linkedList.add(one);
        linkedList.add(two);

        Assert.assertEquals(cero, linkedList.get(0));
        Assert.assertEquals(one, linkedList.get(1));
        Assert.assertEquals(two, linkedList.get(2));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOperationOutOfBoundsTest(){

        DoubleLinkedList<Long> linkedList = new DoubleLinkedList<Long>();

        final Long cero = new Long(1);
        final Long one = new Long(2);
        final Long two = new Long(3);

        linkedList.add(cero);
        linkedList.add(one);
        linkedList.add(two);

        Assert.assertEquals(two, linkedList.get(3));

    }

    @Test
    public void addAtIndexOperationTest(){

        DoubleLinkedList<Long> linkedList = new DoubleLinkedList<Long>();

        final Long cero = new Long(0);
        final Long one = new Long(1);
        final Long two = new Long(2);
        final Long three = new Long(3);
        final Long four = new Long(4);

        linkedList.add(cero);
        linkedList.add(one);
        linkedList.add(two);
        linkedList.add(three);
        linkedList.add( 3, four);

        Assert.assertEquals(cero, linkedList.get(0));
        Assert.assertEquals(one, linkedList.get(1));
        Assert.assertEquals(two, linkedList.get(2));
        Assert.assertEquals(four, linkedList.get(3));

    }


    @Test
    public void deleteOperationTest(){

        DoubleLinkedList<Long> linkedList = new DoubleLinkedList<Long>();

        final Long cero = new Long(0);
        final Long one = new Long(1);
        final Long two = new Long(2);
        final Long three = new Long(3);

        linkedList.add(cero);
        linkedList.add(one);
        linkedList.add(two);
        linkedList.add(three);

        Assert.assertNotNull( linkedList.search(two) );

        linkedList.delete(two);
        Assert.assertNull(linkedList.search(two));
    }


    @Test
    public void deleteByIndexOperationTest(){

        DoubleLinkedList<Long> linkedList = new DoubleLinkedList<Long>();

        final Long cero = new Long(0);
        final Long one = new Long(1);
        final Long two = new Long(2);
        final Long three = new Long(3);

        linkedList.add(cero);
        linkedList.add(one);
        linkedList.add(two);
        linkedList.add(three);

        Assert.assertNotNull( linkedList.search(two) );

        linkedList.delete(2);
        Assert.assertNull(linkedList.search(two));
    }


}
