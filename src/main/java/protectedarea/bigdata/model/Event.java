package protectedarea.bigdata.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "storm_events")
public class Event {

	private String EVENT_ID;
	private String EVENT_TYPE;
	private String BEGIN_DATE_TIME;
	private String DAMAGE_PROPERTY;
	private String EPISODE_NARRATIVE;
	private String EVENT_NARRATIVE;
	private String STATE;
	private float BEGIN_LAT;
	private float BEGIN_LON;
	
    public String getEVENTID() {
		return EVENT_ID;
	}
	public void setEVENTID(String eventId) {
		EVENT_ID = eventId;
	}
	public String getTYPE() {
		return EVENT_TYPE;
	}
	public void setTYPE(String type) {
		EVENT_TYPE = type;
	}
	public String getDATE(){
		return BEGIN_DATE_TIME;
	}	
	public void setDATE(String date){
		BEGIN_DATE_TIME = date;
	}
	public String getDAMAGEPROPERTY() {
		return DAMAGE_PROPERTY;
	}
	public void setDAMAGECOST(String damageProperty) {
		DAMAGE_PROPERTY = damageProperty;
	}
	public String getEPISODENARRATIVE(){
		return EPISODE_NARRATIVE;
	}
	public void setEPISODENARRATIVE(String episodeNarrative){
		EPISODE_NARRATIVE = episodeNarrative;
	}
	public String getEVENTNARRATIVE(){
		return EVENT_NARRATIVE;
	}
	public void setEVENTNARRATIVE(String eventNarrative){
		EVENT_NARRATIVE = eventNarrative;
	}
	public String getSTATE(){
		return STATE;
	}
	public void setSTATE(String state){
		STATE = state;
	}
	public float getLAT(){
		return BEGIN_LAT;
	}
	public void setLAT(float lat){
		BEGIN_LAT = lat;
	}
	public float getLON(){
		return BEGIN_LON;
	}
	public void setLON(float lon){
		BEGIN_LON = lon;
	}
	
	
}
