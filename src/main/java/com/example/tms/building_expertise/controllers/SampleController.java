package com.example.tms.building_expertise.controllers;

import com.example.tms.building_expertise.models.BuildingsData;
import com.example.tms.building_expertise.repo.BuildingsDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class SampleController {

    @Autowired
    private BuildingsDataRepository buildingsDataRepository;

    @GetMapping("/example1")
    public String example1(Model model) {
        return "example1";
    }

    @GetMapping("/example2")
    public String example2(Model model) {
        return "example2";
    }

    @GetMapping("/example3")
    public String example3(Model model) {
        return "example3";
    }

    @GetMapping("/example-all")
    public String example4(Model model) {
        return "example-all";
    }

    @GetMapping("/")
    public String expert(Model model) {
        return "expert-main";
    }

    @GetMapping("/sample")
    public String sample(Model model) {
        Iterable<BuildingsData> buildingsDats = buildingsDataRepository.findAll();
        model.addAttribute("buildingsDats", buildingsDats);
        return "sample";
    }

    @GetMapping("/sample/{id}")
    public String sampleDetalis(@PathVariable(value = "id") long id, Model model) {
        if (!buildingsDataRepository.existsById(id)) {
            return "redirect:/sample";
        }
        Optional<BuildingsData> buildingsData = buildingsDataRepository.findById(id);
        ArrayList<BuildingsData> res = new ArrayList<>();
        buildingsData.ifPresent(res::add);
        model.addAttribute("buildingsData", res);
        return "sample-detalis";
    }

    @GetMapping("/sample/{id}/edit")
    public String sampleEdit(@PathVariable(value = "id") long id, Model model) {
        if (!buildingsDataRepository.existsById(id)) {
            return "redirect:/sample";
        }
        Optional<BuildingsData> buildingsData = buildingsDataRepository.findById(id);
        ArrayList<BuildingsData> res = new ArrayList<>();
        buildingsData.ifPresent(res::add);
        model.addAttribute("buildingsData", res);
        return "sample-edit";
    }

    @PostMapping("/sample/{id}/edit")
    public String sampleBuildUpdate(@PathVariable(value = "id") long id,
                                    @RequestParam String address,
                                    @RequestParam String date,
                                    @RequestParam String year,
                                    @RequestParam String floors,
                                    @RequestParam String construct,
                                    Model model) {
        BuildingsData buildingsData = buildingsDataRepository.findById(id).orElseThrow();
        buildingsData.setAddress(address);
        buildingsData.setDate(date);
        buildingsData.setYear(year);
        buildingsData.setFloors(floors);
        buildingsData.setConstruct(construct);
        buildingsDataRepository.save(buildingsData);
        return "redirect:/sample";
    }

    @PostMapping("/sample/{id}/remove")
    public String deleteBuildings(BuildingsData buildingsData) {
        buildingsDataRepository.delete(buildingsData);
        return "redirect:/sample";
    }
}
