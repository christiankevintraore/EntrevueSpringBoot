package com.example.entrevueSpringBoot.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entrevueSpringBoot.bean.dto.MovieDTO;
import com.example.entrevueSpringBoot.bean.entity.MovieEntity;
import com.example.entrevueSpringBoot.mapper.ActorMapper;
import com.example.entrevueSpringBoot.mapper.MovieMapper;
import com.example.entrevueSpringBoot.repository.MovieRepository;
import com.example.entrevueSpringBoot.service.MovieService;
import com.example.entrevueSpringBoot.service.dbsynchronizer.ActorSynchronizer;

@Service
@Transactional
/**
 * The default implementation of movie service.
 */
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	protected MovieRepository movieRepository;
	@Autowired
	protected ActorSynchronizer actorSynchronizer;
	
	@Autowired
	protected MovieMapper movieMapper;
	@Autowired
	protected ActorMapper actorMapper;
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MovieDTO findById(final Long id) {
		return movieRepository.findById(id).map(movie -> movieMapper.entityToDto(movie)).orElse(null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MovieDTO create(final MovieDTO movieDTO) {
		MovieEntity movieToSave = movieMapper.dtoToEntity(movieDTO);
		actorSynchronizer.synchActors(movieToSave);
		
		return movieMapper.entityToDto(movieRepository.save(movieToSave));
	}

}
