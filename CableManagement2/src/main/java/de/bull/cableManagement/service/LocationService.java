package de.bull.cableManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.bull.cableManagement.entity.Cable;
import de.bull.cableManagement.entity.Location;
import de.bull.cableManagement.repository.LocationDao;
@Service	//hier muss man unbeding getter setter for dao haben
public class LocationService {
	@Autowired
	private LocationDao locationDao;
	
	public List<Location> findByName(String name) {
	/*	System.out.println("location service "+name);
		System.out.println("locationDao: "+locationDao);*/
		List<Location> res = locationDao.findByName(name);
		
		return res;
	}
	
	public void deleteByName(String name){
		Location l= locationDao.findByName(name).get(0);
		locationDao.delete(l);
	}
	public void deleteById(Long id){
		Location l= locationDao.findById(id).get(0);
		locationDao.delete(l);
	}
	public void deleteCable(Cable c){
		
		
	}
	
	public void saveLocation(Location location){
		System.out.println(location);
		//System.out.println(location.getName()+" "+location.getRoomNr());
		Location newLocation = new Location();
		newLocation.setName(location.getName());
		//newLocation.setRoomNr(location.getName());
		locationDao.save(location);
	}


	public LocationDao getLocationDao() {
		return locationDao;
	}


	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}
	

}
