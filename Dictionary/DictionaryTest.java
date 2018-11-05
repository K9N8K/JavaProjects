// DictionaryTest.java
// Name: Kyle Ko

public class DictionaryTest{
	public static void main(String[] args){
		Dictionary A = new Dictionary();

		// Size check for 0
		System.out.println("Is Empty: " + A.isEmpty());
		System.out.println("Size: "  + A.size());


		// check inserting for empty Dictionary
		System.out.println("Inserting First Item...");
		A.insert("2", "b");
		System.out.println(A);
		System.out.println("Is Empty: " + A.isEmpty());
		System.out.println("Size: " + A.size());

		// check deleting for single item Dictionary
		System.out.println("Deleting First Item...");
		A.delete("2");
		System.out.println(A);
		System.out.println("Is Empty: " + A.isEmpty());
		System.out.println("Size: " + A.size());

		// insert more than one item
		System.out.println("Inserting Many Items...");
		A.insert("1", "duck");
		A.insert("2", "duck");
		A.insert("3", "duck");
		A.insert("4", "goose");
		A.insert("5", "duck");
		A.insert("6", "duck");
		A.insert("7", "duck");
		A.insert("8", "duck");
		A.insert("9", "duck");
		A.insert("10", "goose");
		A.insert("11", "duck");
		A.insert("12", "duck");
		System.out.println(A);
		System.out.println("Is Empty: " + A.isEmpty());
		System.out.println("Size: " + A.size());

		// check lookup function
		if(A.lookup("4") != null){
			System.out.println("In Key 4: " + A.lookup("4"));
		} else {
			System.out.println("ERROR in lookup()");
		}

		// deleting some items
		System.out.println("Deleting some items...");
		A.delete("1");
		A.delete("3");
		A.delete("10");
		System.out.println(A);
		System.out.println("Is Empty: " + A.isEmpty());
		System.out.println("Size: " + A.size());

		// check Exception handling
		System.out.println("Trying to add a duplicate key");
		try{
			A.insert("2", "NOOO");
		} catch (DuplicateKeyException e) {
			System.out.println(e);
		}

		System.out.println("Trying to delete missing key");
		try{
			A.delete("1");
		} catch (KeyNotFoundException e){
			System.out.println(e);
		}

		// check toString
		System.out.println("Checking toString()");
		String checkToString = A.toString();
		System.out.println(checkToString);

		// check makeEmpty
		System.out.println("Making Empty...");
		A.makeEmpty();
		System.out.println(A);
		System.out.println("Is Empty: " + A.isEmpty());
		System.out.println("Size: " + A.size());


	}
}