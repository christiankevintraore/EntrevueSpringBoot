package com.example.entrevueSpringBoot.mapper;

import org.mapstruct.Mapper;

import com.example.entrevueSpringBoot.bean.dto.MovieDTO;
import com.example.entrevueSpringBoot.bean.entity.MovieEntity;
import com.example.entrevueSpringBoot.mapper.generic.GenericMapper;


@Mapper(componentModel = "spring")
public interface MovieMapper extends GenericMapper<MovieEntity, MovieDTO> {
}
