package com.rats.trainingdiaryserver.api;

import com.rats.trainingdiaryserver.dto.ExerciseDto;
import com.rats.trainingdiaryserver.entity.MuscleGroup;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/api")
public interface ExerciseController {

  @PostMapping("/create")
  ResponseEntity<?> createExercise(@Valid ExerciseDto exerciseDto);

  @GetMapping("/getAll")
  ResponseEntity<List<ExerciseDto>> getAllExercises();

  @GetMapping("/getBy")
  ResponseEntity<List<ExerciseDto>> getExercisesByMuscleGroup(@PathParam("muscleGroup") MuscleGroup muscleGroup);

  @GetMapping("/get")
  ResponseEntity<ExerciseDto> getExerciseById(@PathParam("id") Long id);

  @DeleteMapping("/delete")
  ResponseEntity<?> deleteExerciseById(@PathParam("id") Long id);


}
