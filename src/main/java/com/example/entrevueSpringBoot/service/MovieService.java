package com.example.entrevueSpringBoot.service;

import com.example.entrevueSpringBoot.bean.dto.MovieDTO;

/**
 * Descriptor of the movie service.
 */
public interface MovieService {

	/**
	 * Search for a specific movie, null if not found.
	 * 
	 * @param id {@link String} : the movie id.
	 * 
	 * @return {@link MovieDTO} : the movie found.
	 */
    public MovieDTO findById(final Long id);
	
    /**
	 * Create a new movie.
	 * 
	 * @param movieDTO {@link MovieDTO} : the movie to create.
	 * 
	 * @return {@link MovieDTO} : the movie created, with new id.
	 */
    public MovieDTO create(final MovieDTO movieDTO);
	
}
