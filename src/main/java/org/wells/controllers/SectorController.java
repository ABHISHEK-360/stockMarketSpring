/*
 * abhishek360
 */

package org.wells.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wells.models.Sector;
import org.wells.repositories.SectorRepository;

import java.util.List;

@RestController
public class SectorController {
    @Autowired
    SectorRepository sectorRepository;

    @GetMapping("/sector")
    public List<Sector> sectors(){
        return sectorRepository.findAll();
    }

    @GetMapping("/sector/{id}")
    public Sector sectorCompanies(@PathVariable String id){
        int sectorId = Integer.parseInt(id);
        return sectorRepository.findOne(sectorId);
    }
}
