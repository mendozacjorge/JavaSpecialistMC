package uaq.cds.jsmc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Jorge
 * @param <T>
 */
public class LeftRightInsert<T> {

	private final LinkedList<T> ITEMS;
	private boolean isLeft = true;
	
	public LeftRightInsert() {
		ITEMS = new LinkedList<>();
	}
	
	public void add(T object) {
		if (isLeft)
			ITEMS.addFirst(object);
		else
			ITEMS.addLast(object);
		isLeft = !isLeft;
	}
	
	public int size() {
		return ITEMS.size();
	}
	
	@Override
	public String toString() {
		return Arrays.deepToString(ITEMS.toArray());
	}
	
	public Iterator<T> iterator() {
		return new Iter(ITEMS);
	}
	
	private class Iter implements Iterator<T> {
			
		private final LinkedList<T> ITEMS;
		private int leftElemPos;
		private int rightElemPos;
		private boolean leftRetrieved;
		private boolean hasNext;
		
		Iter(LinkedList<T> items) {
			this.ITEMS = items;
			leftElemPos = Math.round(items.size() / 2f) - 1;
			rightElemPos = leftElemPos + 1;
			leftRetrieved = false;
			hasNext = ITEMS.size() > 0;
		}
		
		@Override
		public boolean hasNext() {
			return hasNext;
		}
		
		@Override
		public T next() {
			T elem;
			if (leftRetrieved) {
				elem = ITEMS.get(rightElemPos);
				rightElemPos++;
			} else {
				elem = ITEMS.get(leftElemPos);
				leftElemPos--;
			}
			leftRetrieved = !leftRetrieved;
			hasNext = leftElemPos > -1 || rightElemPos < ITEMS.size();
			return elem;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Not supported yet.");
		}
		
	}
		
}
