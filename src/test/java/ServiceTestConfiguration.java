/*
 * abhishek360
 */

/*
 * abhishek360
 */

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.wells.services.SectorService;

@Profile("test")
@Configuration
public class ServiceTestConfiguration {
    @Bean
    @Primary
    public SectorService sectorService() {
        return Mockito.mock(SectorService.class);
    }
}
