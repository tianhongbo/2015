package com.scott.junit;

public class MyMultiply {
	int x;
	int y;
	
	MyMultiply(int a, int b) {
		this.x = a;
		this.y = b;
	}
	
	public int multiply() {
		if (x > 100 || y > 100) {
			throw new IllegalArgumentException("Both x and y should be less than 100!");
		} else {
			return x*y;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyMultiply a = new MyMultiply(99,99);
		System.out.print(a.multiply());

	}

}
