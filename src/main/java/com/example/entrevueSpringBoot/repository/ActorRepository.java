package com.example.entrevueSpringBoot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entrevueSpringBoot.bean.entity.ActorEntity;

/**
 * The actor CRUD repository.
 */
@Repository
public interface ActorRepository extends CrudRepository<ActorEntity, Long> {
}
