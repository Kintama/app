package de.bull.cableManagement.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import de.bull.cableManagement.entity.Location;
import java.lang.Long;
import java.util.List;
import java.lang.String;

public interface LocationDao extends JpaRepository<Location, Serializable>{
	List<Location> findById(Long id);
	List<Location> findByName(String name);
	//List<Location> findByRoomNr(String roomnr);
	@Override
	public <S extends Location> S save(S entity);
	@Override
	public void delete(Location arg0);
	
}
