package com.example.entrevueSpringBoot.service.dbsynchronizer.impl;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entrevueSpringBoot.bean.entity.MovieEntity;
import com.example.entrevueSpringBoot.repository.ActorRepository;
import com.example.entrevueSpringBoot.service.dbsynchronizer.ActorSynchronizer;

/**
 * The default implementation of actor synchronizer.
 */
@Component
public class ActorSynchronizerImpl implements ActorSynchronizer {

	@Autowired
	protected ActorRepository actorRepository;


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void synchActors(final MovieEntity movieEntity) throws NoSuchElementException {
		if(movieEntity.getActeurs() != null) {
			movieEntity.setActeurs(movieEntity.getActeurs().stream()
					.map(unmanagedActor -> {
						if(unmanagedActor.getId() == null) {
							return unmanagedActor;
						} else {
							return actorRepository.findById(unmanagedActor.getId())
									.orElseThrow(() ->
									new NoSuchElementException("Unable to find actor with id : "
											.concat(unmanagedActor.getId().toString())));
						}})
					.collect(Collectors.toSet()));
		}
	}

}
