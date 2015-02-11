import java.util.Comparator;

public class WordHashPair<K, V extends Comparable<? super V>> implements Comparable<WordHashPair<K, V>>, Comparator<WordHashPair<K, V>>{

	private K k;
	private V v;
	
	public WordHashPair(K k, V v) {
		this.k = k;
		this.v = v;
	}

	public K getK() {
		return k;
	}

	public void setK(K k) {
		this.k = k;
	}

	public V getV() {
		return v;
	}

	public void setV(V v) {
		this.v = v;
	}

	@Override
	public int compare(WordHashPair<K, V> o1, WordHashPair<K, V> o2) {
		return compare(o1, o2);
	}

	@Override
	public int compareTo(WordHashPair<K, V> o) {
		return v.compareTo(o.getV());
	}
}
