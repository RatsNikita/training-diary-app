package com.rats.trainingdiaryserver.dto;

import com.rats.trainingdiaryserver.entity.ExerciseDifficulty;
import com.rats.trainingdiaryserver.entity.MuscleGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ExerciseDto {

  private Long id;
  @NotBlank
  private String name;
  private MuscleGroup muscleGroup;
  private ExerciseDifficulty difficulty;
}
