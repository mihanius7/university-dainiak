package com.belhard.university.datastructures;

public interface MyIterable<E> {
	int size();

	boolean add(E obj);

	boolean remove(E obj);

	boolean contains(E obj);

	E get(int index);

	E[] toArray();

}
