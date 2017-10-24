package edu.csupomona.cs480.data.provider;
import org.springframework.data.repository.CrudRepository;
import edu.csupomona.cs480.data.TruckInfo;

public interface TruckRepository extends CrudRepository<TruckInfo, Integer> {
	
}
