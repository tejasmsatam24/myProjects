public class LinkedList {

	Node head;

	static class Node {
	
		int data;
		
		Node next;
		
		Node (int d){
		
			data = d;
		} 
		
	}
	
	public static LinkedList insert(LinkedList list, int data){
		
		Node new_node = new Node(data);
		
		new_node.next = null;
		
		if(list.head == null) {
			
			list.head = new_node;
			
		}else{
		
			Node last = list.head;
			
			while (last.next != null){
			
				last = last.next;
				
			}
			last.next = new_node;
			
		}
		
		return list;
		
	}
	
	public static LinkedList deleteByKey(LinkedList list, int key){
		
		Node currNode = list.head;
		Node prev = null;
		
		if (currNode != null && currNode.data == key) {
			
			list.head = currNode.next;
			
			System.out.println(key + " found and deleted");
			
			return list;
			
		}
		
		while (currNode != null && currNode.data != key){
			
			prev = currNode;
			
			currNode = currNode.next;
			
		}
		
		if (currNode != null) {
			
			prev.next = currNode.next;
			
			System.out.println(key + " found and deleted");
			
		}
		
		if (currNode == null) {
			
			System.out.println(key + " not found");
			
		}
		
		return list;
		
	}

	public static LinkedList deleteByPosition (LinkedList list, int index) {

		Node currNode = list.head, prev = null;

		if (index == 0 && currNode != null) {
			
			list.head = currNode.next;

			return listl

		}

		int counter = 0;

		while (currNode != null) {

			if (counter == index) {
				
				prev.next = currNode.next;

				break;
		
			}else {

				prev = currNode;

				currNode = currNode.next;

				counter++;

			}

		}

	}
	
	public static void printList(LinkedList list){
		
		Node currNode = list.head;
		
		System.out.println("Linked List: ");
		
		while(currNode != null){
			
			System.out.print(currNode.data + " ");
			
			currNode = currNode.next;
		}
	}

	public static void main(String[] args){
		
		LinkedList list = new LinkedList();
		
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);
		list = insert(list, 7);
		list = insert(list, 8);
		
		printList(list);
		
		deleteByKey(list, 1);
		
		printList(list);
		
		deleteByKey(list, 4);
		
		printList(list);
		
	}
	
}

