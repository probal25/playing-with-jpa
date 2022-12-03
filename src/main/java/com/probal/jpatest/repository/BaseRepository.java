package com.probal.jpatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    @Override
    @Query("select e from #{#entityName} e where e.deleted = false")
    public List<T> findAll();

    @Query("select e from #{#entityName} e where e.deleted = true")
    public List<T> recycleBin();

    @Modifying
    @Query("update #{#entityName} e set e.deleted = true where e.id = ?1")
    public void softDelete(Long id);
}
