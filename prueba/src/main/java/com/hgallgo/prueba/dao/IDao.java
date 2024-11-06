package com.hgallgo.prueba.dao;

import java.util.List;

public interface IDao <T>{
    T save(T t);
    T findById(Integer id);
    T update(T t);
    T delete(Integer id);
    List<T> findAll();
}
