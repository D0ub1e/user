package com.hkwy.dao;

import com.hkwy.model.Page;

import java.util.List;

/**
 * Created by double on 16-12-19.
 */
public interface IBaseDao<T> {
    public void add (T t);
    public void delete(int id);
    public void update(T t);
    public T load(int id);
    public List<T> list();
    public Page<T> pages();
}
