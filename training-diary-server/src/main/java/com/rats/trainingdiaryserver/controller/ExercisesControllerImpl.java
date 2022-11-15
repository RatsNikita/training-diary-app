package com.rats.trainingdiaryserver.controller;


import com.rats.trainingdiaryserver.api.ExerciseController;
import com.rats.trainingdiaryserver.dto.ExerciseDto;
import com.rats.trainingdiaryserver.entity.MuscleGroup;
import com.rats.trainingdiaryserver.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExercisesControllerImpl implements ExerciseController {


  private final ExerciseService service;


  @Override
  public ResponseEntity<?> createExercise(ExerciseDto exerciseDto) {
    return service.createExercise(exerciseDto);
  }

  @Override
  public ResponseEntity<List<ExerciseDto>> getAllExercises() {
    return service.getAllExercises();
  }

  @Override
  public ResponseEntity<List<ExerciseDto>> getExercisesByMuscleGroup(MuscleGroup muscleGroup) {
    return service.getExercisesByMuscleGroup(muscleGroup);
  }

  @Override
  public ResponseEntity<ExerciseDto> getExerciseById(Long id) {
    return service.getExercise(id);
  }

  @Override
  public ResponseEntity<?> deleteExerciseById(Long id) {
    return service.deleteExercise(id);
  }
}
