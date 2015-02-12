public class Strings {

	public static final String _title = "Anagram finder";
	public static final String _file = "Path";
	public static final String _count = "Counter";
	public static final String _output = "Anagrams";
	public static final String _btnBrowse = "Browse";
	public static final String _btnSearch = "Search";
	public static final String _btnClose = "Close";
	public static final String _OK = "OK";
	public static final String _lbl_word = "Words";
	public static final String _lbl_ang = "Anagrams";

	public static final String _menFile = "File";
	public static final String _menQuit = "Quit";
	public static final String _menHelp = "Help";
	public static final String _menAbout = "About";

	public static final String _pathSTD = "./";

	public static final String _aboutTxt = "<html><br><br><b>Author</b><br>Lukas Larsed<br><a href='mailto:lukas.larsed@gmail.com'>lukas.larsed@gmail.com</a><br><a href='http://github.com/ldlarsed'>http://github.com/ldlarsed</a><br><br> Finds the one-word anagrams in selected text file.</html>";
	public static final String _fileLoadMessage = "\nFile is loaded. Click SEARCH to find anagrams";
	public static final String _errorMessage1 = "Please select a file first";
	public static final String _errorMessage2 = "Please choose a file...";

	/**
	 * For ruled based collator
	 * Source: http://docs.oracle.com/javase/8/docs/api/java/text/RuleBasedCollator.html
	 */
	public static final String _nbCollatorRule = "< a, A < b, B < c, C < d, D < e, E < f, F < g, G < h, H < i, I"
			+ "< j, J < k, K < l, L < m, M < n, N < o, O < p, P < q, Q < r, R"
			+ "< s, S < t, T < u, U < v, V < w, W < x, X < y, Y < z, Z"
			+ "< \u00E6, \u00C6" + // Latin letter ae & AE
			"< \u00F8, \u00D8" + // Latin letter o & O with stroke
			"< \u00E5 = a\u030A," + // Latin letter a with ring above
			"  \u00C5 = A\u030A;" + // Latin letter A with ring above
			"  aa, AA";
}
