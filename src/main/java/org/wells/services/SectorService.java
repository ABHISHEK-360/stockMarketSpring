/*
 * abhishek360
 */

package org.wells.services;

import org.wells.models.Sector;
import java.util.List;

public interface SectorService {
    public abstract Sector createSector(String name, String brief);
    public abstract Sector updateSector(String id, String name, String brief);
    public abstract boolean deleteSector(String id);
    public abstract List<Sector> getSectors();
    public abstract Sector sectorById(String id);
}
