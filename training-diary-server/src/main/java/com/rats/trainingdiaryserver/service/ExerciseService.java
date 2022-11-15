package com.rats.trainingdiaryserver.service;

import com.rats.trainingdiaryserver.dto.ExerciseDto;
import com.rats.trainingdiaryserver.dto.ExerciseMapper;
import com.rats.trainingdiaryserver.entity.MuscleGroup;
import com.rats.trainingdiaryserver.entity.ExerciseEntity;
import com.rats.trainingdiaryserver.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@CommonsLog
public class ExerciseService {

  private final ExerciseRepository repository;
  private final ExerciseMapper mapper;

  public ResponseEntity<?> createExercise(ExerciseDto dto) {
    ExerciseEntity exerciseEntity = mapper.toEntity(dto);
    repository.save(exerciseEntity);
    log.trace("Exercise " + exerciseEntity.getName() + " was created");
    return ResponseEntity.ok().build();
  }

  public ResponseEntity<?> deleteExercise(Long id) {
    Optional<ExerciseEntity> exercise = repository.findById(id);
    repository.deleteById(id);
    log.trace("Exercise " + exercise.get().getName() + " was deleted");
    return ResponseEntity.ok().build();
  }

  public ResponseEntity<ExerciseDto> getExercise(Long id)  {
    return repository.findById(id)
            .map(exerciseEntity -> ResponseEntity.ok(mapper.toDto(exerciseEntity)))
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  public ResponseEntity<List<ExerciseDto>> getAllExercises() {
    List<ExerciseDto> exerciseDtos = mapper.toDtoList(repository.findAll());
    return ResponseEntity.ok(exerciseDtos);
  }

  public ResponseEntity<List<ExerciseDto>> getExercisesByMuscleGroup(MuscleGroup muscleGroup) {
    List<ExerciseDto> dtos = mapper.toDtoList(repository.findAllByMuscleGroup(muscleGroup));
    return ResponseEntity.ok(dtos);
  }
}
