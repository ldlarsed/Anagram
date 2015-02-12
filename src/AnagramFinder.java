import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class AnagramFinder {

	private SortedMap<String, Integer> sortedWords;
	private Set<String> words;
	private int anagramCounter;

	public AnagramFinder(Set<String> words) {
		this.words = words;
	}

	public String findAnagrams() {
		populateMap();
		return presentAnagrams();
	}

	public int getAnagramCounter() {
		return anagramCounter;
	}

	/**
	 * Stores a pair of String and Integer in a ArrayList to sort these by the
	 * integer value. Since two anagrams have the same integer hash they will be
	 * placed next to each other in the ArrayList structure.
	 * 
	 * @return
	 */
	private String presentAnagrams() {
		StringBuilder sb = new StringBuilder();
		ArrayList<WordHashPair<String, Integer>> anagramList = new ArrayList<WordHashPair<String, Integer>>();

		for (Map.Entry<String, Integer> entry : sortedWords.entrySet()) {
			anagramList.add(new WordHashPair<String, Integer>(entry.getKey(),
					entry.getValue()));
		}

		Collections.sort(anagramList);
		Iterator<WordHashPair<String, Integer>> it = anagramList.iterator();
		int i = 0, prevV = 0, currentV = 0;

		while (it.hasNext()) {
			if (i > 0) {
				prevV = currentV;
			}
			WordHashPair<String, Integer> tmp = it.next();
			currentV = tmp.getV();
			if (i > 0 && currentV != prevV) {
				sb.append("\n");
				i=0;
			} 
			sb.append(tmp.getK()).append(" ");
			i++;
			if(i>1)
				anagramCounter+=i;
		}

		return sb.toString();
	}

	/**
	 * Populates the map with the original string (word) as key and a hash value
	 * of a sorted version of the key as map value.
	 */
	private void populateMap() {
		try {
			sortedWords = new TreeMap<String, Integer>(new RuleBasedCollator(
					Strings._nbCollatorRule));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Iterator<String> it = words.iterator();
		while (it.hasNext()) {
			String word = it.next();
			sortedWords.put(word, hashSorted(word));
		}
	}

	/**
	 * Sorts a string and returns the hash value.
	 * 
	 * @param unordered
	 * @return
	 */
	private Integer hashSorted(String unordered) {
		char[] sort = unordered.toCharArray();
		Arrays.sort(sort);
		String sortedString = Arrays.toString(sort);
		int hashOfSortedString = sortedString.hashCode();
		// System.out.println(sortedString + " " + hashOfSortedString);
		return hashOfSortedString;
	}

	@SuppressWarnings("unused")
	private String mapToString(Map<String, Integer> words) {
		StringBuilder sb = new StringBuilder();

		for (Map.Entry<String, Integer> entry : words.entrySet()) {
			sb.append(entry.getKey()).append(" ").append(entry.getValue())
					.append("\n");
		}
		return sb.toString();
	}

}
