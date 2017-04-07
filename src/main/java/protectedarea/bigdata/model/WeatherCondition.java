package protectedarea.bigdata.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "weather_conditions")
public class WeatherCondition {

	private String stationid;
	private String date;
	private String value;
	private float lat;
	private float lon;
	private String type;
	
    public String getStationID() {
		return stationid;
	}
	public void setStationID(String id) {
		stationid = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String d) {
		date = d;
	}
	public String getValue(){
		return value;
	}	
	public void setValue(String v){
		value = v;
	}
	public String getType() {
		return type;
	}
	public void setType(String t) {
		type = t;
	}
	public float getLat(){
		return lat;
	}
	public void setLat(float l){
		lat = l;
	}
	public float getLon(){
		return lon;
	}
	public void setLon(float l){
		lon = l;
	}
	
	
}
