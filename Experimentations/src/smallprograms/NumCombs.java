package smallprograms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author marashid
 * This class generates all number combinations for a given length
 */
public class NumCombs {

	static int blockLength = 4; // for the time being only 2 character long numbers

	// define the pool of digits and store them in an array
	static int[] numPool = new int[] { 2, 7, 8, 7 };; // all number digits will be stored in an integer array
	
	/*
	 * For manual verification, the total number of combination is: the 'total number of available digits in the pool'
	 * to the power 'length of the combination'
	 */
	// let's have a Set collection to store all combinations blocks as they're generated, we can then verify the total number
	// from the collection's size against our manual calculation using the above formula
	static ArrayList<String> combiSet = new ArrayList<String>();

	public static void main(String[] args) {
		// printTwoDigitCombi();
		// printThreeDigitCombi();
		printNDigitCombi();
		System.out.println("Total: " + combiSet.size());
	}

	/**
	 * Generates all 2-digit number blocks only
	 */
	private static void printTwoDigitCombi() {
		combiSet.clear(); // let's clear the collection of any old values;

		for (int index1 = 0; index1 < numPool.length; index1++) {
			for (int index2 = 0; index2 < numPool.length; index2++) {
				String comb = numPool[index1] + "" + numPool[index2];
				combiSet.add(comb);
				System.out.println(comb);
			}
		}
	}

	/**
	 * Generates all 3-digit number blocks only
	 */
	private static void printThreeDigitCombi() {
		combiSet.clear(); // let's clear the collection of any old values;

		for (int index1 = 0; index1 < numPool.length; index1++) {
			for (int index2 = 0; index2 < numPool.length; index2++) {
				for (int index3 = 0; index3 < numPool.length; index3++) {
					String comb = numPool[index1] + "" + numPool[index2] + "" + numPool[index3];
					combiSet.add(comb);
					System.out.println(comb);
				}
			}
		}
	}

	/**
	 * Generates all number blocks with a given block length
	 */
	private static void printNDigitCombi() {
		combiSet.clear(); // let's clear the collection of any old values;

		String prefix = ""; // the prefix to append before the rotating element in the number block while iterating over the pool
		int prefixEndPosition = 1; // the end position of the prefix element in the number block, let's start with the first 
											//element in the combination

		helperNDigitCombi(prefix, prefixEndPosition);
	}

	/**
	 * @param prefix
	 * @param prefixEndPosition
	 */
	private static void helperNDigitCombi(String prefix, int prefixEndPosition) {
		for (int index = 0; index < numPool.length; index++) {

			if (prefixEndPosition < blockLength) { // as long as the prefixEndPosition is not the last element
				String oldPrefix = prefix; // first preserve the old prefix value before changing it
				prefix += numPool[index]; // append the next item from the pool to existing prefix
				prefixEndPosition++; // prefix will move to the next block-element, so increment the prefixEndPosition

				helperNDigitCombi(prefix, prefixEndPosition); // recurse

				prefix = oldPrefix; // fall back to the prefix prior to last recursion
				prefixEndPosition -= 1; //fall back to the prefixEndPosition prior to last recursion

			} else {
				System.out.println(prefix + numPool[index]);
				combiSet.add(prefix + numPool[index]); // add the item in the pool to our collection
			}
		}
	}

	/*
	 * An example taken from a website (the alogorithm is different to one I used above)
	 * http://www.geeksforgeeks.org/print-all-combinations-of-given-length/
	 */
	// static char[] chars = new char[] { '0', '1', '2' };; // all characters will be stored in an array
	// static void printAllKLengthRec(String prefix, int remLength) {
	//
	// // Base case: k is 0, print prefix
	// if (remLength == 0) {
	// System.out.println(prefix);
	// return;
	// }
	//
	// // One by one add all characters from set and recursively
	// // call for k equals to k-1
	// for (int i = 0; i < chars.length; i++) {
	//
	// // Next character of input added
	// String newPrefix = prefix + chars[i];
	//
	// // k is decreased, because we have added a new character
	// printAllKLengthRec(newPrefix, remLength - 1);
	// }
	// }

}
