package de.bull.cableManagement.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import de.bull.cableManagement.entity.Cable;
import de.bull.cableManagement.entity.Location;

import java.util.List;
import java.lang.String;
import java.lang.Long;

public interface CableDao extends JpaRepository<Cable, Serializable>{
	List<Cable> findByLocation(Location location);
	List<Cable> findByName(String name);
	List<Cable> findById(Long id);
	//public void update(Cable arg0);
	@Override
	public void delete(Cable arg0);
}
