package com.example.tms.building_expertise.controllers;

import com.example.tms.building_expertise.models.Defects;
import com.example.tms.building_expertise.repo.DefectsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
public class DefectsController {
    private final DefectsRepo defectsRepo;

    @GetMapping("/defects/{id}")
    private ResponseEntity<?> getDefectsById(@PathVariable Long id) {
        Defects image  = defectsRepo.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
