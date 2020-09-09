/*
 * abhishek360
 */

package org.wells;/*
 * abhishek360
 */

/*
 * abhishek360
 */

/*
 * abhishek360
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wells.models.Sector;
import org.wells.services.SectorService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

//@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SectorServiceTest {
    @Autowired
    SectorService sectorService;

    @Test
    public void whenNameProvided_thenCreateSector(){
        Sector sectorTest = sectorService.createSector("Test Sector", "Sector for running test");
        Assert.assertNotNull(sectorTest);
        Assert.assertNotNull(sectorTest.getSectorName());
    }

    @Test
    public void retrieveSectors(){
        List<Sector> sectorsTest = sectorService.getSectors();
        Assert.assertNotNull(sectorsTest);
        for(Sector sector : sectorsTest){
            Assert.assertNotNull(sector);
            Assert.assertNotNull(sector.getSectorName());
        }
    }

    @Test
    public void whenSectorIdProvided_thenRetrievedSectorDetails(){
        Map<String, Object> sectorDetailsTest = sectorService.getCompaniesBySectorId("1");
        Assert.assertEquals(1, sectorDetailsTest.get("sectorId"));
        Assert.assertNotNull(sectorDetailsTest.get("companies"));
    }

    @Test
    @Transactional
    public void retrieveSectorCompaniesAvgPrice_whenSectorIdProvided(){
        Map<String, Object> sectorCompaniesPriceTest = sectorService.sectorCompanyAvgPriceOnAnyExchange("1", "2020-08-20", "2020-09-30");
        Assert.assertEquals(1, sectorCompaniesPriceTest.get("sectorId"));
        Assert.assertNotNull(sectorCompaniesPriceTest.get("companies"));
        List<Object> companiesTest = (List<Object>)sectorCompaniesPriceTest.get("companies");
        for(Object company : companiesTest) {
            Map<String, Object> companyTest = (Map<String, Object>)company;
            Assert.assertNotNull(companyTest.get("averagePrice"));
        }

    }
}
