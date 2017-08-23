package com.sk.taxcalculator.dao;

public interface BaseDao<T> {

  public T persist(T entity);
  public T findById(Long id);
  public T update(long id, T entity);
}
