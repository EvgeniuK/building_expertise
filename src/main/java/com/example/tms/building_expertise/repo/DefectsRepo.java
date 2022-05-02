package com.example.tms.building_expertise.repo;

import com.example.tms.building_expertise.models.Defects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefectsRepo extends JpaRepository <Defects, Long> {
}
