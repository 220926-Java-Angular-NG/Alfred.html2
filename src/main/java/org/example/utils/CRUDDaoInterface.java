package org.example.utils;

import java.util.List;

public interface CRUDDaoInterface <T>{

    //DAO - Data Access Object
    /* A pattern that provides an abstract interface to
       some type of database or other persistence mechanism

       We are returning an int because we are returning the primary key of this newly added row */

       int create(T t);

       List<T> getAll();

       T getById(int id);

       T update(T t);

       boolean delete(T t);


}
