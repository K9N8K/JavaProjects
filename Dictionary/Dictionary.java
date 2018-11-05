// Dictionary.java
// Name: Kyle Ko

public class Dictionary implements DictionaryInterface{

	// Single Linked List
	private class Node {
		String key;
		String value;
		Node next;

		Node(String key_arg, String value_arg){
			value = value_arg;
			key = key_arg;
			next = null;
		}
	}

	// Field for the Dictionary class
	private Node head;	// reference to first Node in list
	private int numItems;

	// Dictionary constructor
	public Dictionary(){
		head = null;
		numItems = 0;
	}

	// Helper function findKey()
	private Node findKey(String key_arg){
		Node N = head;
		if (N == null){
			return null;
		} else {
			for (N = head; N != null; N = N.next){
				if( N.key.equals(key_arg) ){
					return N;
				}
			}
			return null; // if word is not found in Linked List
		}
	}

	// ADT Operations

	// isEmpty() returns true if empty, false otherwise
	public boolean isEmpty(){
		return (numItems == 0);
	}

	// size() returns the number of entries in the Dictionary
	public int size(){
		return numItems;
	}

	// lookup() returns value associated key, or null reference if no such key exists
	public String lookup(String key_arg){
		Node N = head;
		if (N == null){
			return null;
		} else {
			for(N = head; N != null; N = N.next){
				if( N.key.equals(key_arg) ){
					return N.value;
				}
			}
			return null;
		}
	}

	// insert() inserts new (key,value) pair into this Dictionary
	public void insert(String key_arg, String value_arg) throws DuplicateKeyException {
		// throws exception if key is already in Dictionary
		if(findKey(key_arg) != null){
			throw new DuplicateKeyException("cannot insert duplicate keys");
		}

		Node N = head;
		Node insertion = new Node(key_arg, value_arg);


		if( head == null ){
			head = insertion;
		}
		else {
			while(N != null){
				if(N.next == null){
					N.next = insertion;
					break;
				} else {
					N = N.next;
				}			
			}

		}

		numItems++;

	}

	// delete() deletes pair with given key
	public void delete(String key_arg) throws KeyNotFoundException{
		Node N = head;

		// throws exception if key is not in Dictionary
		if(findKey(key_arg) == null){
			throw new KeyNotFoundException("cannot delete non-existent key");
		} else {
				// if the key_arg is the one and only node
				if(numItems <= 1){
					head = head.next;
					N.next = null;
				// if the key is first
				} else if (N.key.equals(key_arg)){
					head = N.next;
				} else {
					while(!(N.next.key.equals(key_arg))){
						N = N.next;
					}
					// breaks out of while loop once the next Node
					// is the one we want to delete
					N.next = N.next.next;
				}	
				numItems--;
		}
	}


	public void makeEmpty(){
		head = null;
		numItems = 0;
	}

	public String toString(){
		Node N = head;
		String ret_string = "";

		for(N = head; N != null; N = N.next){
			ret_string += N.key + " " + N.value + "\n";
		}
		
		return ret_string;
	}
}