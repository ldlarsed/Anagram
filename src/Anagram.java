import java.io.File;
import java.util.Iterator;
import java.util.Set;

/**
 * Anagram.java Controller class.
 * 
 * @author Lukas Larsed
 *
 */
public class Anagram {

	private GUI gui;
	private Set<String> words;
	private AnagramFinder aFinder;

	public Anagram() {

		gui = new GUI();

		gui.setAnagramAction(new AnagramAction() {

			@Override
			public void actionPerformed(ActionType at, Object obj) {
				switch (at) {
				case SEARCH:
					if (words == null || words.isEmpty())
						gui.showMessage(Strings._errorMessage1);
					else {
						aFinder = new AnagramFinder(words);
						gui.showOutput(aFinder.findAnagrams());
						gui.setAnagramCounter(aFinder.getAnagramCounter());
					}
					break;
				case READ_FILE:
					File f = (File) obj;
					words = FileLoader.loadFile(f);
					showFileContents(words);
					gui.setWordCounter(words.size());
					break;
				}
			}
		});
	}

	private void showFileContents(Set<String> words) {
		StringBuilder sb = new StringBuilder();
		Iterator<String> i = words.iterator();
		while (i.hasNext())
			sb.append(i.next()).append("\n");
		sb.append(Strings._fileLoadMessage);
		gui.showOutput(sb.toString());
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Anagram();
			}
		});
	}

}
