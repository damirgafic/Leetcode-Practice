
import java.io.*; 
public class LinkedList { 
  
    Node head; // head of list 
 
    static class Node { 
  
        int data; 
        Node next; 
  
        // Constructor 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  
    // Method to insert a new node 
    public static LinkedList insert(LinkedList list, int data) 
    { 
        // Create a new node with given data 
        Node new_node = new Node(data); 
        new_node.next = null; 
  
        // If the Linked List is empty, 
        // then make the new node as head 
        if (list.head == null) { 
            list.head = new_node; 
        } 
        else { 
            // Else traverse till the last node 
            // and insert the new_node there 
            Node last = list.head; 
            while (last.next != null) { 
                last = last.next; 
            } 
  
            // Insert the new_node at last node 
            last.next = new_node; 
        } 
  
        // Return the list by head 
        return list; 
    } 
    public static LinkedList delete(LinkedList list, int data)
    {
    	// case 1
    	Node currNode = list.head, prev = null;
    	if(currNode != null && currNode.data == data) {
    		list.head = currNode.next; 
    		return list; 
    	}
    	// case  2
    	while(currNode!=null && currNode.data != data) {
    		prev = currNode; 
    		currNode = currNode.next; 
    	}
    	if(currNode != null) {
    		prev.next = currNode.next; 
    		System.out.println(data + " found and deleted");
    	}
    	// case 3 
    	if(currNode == null) {
    		System.out.println(data + " not found in list");
    	}
    	return list; 
    	
    }
    // method to remove duplicates from LinkedList
    public static LinkedList removeDuplicates(LinkedList list) {
    	Node currNode = list.head;
    	Node ptr1 = null, ptr2=null, dup=null;
    	ptr1 = list.head;
    	
    	while (ptr1 != null && ptr1.next != null) {
    		ptr2 = ptr1;
    		
    		while(ptr2.next != null) {
    			if(ptr1.data == ptr2.next.data) {
    				dup = ptr2.next;
    				ptr2.next = ptr2.next.next; 
    				System.gc(); // garbage collection
    			}
    			else {
    				ptr2 = ptr2.next; 
    			}
    		}
    		ptr1 = ptr1.next;
    	}
    		
    	
    	return list; 
    }
    
    // method to print kth to last element in List
    public static int kthToLast(int k, LinkedList list) {
    	Node currNode = list.head; 
    	int count = 0; 
    	while(currNode != null) {
    		currNode = currNode.next; 
    		count += 1; 
    	}
    	if(count<k) {
    		return -1000000000; // k number cannot be bigger than length of list 
    	}
    	k -= 1; 
    	currNode = list.head; 
    	for(int i = 1; i<count-k; i++) {
    		currNode = currNode.next; 
    	}
    	return currNode.data; 
    	//System.out.println(count);
    	//return list; 
    }
    // delete middle element in list 
    public static LinkedList deleteMiddle(LinkedList list) {
    	Node currNode = list.head, prev = null; 
    	int count = 0; 
    	// case 1 if list is empty
    	if(currNode==null) {
    		System.out.println("List is empty");
    		return list; 
    	}
    	while(currNode!=null) {
    		currNode = currNode.next; 
    		count++; 
    	}
    	count = count/2; 
    	currNode = list.head;
    	for(int i = 1; i<count; i++) {
    		prev = currNode; 
    		currNode = currNode.next; 
    	}
    	prev.next = currNode.next; 
    		
    	return list; 
    }
  
    // Method to print the LinkedList. 
    public static void printList(LinkedList list) 
    { 
        Node currNode = list.head; 
   
        System.out.print("LinkedList: "); 
   
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.data + " "); 
   
            // Go to next node 
            currNode = currNode.next; 
        } 
    } 
   
    // Driver code 
    public static void main(String[] args) 
    { 
        /* Start with the empty list. */
        LinkedList list = new LinkedList(); 
  
        // 
        // ******INSERTION****** 
        // 
  
        // Insert the values 
        list = insert(list, 1); 
        list = insert(list, 2); 
        list = insert(list, 3); 
        list = insert(list, 4); 
        list = insert(list, 5); 
        list = insert(list, 6); 
        list = insert(list, 3);
        list = insert(list, 7); 
        list = insert(list, 2);
        list = insert(list, 8); 
        list = insert(list, 10); 
        
  
        // Print the LinkedList 
        printList(list); 
        
        // deleting elements 
        list = delete(list, 4);
        list = removeDuplicates(list);
        printList(list);
        
        
        System.out.println("the element is " + kthToLast(5,list)); 
        list = deleteMiddle(list);
        printList(list);
      
    } 
} 
