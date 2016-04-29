package ciphers;

import java.util.Scanner;

public class Autokey {

	static Scanner sc;
	
	Vigenere vig; 		// Autokey uses vigenere cipher to encrypt
	String key;			// Initial key
	String message;		// Message to be encrypted
	String ciphered;	// Encrypted message
	String deciphered;	// Deciphered message
	
	/*
	 * Public Constructor
	 */
	public Autokey() {
		this.vig = new Vigenere();
		this.key = new String();
		this.message = new String();
		this.ciphered = new String();
		this.deciphered = new String();
	}
	
	
	/*
	 * Main function 
	 */
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		Autokey autokey = new Autokey();
		
		System.out.print("Enter Message: ");
		autokey.message = sc.nextLine().replaceAll("\\s", "").toUpperCase();
		
		System.out.print("Enter keyword: ");
		autokey.key = sc.next().toUpperCase();
		
		autokey.generateKey();
		autokey.encrypt();
		autokey.decrypt();
		
		autokey.print();
		
	}
	
	/*
	 * Cipher the message
	 */
	private void encrypt(){
		vig = new Vigenere (key, message);
		vig.encrypt();
		ciphered = vig.getCiphered();		
	}
	
	
	/*
	 * Decipher the message 
	 */
	private void decrypt() {
		vig.decrypt();
		deciphered = vig.getDeciphered();
	}
	
	/*
	 * Generate key 
	 */
	private void generateKey() {
		StringBuilder sb = new StringBuilder();
		sb.append(key);
		sb.append(message);
		
		key = sb.toString().substring(0, message.length());
	}
	
	/*
	 * Print Information
	 */
	
	private void print() {
		System.out.println("=========AutoKey=========");
		System.out.println("Message:    " + message);
		System.out.println("Key:        " + key);
		System.out.println("Ciphered:   " + ciphered);
		System.out.println("----------  ");
		System.out.println("Deciphered: " + deciphered);
	}
	
}
