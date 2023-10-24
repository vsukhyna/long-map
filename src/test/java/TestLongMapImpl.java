import de.comparus.opensource.longmap.LongMap;
import de.comparus.opensource.longmap.LongMapImpl;
import org.junit.Assert;
import org.junit.Test;

public class TestLongMapImpl {

    @Test
    public void testPut() {

        LongMap<String> stringMap = new LongMapImpl<>();

        Assert.assertEquals(0, stringMap.size());

        String strValue = "Hello, Сomparus!";
        stringMap.put(1, strValue);

        Assert.assertEquals(strValue, stringMap.get(1));
        Assert.assertEquals(1, stringMap.size());

        LongMap<Integer> integerMap = new LongMapImpl<>();

        Assert.assertEquals(0, integerMap.size());

        Integer intValue = 3000;
        integerMap.put(1, intValue);

        Assert.assertEquals(intValue, integerMap.get(1));
        Assert.assertEquals(1, integerMap.size());
    }

    @Test
    public void testGet() {

        LongMap<String> map = new LongMapImpl<>();

        long key = 25;
        String value = "how";

        map.put(key, value);

        Assert.assertEquals(value, map.get(key));
    }

    @Test
    public void testRemove() {

        LongMap<String> map = new LongMapImpl<>();

        map.put(1, "are");

        Assert.assertEquals("are", map.remove(1L));
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void testIsEmpty() {

        LongMap<String> map = new LongMapImpl<>();

        Assert.assertTrue(map.isEmpty());

        map.put(1, "you?");

        Assert.assertFalse(map.isEmpty());
    }

    @Test
    public void testContainsKey() {

        LongMap<Integer> map = new LongMapImpl<>();

        map.put(100, 200);

        Assert.assertTrue(map.containsKey(100));
    }

    @Test
    public void testContainsValue() {

        LongMap<String> map = new LongMapImpl<>();

        map.put(1, ":)");

        Assert.assertTrue(map.containsValue(":)"));
        Assert.assertFalse(map.containsValue(":("));
    }

    @Test
    public void testKeys() {

        LongMap<String> map = new LongMapImpl<>();

        map.put(1, "One");
        map.put(2, "Two");

        long[] expectedKeys = {1, 2};
        Assert.assertArrayEquals(expectedKeys, map.keys());
    }

    @Test
    public void testValues() {

        LongMap<String> map = new LongMapImpl<>();

        map.put(1, "One");
        map.put(2, "Two");

        String[] expectedValues = {"One", "Two"};
        Assert.assertArrayEquals(expectedValues, map.values());
    }

    @Test
    public void testSize() {

        LongMap<String> map = new LongMapImpl<>();

        Assert.assertEquals(0, map.size());

        map.put(10, "88");

        Assert.assertEquals(1, map.size());
    }

    @Test
    public void testClear() {

        LongMap<String> map = new LongMapImpl<>();

        map.put(1, "Goodbye!");
        map.put(2, "Have a nice day!");

        Assert.assertFalse(map.isEmpty());

        map.clear();

        Assert.assertTrue(map.isEmpty());
        Assert.assertEquals(0, map.size());
    }
}