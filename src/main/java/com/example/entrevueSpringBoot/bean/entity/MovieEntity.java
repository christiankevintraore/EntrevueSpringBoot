package com.example.entrevueSpringBoot.bean.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Movie")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MovieEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String titre;
	private String description;
	
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH },
				fetch = FetchType.EAGER)
	@JoinTable(
        name = "Movie_Actor", 
        joinColumns = { @JoinColumn(name = "movie_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "actor_id") }
    )
	private Set<ActorEntity> acteurs;
	
}
