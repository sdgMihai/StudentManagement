package com.studentmanagement.studentmanagementauth.services;

import com.studentmanagement.studentmanagementauth.entities.HibernateObject;
import org.springframework.data.jpa.repository.JpaRepository;

public class HibernateHelper<T extends HibernateObject> {

    private final JpaRepository<T, Long> repository;

    public HibernateHelper(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public T findById(long id) {
        return repository.findById(id).orElse(null);
    }

    public T saveToRepository(T object) {
        T objectToFind = findById(object.getId());
        /* daca exista deja */
        if(objectToFind != null)
            return null;
        return repository.save(object);
    }

    public T update(long id, T object) {
        //if(id != object.getId())
        //    return null;
        return repository.saveAndFlush(object);
    }
}
