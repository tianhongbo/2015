package scott.java.polymorphism;

/**
 * Test the polymorphism of java
 *
 */

class Person {
	String name;
	int height;
	int weight;
	
	void run () {
		System.out.println("Person: ");
	}
}

class Girl extends Person {
	String hair;
	
	void run () {
		System.out.println("Girl: ");
	}
}

class Boy extends Person {
	String sport;
	
	void run() {
		System.out.println("Boy: ");
	}
}


public class App 
{
    static void doSth(Person person) {
    	person.run();
    }
    
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Person[] person = {new Girl(), new Boy(),};
        
        for(Person s: person) {
        	doSth(s);
        }
    }
}
