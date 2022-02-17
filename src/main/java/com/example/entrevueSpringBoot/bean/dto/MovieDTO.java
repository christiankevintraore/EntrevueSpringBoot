package com.example.entrevueSpringBoot.bean.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MovieDTO {
	
	private Long id;
	private String titre;
	private String description;
	private Set<ActorDTO> acteurs;
	
}
