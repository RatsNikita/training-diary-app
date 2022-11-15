package com.rats.trainingdiaryserver.entity;


import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Data
@Entity

public class ExerciseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true)
  private String name;
  @Enumerated(EnumType.STRING)
  private MuscleGroup muscleGroup;
  @Enumerated(EnumType.STRING)
  private ExerciseDifficulty difficulty;

}
