package com.example.entrevueSpringBoot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entrevueSpringBoot.bean.entity.MovieEntity;

/**
 * The movie CRUD repository.
 */
@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Long> {
}
