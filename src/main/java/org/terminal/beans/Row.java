package org.terminal.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Row<R> implements List<R>{
	List<R> values;
	public Row() {
		values = new ArrayList<>();
	}
	
	public Row(int columnCount) {
		values = new ArrayList<>(columnCount);
	}
	
	public Row(List<R> rs) {
		values = new ArrayList<>(rs.size());
		for (R r : rs) {
			values.add(r);
		}
	}
	
	public Row(R[] rs) {
		values = new ArrayList<>(rs.length);
		for (R r : rs) {
			values.add(r);
		}
	}

	@Override
	public int size() {
		return values.size();
	}

	@Override
	public boolean isEmpty() {
		return values.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return values.contains(o);
	}

	@Override
	public Iterator<R> iterator() {
		return values.iterator();
	}

	@Override
	public Object[] toArray() {
		return values.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return values.toArray(a);
	}

	@SuppressWarnings("unchecked")
	public void add(R... rs) {
		for (R r : rs) {
			add(r);
		}
	}
	
	@Override
	public boolean add(R e) {
		return values.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return values.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return values.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends R> c) {
		return values.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends R> c) {
		return values.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return values.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return values.retainAll(c);
	}

	@Override
	public void clear() {
		values.clear();
	}

	@Override
	public R get(int index) {
		return values.get(index);
	}

	@Override
	public R set(int index, R element) {
		return values.set(index, element);
	}

	@Override
	public void add(int index, R element) {
		values.add(index, element);
	}

	@Override
	public R remove(int index) {
		return values.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return values.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return values.lastIndexOf(o);
	}

	@Override
	public ListIterator<R> listIterator() {
		return values.listIterator();
	}

	@Override
	public ListIterator<R> listIterator(int index) {
		return values.listIterator(index);
	}

	@Override
	public List<R> subList(int fromIndex, int toIndex) {
		return values.subList(fromIndex, toIndex);
	}
	
}
