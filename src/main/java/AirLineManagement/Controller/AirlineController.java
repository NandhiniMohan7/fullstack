package AirLineManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AirLineManagement.Entity.Airline;
import AirLineManagement.Entity.Flight;
import AirLineManagement.Exception.FlightNotAvailableException;
import AirLineManagement.Service.AirlineService;

@RestController
@RequestMapping("/airlines")
public class AirlineController {
	
	 @Autowired
	    private AirlineService airlineService;

	    @PostMapping("/save")
	    public ResponseEntity<Airline> saveAirlineWithFlights(@RequestBody Airline airline) throws FlightNotAvailableException {
	        Airline savedAirline = airlineService.saveAirlineWithFlights(airline);
	        return ResponseEntity.ok(savedAirline);
	    }

	    @GetMapping("/allData")
	    public List<Airline> getAllAirlines() {
	        return airlineService.getAllAirlines();
	    }

	    @GetMapping("/Airline/{id}")
	    public ResponseEntity<Airline> getAirlineById(@PathVariable Long id) {
	        Airline airline = airlineService.getAirlineById(id);
	        return ResponseEntity.ok(airline);
	    }
	    
	    @GetMapping("/Flight/{id}")
	    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
	        Flight flight = airlineService.getFlightById(id).orElseThrow(() -> new FlightNotAvailableException("Airline not found"));
	        return ResponseEntity.ok(flight);
	    }

	    @PutMapping("/updateAirline/{id}")
	    public ResponseEntity<Airline> updateAirline(@PathVariable Long id, @RequestBody Airline airlineDetails) throws FlightNotAvailableException {
	        Airline updatedAirline = airlineService.updateAirline(id, airlineDetails);
	        return ResponseEntity.ok(updatedAirline);
	    }

	    @DeleteMapping("/deleteAirlines/{id}")
	    public void deleteFlight(@PathVariable Long id) {
	        airlineService.deleteFlight(id);
	      
	    }

	   
	   @PutMapping("/updateFlight/{id}")
	    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flightDetails) {
	        Flight updatedFlight = airlineService.updateFlight(id, flightDetails);
	        return ResponseEntity.ok(updatedFlight);
	    }

}
