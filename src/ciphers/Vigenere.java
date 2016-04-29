package ciphers;

import java.util.Scanner;

public class Vigenere {

	static Scanner sc;

	private String keyword;
	private String message;
	private String ciphered;
	private String deciphered;

	/*
	 * Constructor
	 */
	public Vigenere() {
		this.keyword = new String();
		this.message = new String();
		this.ciphered = new String();
		this.deciphered = new String();
	}

	public Vigenere(String keyword, String message) {
		this.keyword = keyword;
		this.message = message;
		this.ciphered = new String();
		this.deciphered = new String();
	}

	/*
	 * Main Function
	 */
	public static void main(String[] args) {

		Vigenere vigenere = new Vigenere();

		sc = new Scanner(System.in);

		System.out.print("Enter Message: ");
		vigenere.message = sc.nextLine().toUpperCase().replaceAll("\\s", "");

		System.out.print("Enter keyword: ");
		vigenere.keyword = sc.next().toUpperCase();
		vigenere.deleteDuplicatedChars();
		vigenere.stretchKeyword();

		vigenere.encrypt();

		vigenere.decrypt();
		vigenere.printResult();

	}

	/*
	 * Stretch keyword to match the message's length
	 */
	private void stretchKeyword() {
		if (keyword.length() >= message.length())
			keyword.substring(0, message.length());
		else {
			StringBuffer sb = new StringBuffer(keyword);
			for (int i = keyword.length(); i < message.length(); i++)
				sb.append(keyword.charAt(i % keyword.length()));
			keyword = sb.toString();
		}
	}

	/*
	 * Deletes duplicated characters form keyword
	 */
	private void deleteDuplicatedChars() {

		StringBuffer sb = new StringBuffer();

		for (int i = 0, n = keyword.length(); i < n; i++) {
			char c = keyword.charAt(i);
			if (charExists(c, sb) == false)
				sb.append(c);
		}
		keyword = sb.toString();
	}

	/*
	 * Verifies if there's duplicated characters in a word
	 */
	private boolean charExists(char c, StringBuffer keyword) {
		for (int i = 0; i < keyword.length(); i++) {
			if (keyword.charAt(i) == c)
				return true;
		}
		return false;
	}

	/*
	 * Encrypts the message
	 */
	public void encrypt() {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < message.length(); i++) {
			int messageChar = (int) message.charAt(i);
			int keywordChar = (int) keyword.charAt(i);
			int cipherChar;

			if (messageChar >= (int) 'A' || messageChar <= (int) 'Z') {
				cipherChar = (messageChar + keywordChar - 2 * ((int) 'A')) % 26 + (int) 'A';
				sb.append((char) cipherChar);
			}
		}

		ciphered = sb.toString();
	}

	/*
	 * Decrypts the message
	 */
	public void decrypt() {
		StringBuffer plaintext = new StringBuffer();

		for (int i = 0; i < ciphered.length(); i++) {

			int messageChar = ciphered.charAt(i);
			int keywordChar = keyword.charAt(i);
			int decipheredChar;

			decipheredChar = (messageChar - keywordChar + 26) % 26 + (int) 'A';
			plaintext.append((char) decipheredChar);
		}

		deciphered = plaintext.toString();
	}

	/*
	 * Prints the results
	 */
	public void printResult() {
		System.out.println();
		System.out.println("==========Vigenere==========");
		System.out.println("Message:   " + message);
		System.out.println("Keyword:   " + keyword);
		System.out.println("Result :   " + ciphered);
		System.out.println("Decrypted: " + deciphered);
	}
	
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCiphered() {
		return ciphered;
	}

	public String getDeciphered() {
		return deciphered;
	}
}
