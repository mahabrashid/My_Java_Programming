package smallprograms;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please type your name: ");
		String name = scanner.nextLine();
		scanner.close();
		System.out.println("Hello "+name+"!");
	}
}