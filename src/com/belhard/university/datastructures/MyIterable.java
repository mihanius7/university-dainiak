package com.belhard.university.datastructures;

public interface MyIterable {
	int size();

	boolean add(Object obj);

	boolean remove(Object obj);

	boolean contains(Object obj);

	Object get(int index);

	Object[] toArray();

}
