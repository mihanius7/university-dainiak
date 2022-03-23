package com.belhard.university.datastructures;

public class MyArray implements MyIterable {
	Object[] array;
	public static final int INITIAL_ARRAY_SIZE = 0;
	public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;

	public MyArray() {
		super();
		array = new Object[INITIAL_ARRAY_SIZE];
	}

	public MyArray(Object[] array) {
		super();
		this.array = array;
	}

	@Override
	public int size() {
		return array.length;
	}

	@Override
	public boolean add(Object obj) {
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
	public boolean remove(Object obj) {
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
	public boolean contains(Object obj) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(obj))
				return true;
		}
		return false;
	}

	@Override
	public Object get(int index) {
		if (index >= 0 && index < array.length)
			return array[index];
		return null;
	}

	@Override
	public Object[] toArray() {
		if (array.length != 0)
			return array;
		return null;
	}

}
