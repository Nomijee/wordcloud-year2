//G00351754
package ie.gmit.sw;

import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class Menu{
	int maxWordImg;
	String fileName;
	String URL;
	String imgName;
	int option;
	int URLorFile=0;
	
	Scanner console = new Scanner(System.in);
	
	
	public void printMenu() {
		
		
		System.out.println("<<<--Word Cloud 2019-->>>");
		System.out.println("Prompt 1 to enter file name to read and extract words from \nPrompt 2 to enter URL\nPrompt 5 to Exit");
		option=console.nextInt();
		while(option!=5) {
			switch (option) {
			case 1:
				System.out.println("Enter  file name: ");
				fileName=console.next();
				System.out.println("Enter  Max number of words display ");
				maxWordImg=console.nextInt();
				System.out.println("Enter name of image to save: ");
				imgName=console.next();
				URLorFile=1;
				break;
			case 2:
				System.out.println("Enter the URL: ");
				URL=console.next();
				System.out.println("Enter  Max number of words display ");
				maxWordImg=console.nextInt();
				System.out.println("Enter name of image to save: ");
				imgName=console.next();
				URLorFile=2;
				break;
			
			default:
				break;
			}
			System.out.println("Prompt 1 to enter file name to read and extract words from \nPrompt 2 to enter URL\nPrompt 5 to Exit");
			option=console.nextInt();
		}
		
	}
}
