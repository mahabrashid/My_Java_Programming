package smallprograms;

import java.io.*;

import java.util.*;

import java.util.Map.Entry;

public class NumOfLettersInASentence {

	public static void main(String[] args) throws IOException {

		String inputText = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String newLine;
		
		System.out.println("when finished, type 'done' in a new line");
		while ((newLine = in.readLine()) != null) {
			if (newLine.equals("done"))
				break;
			inputText += newLine;
		}

		Map<Character, Integer> characterCounts = new TreeMap<Character, Integer>();

		for (String word : inputText.toLowerCase().split(" ")) {

			for (Character value : word.toCharArray()) {

				if (characterCounts.containsKey(value)) {
					characterCounts.put(value, characterCounts.get(value) + 1);

				} else {
					characterCounts.put(value, 1);
				}
			}
		}

		for (Entry<Character, Integer> characterCount : characterCounts.entrySet())

			System.out.print(characterCount.getKey() + "=" + characterCount.getValue() + ",");
	}
}
