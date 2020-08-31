/*
 * abhishek360
 */

package org.wells.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.wells.models.Sector;

import java.util.List;

public interface SectorRepository extends JpaRepository<Sector, Integer> {

}
