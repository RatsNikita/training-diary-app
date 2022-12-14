package com.rats.trainingdiaryserver.repository;

import com.rats.trainingdiaryserver.entity.MuscleGroup;
import com.rats.trainingdiaryserver.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {

  List<ExerciseEntity> findAllByMuscleGroup(MuscleGroup muscleGroup);

}
