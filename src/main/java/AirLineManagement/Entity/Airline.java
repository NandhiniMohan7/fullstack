package AirLineManagement.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Airline{
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;

	    
	    @OneToMany(mappedBy = "airline", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	    @JsonIgnoreProperties("airline")
	    private List<Flight> flights;

		public Airline() {
			super();
		}

		public Airline(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
			
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Flight> getFlights() {
			return flights;
		}

		public void setFlights(List<Flight> flights) {
			this.flights = flights;
		}
	    
	    

}
