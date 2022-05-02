package com.example.tms.building_expertise.controllers;

import com.example.tms.building_expertise.models.BuildingsData;
import com.example.tms.building_expertise.service.BuildigsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class SampleServController {
    private final BuildigsService buildigsService;


    @GetMapping("/sample/add")
    public String sampleAdd(Model model) {
        return "sample-add";
    }

    @PostMapping("/sample/add")
    public String saveBuildings(@RequestParam("file1") MultipartFile file1,
                                @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3,
                                BuildingsData buildingsData) throws IOException {
        buildigsService.saveBuildings(buildingsData, file1, file2, file3);
        return "redirect:/sample";
    }

}
