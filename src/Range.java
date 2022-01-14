import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * 
 *
 */
public class Range {
	/**
	 * Based on the first question, the first method must return an
	 * object iterator, since there are parameters start and end we 
	 * need to redefine the methods hasNext, and next!
	 * @param start
	 * @param end
	 * @return an object iterator (iterator as an anonynous class)
	 */ 
	public static Iterator<Integer> methode1(final int start, final int end) {
		return new Iterator<Integer>() {
			int i = start;

			@Override
			public boolean hasNext() {
				return i <= end;
			}

			@Override
			public Integer next() {
				if (!hasNext())
					throw new NoSuchElementException();
				return i++;

			}
		};
	}
/**
 * to be able to use foreach of the return values of panel2(here methode2)
 * the return values must be of type iterable
 * @param start
 * @param end
 * @return object of type iterable
 * the method iterator in the interface iterable must be redefined
 */
	public static Iterable<Integer> methode2(final int start, final int end) {
		return new Iterable<Integer>() {
			@Override
			public Iterator<Integer> iterator() {
				return methode1(start, end);
			}
		};
	}
/**
 * AbstractList is an interface that is supported by the marker interface RandomAccess
 * If we only redefine the methods get and size, the list that implement this interface 
 * would be non-modifiable. in addition this  interface implements iterable.
 * So in addition to get and size, we should redefine the method iterator as well.
 * @param start
 * @param end
 * @return
 */
	public static List<Integer> range(final int start, final int end) {
		if (start > end)
			throw new IllegalArgumentException();
		return new AbstractList<Integer>() {
			@Override
			public int size() {
				return end - start + 1;
			}

			@Override
			public Integer get(int index) {
				return start + index;
			}

			
			@Override
			public Iterator<Integer> iterator() {
				return methode1(start, end);
			}
		};
	}

	public static void main(String[] args) {
		Iterator<Integer> it0 = methode1(1, 5);
		//for (; it0.hasNext();)
			//System.out.println(it0.next()); // affiche 1 2 3 4 5
		//for (int i : methode2(1, 5))
			//System.out.println(i); // affiche 1 2 3 4 5
			
		// List<Integer> li = range(3,1);//UAE!
		List<Integer> li = range(-2, 2);// UAE!
		System.out.println(li);
		//li.set(1,3);
		System.out.println(li.size());// attention, doit renvoyer 5 !!!
		List<Integer> l = range(1, 5);
		System.out.println(l);
		System.out.println(l.size());
		System.out.println("--");
		//li.add(2);
		
		/*
		Iterator<Integer> it = range(2, 2).iterator();
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		*/
	}

}