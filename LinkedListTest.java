import cs146S21.Piziali.project1.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LinkedListTest
{
    // This tests the add method to check if elements are being added to the linked list
    @org.junit.jupiter.api.Test
    void testAdd()
    {
        LinkedList list = new LinkedList();
        list.add("hi");
        list.add("hello");
        list.add("sup");
        list.add("sup");
        assertEquals(3,list.length()); // To check if a duplicate will be added or not
        assertTrue(list.hasItem("hi"));
        assertTrue(list.hasItem("hello"));
        assertTrue(list.hasItem("sup"));
    }

    // This method tests the remove method to check if elements are being removed from the linked list
    @Test
    void testRemove()
    {
        LinkedList list = new LinkedList();
        list.remove("0"); // Testing that it won't crash when attempting to remove from an empty list
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.remove("3");
        assertEquals(3,list.length()); // Asserts the length of the list is one less than before the item was removed
        list.remove("2");
        assertEquals(2,list.length()); // Asserts the length of the list is one less than before the item was removed
    }

    // Tests the length method to ensure it works correctly
    @Test
    void testLength()
    {
        LinkedList list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        assertEquals(4,list.length()); // Asserts the length of the list matches what it should be
    }

    // Tests the hasItem() method to ensure that it works correctly
    @Test
    void testHasItem()
    {
        LinkedList list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        assertTrue(list.hasItem("1"));
        assertTrue(list.hasItem("4"));
        assertFalse(list.hasItem("7"));
    }

    // Test the union() method to ensure the returned linked list is accurate
    @Test
    void testUnion()
    {
        LinkedList list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        LinkedList list2 = new LinkedList();
        list.add("1");
        list.add("4");
        list.add("7");

        LinkedList union = list.union(list2);

        assertEquals(5, union.length()); // The lengths of the combined lists should be 5
        assertTrue(union.hasItem("1")); // Checks that each of the items are in the list
        assertTrue(union.hasItem("2"));
        assertTrue(union.hasItem("3"));
        assertTrue(union.hasItem("4"));
        assertTrue(union.hasItem("7"));
    }

    // Tests the intersection method to ensure the appropriate data is being added into the list
    @Test
    void testIntersection()
    {
        LinkedList list = new LinkedList();
        list.add("4");
        list.add("1");
        list.add("7");


        LinkedList list2 = new LinkedList();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");

        LinkedList intersection = list.intersection(list2);

        // Checks the appropriate items are in the intersection list
        assertEquals(2, intersection.length());
        assertTrue(intersection.hasItem("1"));
        assertTrue(intersection.hasItem("4"));
    }

    // Tests the that the appropriate node is being returned
    @Test
    void testReferenceToString()
    {
        LinkedList list = new LinkedList();
        list.add("4");
        list.add("1");
        list.add("7");

        assertNotNull(list.referenceToString("4")); // Checks that the node is being returned
        assertNull(list.referenceToString("10")); // Checks that no node is being returned when it is not in the list
    }
}
