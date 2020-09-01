/*
 * abhishek360
 */

package org.wells;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.wells.controllers.SectorController;
import org.wells.models.Sector;
import org.wells.services.SectorService;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(SectorController.class)
public class SectorControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SectorService sectorService;
	
	@Test
	public void fetchAllSectorsBasic() throws Exception {
		Sector sect1=new Sector();
		Sector sect2=new Sector();
		Sector sect3=new Sector();
		sect1.setSectorId(1);
		sect1.setSectorName("Banking");
		sect1.setBrief("Related to banking");
		sect2.setSectorId(2);
		sect2.setSectorName("Automobiles");
		sect2.setBrief("Related to automobile companies");
		sect3.setSectorId(3);
		sect3.setSectorName("HealthCare");
		sect3.setBrief("Related to medical and health care");
		when(sectorService.getSectors()).thenReturn(Arrays.asList(sect1,sect2,sect3));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/sectors")).andExpect(status().isOk())
				.andExpect(content().json("[{},{},{}]"));
				
	}
	
	@Test
	public void fetchAllSectorsEmpty() throws Exception {
		when(sectorService.getSectors()).thenReturn(Collections.emptyList());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/sectors"))
				.andExpect(status().isOk())
				.andExpect(content().json("[]"));
	}
	
}
