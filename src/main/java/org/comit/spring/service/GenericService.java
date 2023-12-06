package org.comit.spring.service;

import java.util.List;

public interface GenericService<T> {

	T findById(int id);

    List<T> findAll();

    T save(T t);

    T updateById(T t, int id);

    void deleteById(int id);
}
