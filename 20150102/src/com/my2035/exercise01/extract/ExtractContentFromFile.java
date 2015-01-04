package com.my2035.exercise01.extract;

import java.io.*;

import com.my2035.exercise01.out.CompareContent;

public class ExtractContentFromFile {
	
	String readFileName = null;
	String writeFileName = null;
	
	ExtractContentFromFile(String read, String write) {
		readFileName = read;
		writeFileName = write;
		
	}
	
	public ExtractContentFromFile() {
		// TODO Auto-generated constructor stub
	}

	public void setFullFileName(String read, String write ){
		readFileName = read;
		writeFileName = write;
	}
	
	public void listFullFileName(){
		System.out.println(readFileName);
		System.out.println(writeFileName);
	}
	
	public void extractContent() throws IOException {
		String line;
		BufferedReader readBuffer = null;
		PrintWriter writeBuffer = null;
		
		try {
			readBuffer = new BufferedReader(new FileReader(readFileName));
			writeBuffer = new PrintWriter(new FileWriter(writeFileName));

			while ((line = readBuffer.readLine()) != null) {
				//System.out.println(line);
				if (line.contains("<module>")) {
					String s;
					System.out.println(line);
					s = line.trim();
					s = s.replaceAll("<module>", "");
					s = s.replaceAll("</module>", "");
					writeBuffer.println(s);
					System.out.println(s);
				}
			}
		} finally {
			if (readBuffer != null) {
				System.out.println("The file:"+readFileName+" was closed!");
				readBuffer.close();
			}
			
			if (writeBuffer != null) {
				System.out.println("The file:" + writeFileName + " was closed!");
				writeBuffer.close();
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		String FILE_NAME = "pom.xml";
		String BASE_FILE_PATH = "/Users/tianhongbo/git/";
		String[][] subFilePath = {
				{"apache-cloudstack-4.1.0-src/","a.txt",},
				{"apache-cloudstack-4.3.0-src/","b.txt",},
				{"apache-cloudstack-4.4.2-src/","c.txt",},
		};
		
		String[] content1;
		
//		String fullFileName = null;
		int numberOfFiles = subFilePath.length;
		
		ExtractContentFromFile extractContent = new ExtractContentFromFile();
		
		for (int i = 0; i<numberOfFiles; i++) {
			extractContent.setFullFileName(BASE_FILE_PATH + subFilePath[i][0] + FILE_NAME, subFilePath[i][1]);
			extractContent.listFullFileName();
			extractContent.extractContent();

		}
		
		CompareContent compare = new CompareContent("a.txt", "b.txt", "c.txt");
		compare.compare();
		
	}
}
