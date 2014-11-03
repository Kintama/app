package de.bull.cableManagement.controller;


import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.bull.cableManagement.entity.Cable;
import de.bull.cableManagement.entity.Location;
import de.bull.cableManagement.repository.CableDao;
import de.bull.cableManagement.service.CableService;
import de.bull.cableManagement.service.LocationService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private CableService cableService;
	@Autowired
	private LocationService locationService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/
	
	//suchen nach Ort
	@RequestMapping(value = "/main", method = RequestMethod.GET)								
	public String locationGET(Locale locale, Model model
			,@ModelAttribute("location")	Location location, BindingResult result) {
		return "main";
	}
//	public String cableGET(Locale locale, Model model
//			,@ModelAttribute("cable")	Cable cable, BindingResult result) {
//		return "main";
//	}
	@RequestMapping(value = "/main2", method = RequestMethod.GET)
	public String cableGET(Locale locale, Model model
	,@ModelAttribute("cable")	Cable cable, BindingResult result) {
		return "main2";
}
	
	@RequestMapping(value = "/main", method = RequestMethod.POST)										//getLocation main
	public String locationPOST(Locale locale, Model model,
			@ModelAttribute("location")	Location location, BindingResult result) {
		logger.info(location.getName().toString());		//.toString()
		Location locationInDB = locationService.findByName(location.getName()).get(0);
//		logger.info(location.getId().toString());		//.toString()
		List<Cable> founded = cableService.findByLocation(locationInDB);
		logger.info(String.valueOf(founded.size()));
		model.addAttribute("RESULT", founded);
		return "main";
	}
	
//	public String cablePOST(Locale locale, Model model,
//				@ModelAttribute("cable")	Cable cable, BindingResult result) {
//			logger.info(cable.getName().toString());
//			//Cable cableInDB = cableService.findByName(cable.getName()).get(0);
//			List<Cable> founded = cableService.findByName(cable.getName());
//			logger.info(String.valueOf(founded.size()));
//			model.addAttribute("RESULT", founded);
//			return "main";
//		}
	@RequestMapping(value = "/main2", method = RequestMethod.POST)											//getCable main2
			public String cablePOST(Locale locale, Model model,
			@ModelAttribute("cable")	Cable cable, BindingResult result) {
		logger.info(cable.getName().toString());
		//Cable cableInDB = cableService.findByName(cable.getName()).get(0);
		List<Cable> founded = cableService.findByName(cable.getName());
		logger.info(String.valueOf(founded.size()));
		model.addAttribute("RESULT", founded);
		return "main2";
		}

		@RequestMapping(value = "/adminMain", method = RequestMethod.GET)										//adminSite get
		public String adminLocationGET(Locale locale, Model model
				,@ModelAttribute("location")	Location location, BindingResult result) {
			return "adminMain";
		}
		public String adminCableGET(Locale locale, Model model
				,@ModelAttribute("cable")	Cable cable, BindingResult result) {
			return "adminMain";
		}
	
		@RequestMapping(value = "/adminMain", method = RequestMethod.POST)										//admin suchen
		public String adminLocationPOST(Locale locale, Model model,
				@ModelAttribute("location")	Location location, BindingResult result) {
			logger.info(location.getName().toString());		//.toString()
			Location locationInDB = locationService.findByName(location.getName()).get(0);
	//		logger.info(location.getId().toString());		//.toString()
			List<Cable> founded = cableService.findByLocation(locationInDB);
	//		logger.info(String.valueOf(founded.size()));
			model.addAttribute("RESULT", founded);
			return "adminMain";
		}
		public String adminCablePOST(Locale locale, Model model,
				@ModelAttribute("cable")	Cable cable, BindingResult result) {
			logger.info(cable.getName().toString());
			//Cable cableInDB = cableService.findByName(cable.getName()).get(0);
			List<Cable> founded = cableService.findByName(cable.getName());
			logger.info(String.valueOf(founded.size()));
			model.addAttribute("RESULT", founded);
			return "adminMain";
		}
	
	//insertLocation
	@RequestMapping(value = "/insertLocation", method = RequestMethod.GET)
	public String insertLocation(Locale locale, Model model,@ModelAttribute("location") Location location) {
		return "insertLocation";
	}
	@RequestMapping(value = "/insertLocation", method = RequestMethod.POST)											//addLocation
	public String insertLocationPOST(Locale locale, Model model,@ModelAttribute("location") Location location) {
		logger.info(location.getName());
		//logger.info(location.getRoomNr());
		
		locationService.saveLocation(location);
		return "insertLocation";
	}
	
	//insertCable
	@RequestMapping(value = "/insertCable", method = RequestMethod.GET)
	public String insertCableGET(Locale locale, Model model, @ModelAttribute("cable") Cable cable,@RequestParam(required=false) String location) {
		return "insertCable";
	}
	@RequestMapping(value = "/insertCable", method = RequestMethod.POST)											//addCable
	public String insertCablePOST(Locale locale, Model model,@ModelAttribute("cable") Cable cable
			,@RequestParam(value="location", required=false) String location
	) {
//		logger.info(location);
//		Location locations=locationService.findByName(location).get(0);
		logger.info("Cable Post");
		logger.info(cable.getLocation().getName());
		Location locations=locationService.findByName(cable.getLocation().getName()).get(0);
		cable.setLocation(locations);
		cableService.saveCable(cable);
		logger.info("saved Cable");
		return "insertCable";
	}
	//delete Ort
		@RequestMapping(value = "/delete", method = RequestMethod.GET)										
		public String deleteLocationGET(Locale locale, Model model
				,@ModelAttribute("location")	Location location, BindingResult result) {
			return "delete";
		}
		
		@RequestMapping(value = "/delete", method = RequestMethod.POST)								//delete Ort
		public String deleteLocationPOST(Locale locale, Model model,
				@ModelAttribute("location")	Location location, BindingResult result) {
			logger.info(location.getName().toString());		//.toString()
			Location locationInDB = locationService.findByName(location.getName()).get(0);
//			logger.info(location.getId().toString());		//.toString()
//			List<Cable> founded = cableService.findByLocation(locationInDB);
//			logger.info(String.valueOf(founded.size()));
//			model.addAttribute("RESULT", founded);
			locationService.deleteByName(locationInDB.getName());
			return "delete";
		}
		
		//deleteCable
		@RequestMapping(value = "/delete2", method = RequestMethod.GET)	// jsp Seite					
		public String deleteLGET(Locale locale, Model model
				,@ModelAttribute("cable")	Cable cable, BindingResult result) {
			return "delete2";
		}
		
		@RequestMapping(value = "/delete2", method = RequestMethod.POST)							//delete Cable 
		public String deleteCablePOST(Locale locale, Model model,
				@ModelAttribute("cable")	Cable cable, BindingResult result) {
			logger.info(cable.getName().toString());		//.toString()
			System.out.println("search");
			Cable cableInDB = cableService.findByName(cable.getName()).get(0);
//			logger.info(location.getId().toString());		//.toString()
//			List<Cable> founded = cableService.findByLocation(locationInDB);
//			logger.info(String.valueOf(founded.size()));
//			model.addAttribute("RESULT", founded);
			System.out.println("good");
//			cableService.deleteByName(cableInDB.getName());
			System.out.println(cableInDB.getName());
			cableService.delete(cableInDB);
			System.out.println("nice");
			return "delete2";
			
		}
		//bearbeiten
		@RequestMapping(value="", method=RequestMethod.GET)
		public String updateGet(Locale locale, Model model,
			@ModelAttribute("cable")	Cable cable, BindingResult result){
			return "";
		}
		@RequestMapping(value="", method=RequestMethod.POST)
		public String updatePost(Locale locale, Model model,
			@ModelAttribute("cable")	Cable cable, BindingResult result){
			logger.info(cable.getName().toString());
			Cable cableInCC = cableService.findByName(cable.getName()).get(0);
			Location locations=locationService.findByName(cable.getLocation().getName()).get(0);
			cableInCC.setLocation(locations);
			cableService.saveCable(cableInCC);
			logger.info("saved Cable");
			return "";
		}
	
}
