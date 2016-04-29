package ciphers;

import java.util.Scanner;

public class Shift {

	static Scanner sc;
	private int shift;
	private String message;
	private String ciphered;
	private String deciphered;

	public Shift() {
		this.ciphered = new String();
		this.message = new String();
		this.shift = 0;
	}

	public static void main(String[] args) {

		Shift caesar = new Shift();

		sc = new Scanner(System.in);

		System.out.print("Enter Message: ");
		caesar.message = sc.nextLine().toUpperCase().replaceAll("\\s", "");
		System.out.print("Enter shift key: ");
		caesar.shift = sc.nextInt();

		caesar.encrypt();
		caesar.decrypt();
		caesar.print();
	}

	private void encrypt() {
		StringBuffer sb = new StringBuffer();
		char c;
		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
				c = (char) ((int) message.charAt(i) + shift);
				if (c > 'Z')
					c = (char) ((int) message.charAt(i) - (26 - shift));
			} else
				c = message.charAt(i);
			sb.append(c);
		}
		ciphered = sb.toString();
	}

	private void decrypt() {
		StringBuffer sb = new StringBuffer();
		char c;
		for (int i = 0; i < ciphered.length(); i++) {
			if (ciphered.charAt(i) >= 'A' && ciphered.charAt(i) <= 'Z') {
				c = (char) ((int) ciphered.charAt(i) - shift);
				if (c < 'A')
					c = (char) ((int) ciphered.charAt(i) + (26 - shift));
			} else
				c = ciphered.charAt(i);
			sb.append(c);
		}
		deciphered = sb.toString();
	}

	private void print() {
		System.out.println("Message:    " + message);
		System.out.println("Ciphered:   " + ciphered);
		System.out.println("Deciphered: " + deciphered);
	}
}
