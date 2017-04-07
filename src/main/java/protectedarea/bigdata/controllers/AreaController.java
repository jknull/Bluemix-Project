package protectedarea.bigdata.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import protectedarea.bigdata.model.Area;
import protectedarea.bigdata.model.Event;
import protectedarea.bigdata.model.Prediction;
import protectedarea.bigdata.model.WeatherCondition;
import protectedarea.bigdata.repository.AreaMongoRepository;
import protectedarea.bigdata.repository.AreaSearchRepository;
import protectedarea.bigdata.repository.EventMongoRepository;
import protectedarea.bigdata.repository.EventSearchRepository;
import protectedarea.bigdata.repository.PredictionMongoRepository;
import protectedarea.bigdata.repository.PredictionSearchRepository;
import protectedarea.bigdata.repository.WeatherMongoRepository;
import protectedarea.bigdata.repository.WeatherSearchRepository;

@Controller
public class AreaController {

	@Autowired
	AreaMongoRepository areaRepository;
	
	@Autowired
	AreaSearchRepository areaSearchRepository;
	
	@Autowired
	EventMongoRepository eventRepository;
	
	@Autowired
	EventSearchRepository eventSearchRepository;
	
	@Autowired
	WeatherMongoRepository weatherRepository;
	
	@Autowired
	WeatherSearchRepository weatherSearchRepository;
	
	@Autowired
	PredictionMongoRepository predictionRepository;
	
	@Autowired
	PredictionSearchRepository predictionSearchRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping("/searcharea")
	public String service1(Model model) {
		return "service1";
	}

	@RequestMapping("/searchevents")
	public String service2(Model model) {
		return "service2";
	}
	
	@RequestMapping("/searchweather")
	public String service3(Model model) {
		return "service3";
	}
	
	@RequestMapping("/searchprediction")
	public String service4(Model model) {
		return "service4";
	}
	
	@RequestMapping(value = "/search1")
	public String search(Model model, @RequestParam String search) {
		Collection<Area> results = areaSearchRepository.searchArea(search);
		
		Area temp = null;
		
		for (Area a : results) {
	        temp = a;
	        break;
	    }
		results.clear();
		results.add(temp);
		
		
		model.addAttribute("protectedList", results);
		model.addAttribute("search", search);
		return "service1";
	}
	
	@RequestMapping(value = "/search2", method=RequestMethod.POST)
	public String search2(Model model, @RequestParam String search) {
		Collection<Area> results = areaSearchRepository.searchArea(search);
		
		Area temp = null;
		
		for (Area a : results) {
	        temp = a;
	        break;
	    }
		results.clear();
		results.add(temp);
		
		Collection<Event> events = eventSearchRepository.searchEvent(temp.getSUB_LOC(), temp.getLAT(), temp.getLON());
		Gson gson = new Gson();
		String eventList = gson.toJson(events);

		model.addAttribute("eventList", eventList);
		model.addAttribute("areaList", results);
		model.addAttribute("search", search);
		return "service2";
	}
	
	@RequestMapping(value = "/search3", method=RequestMethod.POST)
	public String search3(Model model, @RequestParam String search) {
		Collection<Area> results = areaSearchRepository.searchArea(search);
		
		Area temp = null;
		
		for (Area a : results) {
	        temp = a;
	        break;
	    }
		results.clear();
		results.add(temp);
		
		Collection<WeatherCondition> eventsMin = weatherSearchRepository.searchWeatherCondition("TMIN", temp.getLAT(), temp.getLON());
		Collection<WeatherCondition> eventsMax = weatherSearchRepository.searchWeatherCondition("TMAX", temp.getLAT(), temp.getLON());
		Collection<WeatherCondition> eventsSnow = weatherSearchRepository.searchWeatherCondition("SNOW", temp.getLAT(), temp.getLON());
		Collection<WeatherCondition> eventsPrecip = weatherSearchRepository.searchWeatherCondition("PRECP", temp.getLAT(), temp.getLON());
		Gson gson = new Gson();
		String minList = gson.toJson(eventsMin);
		String maxList = gson.toJson(eventsMax);
		String snowList = gson.toJson(eventsSnow);
		String precipList = gson.toJson(eventsPrecip);

		model.addAttribute("minList", minList);
		model.addAttribute("maxList", maxList);
		model.addAttribute("snowList", snowList);
		model.addAttribute("precipList", precipList);
		model.addAttribute("areaList", results);
		model.addAttribute("search", search);
		return "service3";
	}
	
	@RequestMapping(value = "/search4", method=RequestMethod.POST)
	public String search4(Model model, @RequestParam String search) {
		Collection<Area> results = areaSearchRepository.searchArea(search);
		
		Area temp = null;
		
		for (Area a : results) {
	        temp = a;
	        break;
	    }
		results.clear();
		results.add(temp);
		
		Collection<Prediction> events = predictionSearchRepository.searchPrediction(temp.getNAME());
		Gson gson = new Gson();
		String predictionList = gson.toJson(events);
		model.addAttribute("predictionList", predictionList);
		model.addAttribute("areaList", results);
		model.addAttribute("search", search);
		return "service4";
	}
	
	@Scheduled(fixedRate = 10000)
	@RequestMapping(value="#", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public void saveData() {
	   final String uri ="http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=ded2287ef7a2d51872d4db98e37183d6";
	   RestTemplate restTemplate = new RestTemplate();
	   String result = restTemplate.getForObject(uri, String.class);
	    
	   mongoTemplate.insert(result, "vikram-protected");   
		
	}		    
	
	
	
	
}