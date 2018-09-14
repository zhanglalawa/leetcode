package linkedList;

public class DesignLinkedList {
	class MyLinkedList {
		
		class Node{
			private int e;
			private Node next;
			
			public Node(int e, Node next) {
				this.e = e;
				this.next = next;
			}
		}
		
		private Node dummyHead;
		private int size;
	    /** Initialize your data structure here. */
	    public MyLinkedList() {
	        dummyHead = new Node(0, null);
	        size = 0;
	    }
	    
	    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	    public int get(int index) {
	    	if (index < 0 || index >= size) {
				return -1;
			}
	    	
	        Node prev = dummyHead;
	        int i = 0;
	        while(prev.next != null) {
	        	prev = prev.next;
	        	if (i == index) {
					return prev.e;
				}
	        	i++;
	        }
	        
	        return -1;
	    }
	    
	    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	    public void addAtHead(int val) {
	        dummyHead.next = new Node(val, dummyHead.next);
	        size++;
	    }
	    
	    /** Append a node of value val to the last element of the linked list. */
	    public void addAtTail(int val) {
	    	Node prev = dummyHead;
	    	while(prev.next != null) {
	        	prev = prev.next;
	        }
	    	size++;
	    	prev.next = new Node(val, null);
	    }
	    
	    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	    public void addAtIndex(int index, int val) {
	        if (index < 0 || index > size) {
				return;
			}
	    	Node prev = dummyHead;
	        for (int i = 0; i < index; i++) {
				prev = prev.next;
			}
	        if(index == size){
                addAtTail(val);
                return;
            }
	        Node cur = prev.next;
	        Node newNode = new Node(val, cur);
	        prev.next = newNode;
	    }
	    
	    /** Delete the index-th node in the linked list, if the index is valid. */
	    public void deleteAtIndex(int index) {
	    	if (index < 0 || index >= size) {
				return;
			}
	    	size--;
	    	Node prev = dummyHead;
	        for (int i = 0; i < index; i++) {
				prev = prev.next;
			}
	        
	        Node cur = prev.next;
	        prev.next = cur.next;
	        cur.next = null;
	    }
	}

	/**
	 * Your MyLinkedList object will be instantiated and called as such:
	 * MyLinkedList obj = new MyLinkedList();
	 * int param_1 = obj.get(index);
	 * obj.addAtHead(val);
	 * obj.addAtTail(val);
	 * obj.addAtIndex(index,val);
	 * obj.deleteAtIndex(index);
	 */
}
