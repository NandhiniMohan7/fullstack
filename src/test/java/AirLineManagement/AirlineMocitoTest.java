package AirLineManagement;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import AirLineManagement.Entity.Airline;
import AirLineManagement.Repository.AirlineRepository;
import AirLineManagement.Service.AirlineService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirlineMocitoTest {

    @Mock
    private AirlineRepository airlineRepository;

    @InjectMocks
    private AirlineService airlineService;

    public Airline airline;

    @BeforeEach
    public void createData() {
        airline = new Airline(1l, "indigo");
    }

    @Test
    public void fetchById() {
        when(airlineRepository.findById(1l)).thenReturn(Optional.of(airline));
        assertEquals(airline, airlineService.getAirlineById(1l));
    }
}
