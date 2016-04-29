package crackers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FrequencyAnalysis {
	
	private String ciphertext;
	private String filename;
	private Scanner sc;
	
	public FrequencyAnalysis(){
		this.sc = new Scanner(System.in);
		this.filename = new String();
		this.ciphertext = new String();
	}
	
	
	public static void main(String[] args) throws IOException {			
		FrequencyAnalysis fa = new FrequencyAnalysis();		
		System.out.print("Enter file name: ");
		fa.filename = fa.sc.next();
		fa.readFile(fa.filename);
		
		System.out.println(fa.ciphertext);
	}
	
	private String readFile(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    ciphertext = sb.toString();
		} finally {
		    br.close();
		}
		return ciphertext;
	}
	
	
}
