/*
 * abhishek360
 */

/*
 * abhishek360
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.wells.MainApplication;
import org.wells.models.Company;
import org.wells.models.Sector;
import org.wells.services.SectorService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class SectorTest {
    @Autowired
    SectorService sectorService;

    @Test
    public void whenSectorIdProvided_thenRetrievedSectorDetails(){
        Company company1 = new Company();
        company1.setCompanyId(1);
        company1.setCompanyName("Big Company");
        company1.setTurnover("20 Mn");
        company1.setCeo("ABC XYZ");
        company1.setBoardOfDirectors("Abhishek, Rohit");
        company1.setWriteUp("Performing well");
        company1.setIpo(null);

        Company company2 = new Company();
        company2.setCompanyId(3);
        company2.setCompanyName("Go Back China");
        company2.setTurnover("10 Billion");
        company2.setCeo("AK Singhaniya");
        company2.setBoardOfDirectors("Anil, Sunil");
        company2.setWriteUp("random random random");
        company2.setIpo(null);

        List<Company> companies = new LinkedList<>();
        companies.add(company1);
        companies.add(company2);

        Sector sectorExpected = new Sector();
        sectorExpected.setSectorName("Medical");
        sectorExpected.setSectorId(1);
        sectorExpected.setBrief("Medical services like labs and medicine companies");
        sectorExpected.setCompanies(companies);

        Mockito.when(sectorService.getCompaniesBySectorId("1")).thenReturn(sectorExpected);
        Sector sectorDetailsTest = sectorService.getCompaniesBySectorId("1");
        Assert.assertEquals(sectorExpected, sectorDetailsTest);
    }
}
