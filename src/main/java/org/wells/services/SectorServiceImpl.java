/*
 * abhishek360
 */

package org.wells.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wells.models.Sector;
import org.wells.repositories.CompanyRepository;
import org.wells.repositories.SectorRepository;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SectorServiceImpl implements SectorService {
    @Autowired
    SectorRepository sectorRepository;
    @Autowired
    CompanyRepository companyRepository;

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
    public Map<String, Object> getCompaniesBySectorId(String id) {
        int sectorId = Integer.parseInt(id);
        Sector sector = sectorRepository.findOne(sectorId);
        Map<String, Object> res = new HashMap<>();
        res.put("sectorId", sector.getSectorId());
        res.put("sectorName", sector.getSectorName());
        res.put("companies", sector.getCompanies());

        return res;
    }

    @Override
    public Map<String, Object> sectorCompanyAvgPriceOnAnyExchange(String id, String startDate, String endDate) {
        int sectorId = Integer.parseInt(id);
        Date start = Date.valueOf(startDate);
        Date end = Date.valueOf(endDate);
        Map<String, Object> res = new HashMap<>();
        Sector sector = sectorRepository.findOne(sectorId);

        res.put("sectorId", sector.getSectorId());
        res.put("sectorName", sector.getSectorName());
        res.put("companies", companyRepository.getStockPriceInDateRange(start, end, sectorId));
        return res;
    }
}
