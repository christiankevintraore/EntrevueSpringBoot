package com.example.entrevueSpringBoot.mapper.generic;

public interface GenericMapper<EntityType, DtoType> {

	public DtoType entityToDto(final EntityType entityType);
	public EntityType dtoToEntity(final DtoType dtoType);
	
}
