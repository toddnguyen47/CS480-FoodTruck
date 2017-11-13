package edu.csupomona.cs480.data.repository;

import org.springframework.data.repository.CrudRepository;
import edu.csupomona.cs480.data.TruckInfo;

import java.util.List;

public interface TruckRepository extends CrudRepository<TruckInfo, Integer> {

    List<TruckInfo> findByName(String name);

	
}