package com.uday.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import com.uday.location.entities.Location;
import com.uday.location.repos.LocationRepository;
import com.uday.location.service.LocationService;
import com.uday.location.util.EmailUtil;
import com.uday.location.util.ReportUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;


@Controller
public class LocationController {

    @Autowired
    LocationService locationService;

    @Autowired
	LocationRepository repository;

    @Autowired
    EmailUtil emailUtil;

    @Autowired
	ReportUtil reportUtil;

	@Autowired
	ServletContext sc;

    @RequestMapping("/showCreate")
    public String showCreate(){
        return "createLocation";
    }

    @RequestMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        Location locationSaved = locationService.saveLocation(location);
        String msg = "Location saved with id:" + locationSaved.getId();
        modelMap.addAttribute("msg", msg);

        // emailUtil.sendEmail("chaudhariniketa31394@gmail.com", "Test from Spring Boot", "This is Udayaditya Singh , Trying to send Mail when data is saved to DB.");
        try {
            emailUtil.sendEmail("udayaditya.singh@gmail.com", "Test from Spring Boot", "This is Udayaditya Singh , Trying to send Mail when data is saved to DB.");
        } catch (Exception e) {
            System.out.println("ERROR"+e);
            e.printStackTrace();
        }
        return "createLocation";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap) {
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
        Location location = new Location();
        location.setId(id);
        locationService.deleteLocation(location);
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = locationService.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
    }
    
    @RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		locationService.updateLocation(location);
		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
    }
    
    @RequestMapping("/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";

	}
}