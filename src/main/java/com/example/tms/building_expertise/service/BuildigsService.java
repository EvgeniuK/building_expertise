package com.example.tms.building_expertise.service;

import com.example.tms.building_expertise.models.BuildingsData;
import com.example.tms.building_expertise.models.Defects;
import com.example.tms.building_expertise.repo.BuildingsDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class BuildigsService {
    private final BuildingsDataRepository buildingsDataRepository;

    public void saveBuildings(BuildingsData buildingsData,
                              MultipartFile file1,
                              MultipartFile file2,
                              MultipartFile file3) throws IOException {
        Defects image1;
        Defects image2;
        Defects image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreview(true);
            buildingsData.addDefectsToBuildings(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            buildingsData.addDefectsToBuildings(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            buildingsData.addDefectsToBuildings(image3);
        }
        BuildingsData buildingsDataFromDB = buildingsDataRepository.save(buildingsData);
        buildingsDataFromDB.setPreviewDefectsId(buildingsDataFromDB.getDefects().get(0).getId());
        buildingsDataRepository.save(buildingsData);
    }

    private Defects toImageEntity(MultipartFile file) throws IOException {
        Defects image = new Defects();
        image.setName(file.getName());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setOriginalFileName(image.getOriginalFileName());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteBuildings(Long id) {
        buildingsDataRepository.deleteById(id);
    }

    public BuildingsData getBuildingsId(Long id) {
        return buildingsDataRepository.findById(id).orElse(null);
    }

}
