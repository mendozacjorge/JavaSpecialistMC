package uaq.cds.jsmc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author Jorge
 * @param <T>
 */
public class LeftRightInsert2<T> {

	private final LinkedList<T> ITEMS;
	private boolean isLeft = true;
	/**
	 * key -> element id (consecutive) in the order they were inserted
	 * value -> position within the list (index)
	 */
	private final Map<Integer, Integer> ELEM_POS_MAP = new HashMap<>();
	
	public LeftRightInsert2() {
		ITEMS = new LinkedList<>();
	}
	
	public void add(T object) {
		if (isLeft)
			ITEMS.addFirst(object);
		else
			ITEMS.addLast(object);
		
		updateElemPosMap();
		isLeft = !isLeft;
	}
	
	public int getSize() {
		return ITEMS.size();
	}
	
	public T get(int idx) {
		return ITEMS.get(idx);
	}
	
	public Map<Integer, Integer> getMap() {
		return ELEM_POS_MAP;
	}
	
	private void updateElemPosMap() {
		// -1 porque ya se inserto el elemento
		int elemId = ITEMS.size() - 1;
		if (isLeft) {
			for (Integer id : ELEM_POS_MAP.keySet())
				ELEM_POS_MAP.put(id, ELEM_POS_MAP.get(id) + 1);
			ELEM_POS_MAP.put(elemId, 0);
		} else {
			ELEM_POS_MAP.put(elemId, elemId);
		}
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
		private boolean hasNext;
		private int currentIteration = 0;
		
		Iter(LinkedList<T> items) {
			this.ITEMS = items;			
			hasNext = ITEMS.size() > 0;
		}
		
		@Override
		public boolean hasNext() {
			return hasNext;
		}
		
		@Override
		public T next() {
			int currElemIdx = ELEM_POS_MAP.get(currentIteration);
			currentIteration++;
			hasNext = currentIteration < ITEMS.size();
			return ITEMS.get(currElemIdx);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Not supported yet.");
		}
		
	}
		
	
}
