package com.example.tms.building_expertise.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuildingsData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private String date;
    private String year;
    private String floors;
    private String construct;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buildingsData")
    private List<Defects> defects = new ArrayList<>();
    private Long previewDefectsId;
    private LocalDateTime dateOfCreated;

    @PrePersist
    private void init(){
        dateOfCreated = LocalDateTime.now();
    }

    public void addDefectsToBuildings(Defects defect) {
        defect.setBuildingsData(this);
        defects.add(defect);
    }


}
