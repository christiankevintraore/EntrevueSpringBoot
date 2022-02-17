package com.example.entrevueSpringBoot.mapper;

import org.mapstruct.Mapper;

import com.example.entrevueSpringBoot.bean.dto.ActorDTO;
import com.example.entrevueSpringBoot.bean.entity.ActorEntity;
import com.example.entrevueSpringBoot.mapper.generic.GenericMapper;


@Mapper(componentModel = "spring")
public interface ActorMapper extends GenericMapper<ActorEntity, ActorDTO> {
}
