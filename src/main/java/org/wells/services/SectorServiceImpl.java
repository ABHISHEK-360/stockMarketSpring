/*
 * abhishek360
 */

package org.wells.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wells.models.Sector;
import org.wells.repositories.SectorRepository;

import java.util.List;

@Service
public class SectorServiceImpl implements SectorService {
    @Autowired
    SectorRepository sectorRepository;

    @Override
    public Sector createSector(String name, String brief) {
        Sector sector = new Sector();
        sector.setSectorName(name);
        sector.setBrief(brief);

        return sectorRepository.save(sector);
    }

    @Override
    public Sector updateSector(String id, String name, String brief) {
        int sectorId = Integer.parseInt(id);
        Sector oldSector = sectorRepository.findOne(sectorId);
        oldSector.setSectorName(name);
        oldSector.setBrief(brief);

        return sectorRepository.save(oldSector);
    }

    @Override
    public boolean deleteSector(String id) {
        int sectorId = Integer.parseInt(id);
        sectorRepository.delete(sectorId);

        return true;
    }

    @Override
    public List<Sector> getSectors() {
        return sectorRepository.findAll();
    }

    @Override
    public Sector sectorById(String id) {
        int sectorId = Integer.parseInt(id);
        return sectorRepository.findOne(sectorId);
    }
}
