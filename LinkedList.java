package cs146S21.Piziali.project1;

public class LinkedList
{
    private Node head;
    private LinkedList list;

    static class Node
    {
        String data;
        Node next;

        public Node(String data)
        {
            this.data = data;
            next = null;
        }
    }

    // This method inserts a node into the end of the list given the data it should contain
    public LinkedList add(String data)
    {
        // Create a node that stores the given data
        Node newNode = new Node(data);
        newNode.next = null;

        // If head is null, there is no data in the linked list so make the data the head
        if(head == null)
            head = newNode;

        // Traverse the list and check if the data is already in the list
        // If you reach null, the data is not already in the list and insert the new node at the end
        else {
            Node currentNode = head;
            while(currentNode.next != null)
            {
                // If the current node or the node after (in case of it being last node) data already exists, cannot add it to the list
                if(currentNode.data.equals(data) || currentNode.next.data.equals(data))
                {
                    return list;
                }
                currentNode = currentNode.next;
            }

            //When you reach null, insert the new node into the end of the list
            currentNode.next = newNode;
        }
        return list;
    }

    // This method removes a node from the linked list given the data it contains
    public LinkedList remove(String data)
    {
        // If list is empty, can't remove anything
        if(head == null)
            return list;

        // If head is the node to be deleted
        else if(head.data.equals(data))
        {
            head = head.next;      // Delete the head node by setting head to the following node
        }

        // Else just traverse the list until find match
        else {
            Node currentNode = head.next;      // Set currentNode to node after head since we know head is not the match at this point
            Node lastNode = head;      // Keep track of last node in order to delete current node

            while(currentNode != null)
            {
                // If the current node's data matches the data of the node we are trying to delete
                if(currentNode.data.equals(data))
                {
                    lastNode.next = currentNode.next;       // Deletes the currentNode
                    return list;
                }
                // If there is not a match, iterate to the next node
                else {
                    currentNode = currentNode.next;
                    lastNode = lastNode.next;
                }
            }
        }
        return list;
    }

    // This method measures the number of nodes in a list
    public int length()
    {
        Node currentNode = head;
        int count = 0;

        // Iterate through the list and count each iteration to get the length
        while(currentNode != null)
        {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    // This method returns a boolean whether the list has the specified data or not
    public boolean hasItem(String data)
    {
        Node currentNode = head;

        // Iterate through the list to check if each node's data value equals the given data value
        while(currentNode != null)
        {
            // If the current node matches data, return true
            if(currentNode.data.equals(data))
            {
                return true;
            }
            // If not, iterate to next node
            else
                currentNode = currentNode.next;
        }
        // If we reached null, then there was no match
        return false;
    }

    // This method returns a linked list containing the union of two lists
    public LinkedList union(LinkedList list2)
    {
        Node currentNode1 = head;
        Node currentNode2 = list2.head;
        LinkedList union = new LinkedList();

        // Traverse both lists individually to account for lists being different sizes
        // Add each element of the list to the union list, add() method will factor out any duplicates
        while(currentNode1 != null)
        {
            union.add(currentNode1.data);
            currentNode1 = currentNode1.next;
        }

        while(currentNode2 != null)
        {
            union.add(currentNode2.data);
            currentNode2 = currentNode2.next;
        }
        return union;
    }

    // This method returns a linked list containing the intersection of two lists
    public LinkedList intersection(LinkedList list2)
    {
        Node currentNode1 = head;
        Node currentNode2 = list2.head;
        LinkedList intersection = new LinkedList();

        // Iterate through list2 and compare each value to list
        while(currentNode2 != null)
        {
            while(currentNode1 != null)
            {
                if(currentNode2.data.equals(currentNode1.data))
                    intersection.add(currentNode2.data);
                currentNode1 = currentNode1.next;
            }
            currentNode2 = currentNode2.next;
            currentNode1 = head; // Reset list's node to head so it can iterate through again
        }
        return intersection;
    }

    // This method returns a reference to a node that contains the data given
    public Node referenceToString(String data)
    {
        Node currentNode = head;
        // Search through linked list to find node that contains the data
        while(currentNode != null)
        {
            // If found, return the node containing the data
            if(currentNode.data.equals(data))
                return currentNode;
            currentNode = currentNode.next;
        }
        // If reach the end of the list without finding the node, that means it is not in the list so return null
        return null;
    }

}
