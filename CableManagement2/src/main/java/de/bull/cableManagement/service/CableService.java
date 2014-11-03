package de.bull.cableManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.bull.cableManagement.entity.Cable;
import de.bull.cableManagement.entity.Location;
import de.bull.cableManagement.repository.CableDao;
@Service	//hier muss man unbeding getter setter for dao haben
public class CableService {
	@Autowired
	private CableDao cableDao;
	public List<Cable> findByLocation(Location location){
		List<Cable> res = cableDao.findByLocation(location);
		return res;
	}
	public List<Cable> findByName(String name){
		List<Cable> wut = cableDao.findByName(name);
		return wut;
	}
	/*public void updateByName(String name){
		Cable c=cableDao.findByName(name).get(0);
		cableDao.update(c);
	}*/
	public void deleteById(Long id){
		Cable c= cableDao.findById(id).get(0);
		cableDao.delete(c);
	}
	public void deleteByName(String name){
		Cable c= cableDao.findByName(name).get(0);
		cableDao.delete(c);
	}
	public void delete(Cable cable){
		cableDao.delete(cable);
	}
	public List<Cable> findByID(Long id){
		List<Cable> wut2 = cableDao.findById(id);
		return wut2;
	}
	public void saveCable(Cable cable){
		cableDao.saveAndFlush(cable);
	}
	public CableDao getCableDao() {
		return cableDao;
	}
	public void setCableDao(CableDao cableDao) {
		this.cableDao = cableDao;
	}
	
}
