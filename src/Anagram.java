import java.io.File;
import java.util.Iterator;
import java.util.Set;

/**
 * Controller class.
 * 
 * @author luke
 *
 */
public class Anagram {

	private GUI gui;

	public Anagram() {

		gui = new GUI();

		gui.setAnagramAction(new AnagramAction() {

			@Override
			public void actionPerformed(ActionType at, Object obj) {
				switch (at) {
				case SEARCH:
					new AnagramFinder();
					break;
				case READ_FILE:
					File f = (File) obj;
					Set<String> words = FileLoader.loadFile(f);
					showFileContents(words);
				}
			}
		});
	}
	
	private void showFileContents(Set<String> words){
		StringBuilder sb = new StringBuilder();
		Iterator<String> i = words.iterator();
		while(i.hasNext())
			sb.append(i.next()).append("\n");
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
