package com.my2035.exercise01.out;

import java.io.*;

public class CompareContent {
	String[] filesName = {null, null, null};
	String[][] content = null;

	public CompareContent(String file1, String file2, String file3) {
		filesName[0] = file1;
		filesName[1] = file2;
		filesName[2] = file3;
		content = new String[3][100];
	}
	
	public void compare(){
		int i = 0;
		int j = 0;
		
		for(String f:filesName) {
			
			try {
				System.out.println(f);
				content[i] = fetchDataFromFile(filesName[i]);
//				System.out.println(content[i][0]);
				i++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		for (i=0; i<100; i++) {
			if (content[0][i] != null) {
				for (j = 0; j < 100; j++) {
					if (content[1][j] != null) {
						if (content[1][j].equals(content[0][i])) {
//							System.out.println(content[1][j] + " vs " + content[0][i]);
							content[1][j] = "(=)";
						}
					}
					
					if (content[2][j] != null) {
						if (content[2][j].equals(content[0][i])) {
//							System.out.println(content[2][j] + " vs " + content[0][i]);
							content[2][j] = "(=)";
						}						
					}
					
				}
			}

			
		}
		
		// output the final result
		
		for (i=0; i<3; i++) {
			System.out.println("This is file" + i);
			for (j = 0; j < 100; j++) {
				if (content[i][j] != null) {
					System.out.println(content[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	private String[] fetchDataFromFile(String file) throws IOException {
		
		BufferedReader readBuffer = null;
		String line = null;
		String[] c = new String[100];
		
		try {
			readBuffer = new BufferedReader(new FileReader(file));
			int i = 0;
			
			while ((line = readBuffer.readLine()) != null) {				
				c[i] = line;
//				System.out.println(c[i]);
				i++;
			}
			

		} finally {
			if (readBuffer != null) {
				System.out.println("The file: " + file + " was closed!");
				readBuffer.close();
			}
		}
		
		return c;
	}

}
