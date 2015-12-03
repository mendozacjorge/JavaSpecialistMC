package uaq.cds.jsmc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Jorge
 * @param <T>
 */
public class LeftRightInsertJSMC<T> {

	private final LinkedList<T> ITEMS;
	private boolean isLeft = true;
	
	public LeftRightInsertJSMC() {
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
		private final int SIZE;
		private int elements;
		private int position;
		private boolean isLeft;
		
		Iter(LinkedList<T> items) {
			this.ITEMS = items;
			SIZE = ITEMS.size();
			elements = 0;
			position = (SIZE - 1) / 2;
			isLeft = true;
		}
		
		@Override
		public boolean hasNext() {
			return elements < SIZE;
		}
		
		@Override
		public T next() {
			T t = ITEMS.get(position);
			elements++;
			if (isLeft) position += elements;
			else position -= elements;
			isLeft = !isLeft;
			return t;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Not supported yet.");
		}
		
	}
		
}
