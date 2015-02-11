import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Loads all words into static String set excluding duplicates.
 * @author luke
 *
 */
public class FileLoader {

	private static Set<String> words;

	public static Set<String> loadFile(File file) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)))) {
			words = new HashSet<String>(); 
			String line = null;

			while ((line = br.readLine()) != null) {
				words.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}
}
