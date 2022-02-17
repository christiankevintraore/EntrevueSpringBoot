package com.example.entrevueSpringBoot.controller;

import org.springframework.http.ResponseEntity;

import com.example.entrevueSpringBoot.bean.dto.MovieDTO;

/**
 * Descriptor of the movie service entry point.
 */
public interface MovieController {

	/**
	 * Search for a specific movie, bad request if not found.
	 * 
	 * @param id {@link String} : the movie id.
	 * 
	 * @return {@link ResponseEntity}<{@link MovieDTO}> : the movie found.
	 */
    public ResponseEntity<MovieDTO> findById(final Long id);
	
    /**
	 * Create a new movie.
	 * 
	 * @param movieDTO {@link MovieDTO} : the movie to create.
	 * 
	 * @return {@link ResponseEntity}<{@link MovieDTO}> : the movie created, with new id.
	 */
    public ResponseEntity<MovieDTO> create(final MovieDTO movieDTO);
	
}
