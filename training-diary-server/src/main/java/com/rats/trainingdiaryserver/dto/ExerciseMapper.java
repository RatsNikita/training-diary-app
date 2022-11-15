package com.rats.trainingdiaryserver.dto;

import com.rats.trainingdiaryserver.entity.ExerciseEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ExerciseMapper {

  ExerciseDto toDto(ExerciseEntity entity);

  ExerciseEntity toEntity(ExerciseDto dto);

  List<ExerciseEntity> toEntityList(List<ExerciseDto> list);

  List<ExerciseDto> toDtoList(List<ExerciseEntity> list);
}
