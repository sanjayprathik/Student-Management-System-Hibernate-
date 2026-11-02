package com.student.dao;
import java.util.*;

public interface GenericDAO<T,ID> {
	
	void save(T entity);
	
	T findById(ID id);
	
	List<T> findAll();
	
	void update(T entity);
	
	void delete(ID id);

}
