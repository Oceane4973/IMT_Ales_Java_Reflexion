package org.example;

import java.sql.Connection;

public abstract class DAO<T> {

    public Connection connect = ConnectionDatabase.getInstance();

    public abstract T find(long id);

    public abstract T create(T obj);

    public abstract T update(T obj);

    public abstract void delete(T obj);
}
