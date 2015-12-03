package uaq.cds.jsmc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Jorge
 * @param <T>
 */
public class LeftRightInsertJSMC2<T> {

	private final LinkedList<T> ITEMS;
	private boolean isLeft = true;

	public LeftRightInsertJSMC2() {
		ITEMS = new LinkedList<>();
	}

	public void add(T object) {
		if (isLeft) {
			ITEMS.addFirst(object);
		} else {
			ITEMS.addLast(object);
		}
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
		return new Iterator<T>() {
			
			private final int SIZE = ITEMS.size();
			private int elements = 0;
			private int position = (SIZE - 1) / 2;
			private boolean isLeft = true;

			@Override
			public boolean hasNext() {
				return elements < SIZE;
			}

			@Override
			public T next() {
				T t = ITEMS.get(position);
				elements++;
				if (isLeft) {
					position += elements;
				} else {
					position -= elements;
				}
				isLeft = !isLeft;
				return t;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("Not supported yet.");
			}
		};
	}


}
