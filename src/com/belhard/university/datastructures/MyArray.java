package com.belhard.university.datastructures;

public class MyArray<T> implements MyIterable<T> {
	private Object[] array;
	public static final int INITIAL_ARRAY_SIZE = 0;
	public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;

	public MyArray() {
		super();
		array = new Object[INITIAL_ARRAY_SIZE];
	}

	public MyArray(T[] array) {
		super();
		this.array = array;
	}

	@Override
	public int size() {
		return array.length;
	}

	@Override
	public boolean add(T obj) {
		if (!contains(obj) && array.length < MAX_ARRAY_SIZE && obj != null) {
			Object[] newArray = new Object[array.length + 1];
			newArray[newArray.length - 1] = obj;
			for (int i = 0; i < array.length; i++)
				newArray[i] = array[i];
			array = newArray;
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(T obj) {
		boolean removed = false;
		if (obj != null) {
			for (int i = 0; i < array.length; i++) {
				if (array[i].equals(obj)) {
					array[i] = null;
					removed = true;
				}
				if (removed && i < array.length - 1)
					array[i] = array[i + 1];
			}
		}
		return removed;
	}

	@Override
	public boolean contains(T obj) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(obj))
				return true;
		}
		return false;
	}

	@Override
	public T get(int index) {
		if (index >= 0 && index < array.length)
			return (T) array[index];
		return null;
	}

	@Override
	public T[] toArray() {
		if (array.length != 0)
			return (T[]) array;
		return null;
	}

}
