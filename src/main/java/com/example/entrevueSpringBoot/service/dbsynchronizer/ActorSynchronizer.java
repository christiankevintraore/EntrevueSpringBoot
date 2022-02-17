package com.example.entrevueSpringBoot.service.dbsynchronizer;

import java.util.NoSuchElementException;

import com.example.entrevueSpringBoot.bean.entity.MovieEntity;

/**
 * Descriptor of the actors synchronizer.
 */
public interface ActorSynchronizer {

	/**
	 * Replace a movie existing actors by their managed beans.
	 * 
	 * @param movieEntity {@link MovieEntity} : the concerned movie.
	 * 
	 * @throws NoSuchElementException if found a non existing actor.
	 */
	public void synchActors(final MovieEntity movieEntity) throws NoSuchElementException;
	
}
