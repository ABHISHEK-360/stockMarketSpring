/*
 * abhishek360
 */

package org.wells.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.wells.models.Company;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("SELECT c.companyName AS CompanyName, c.companyId AS CompanyId, AVG(s.price) AS AveragePrice " +
            "FROM Company c JOIN c.stockPrices s JOIN c.sector sec " +
            "WHERE s.date BETWEEN ?1 AND ?2 AND sec.sectorId = ?3 GROUP BY c.companyId")
    List<Map<String, Object>> getStockPriceInDateRange(Date startDate, Date endDate, int sectorId);
}
