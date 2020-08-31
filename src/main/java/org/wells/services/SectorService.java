/*
 * abhishek360
 */

package org.wells.services;

import org.wells.models.Sector;
import java.util.List;
import java.util.Map;

public interface SectorService {
    Sector createSector(String name, String brief);
    Sector updateSector(String id, String name, String brief);
    boolean deleteSector(String id);
    List<Sector> getSectors();
    Sector sectorById(String id);
    Map<String, Object> sectorCompanyAvgPriceOnAnyExchange(String id, String startDate, String endDate);
}
