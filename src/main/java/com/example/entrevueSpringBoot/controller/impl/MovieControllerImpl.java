package com.example.entrevueSpringBoot.controller.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.entrevueSpringBoot.bean.dto.MovieDTO;
import com.example.entrevueSpringBoot.controller.MovieController;
import com.example.entrevueSpringBoot.service.MovieService;

@RestController
@RequestMapping("/film")
public class MovieControllerImpl implements MovieController {
	
	@Autowired
	protected MovieService movieService;
	

	/**
	 * {@inheritDoc}
	 */
	@GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable("id") final Long id) {
        return Optional.ofNullable(movieService.findById(id))
                	   .map(movie -> ResponseEntity.ok().body(movie))
                	   .orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	/**
	 * {@inheritDoc}
	 */
	@PostMapping
    public ResponseEntity<MovieDTO> create(@RequestBody final MovieDTO movieDTO) {
		if(movieDTO.getId() != null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot recreate an existing movie", null);
		}
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(movieService.create(movieDTO));
		} catch (final NoSuchElementException noSuchElementException) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					noSuchElementException.getMessage(), noSuchElementException);
		}
    }
	
}
