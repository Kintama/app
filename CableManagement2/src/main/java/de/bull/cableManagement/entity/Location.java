package de.bull.cableManagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="Location")
public class Location {
	@Id
//	@GenericGenerator(name = "generator", strategy = "increment")
//	@GeneratedValue(generator = "generator",strategy=GenerationType.AUTO)
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "LocationId")
	private Long id;												//ID
	@Column(name = "Name")
	private String name;											//name
	//@Column(name = "RoomNr")
	//private String roomNr;											//raum
	/*@Column(name = "Switch")
	private String switchh;											//switch
	@Column (name = "Port")
	private int port;												//port
	@Column (name = "Wo")
	private String wo;												//wo*/
	@OneToMany(mappedBy="location",cascade= CascadeType.ALL)
	private List<Cable> cables = new ArrayList<Cable>();
	
	//getters und setters
	
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
	/*public String getRoomNr() {
		return roomNr;
	}
	public void setRoomNr(String roomNr) {
		this.roomNr = roomNr;
	}*/
	public List<Cable> getCables() {
		return cables;
	}
	public void setCables(List<Cable> cables) {
		this.cables = cables;
	}
	
}
