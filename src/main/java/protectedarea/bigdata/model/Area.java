package protectedarea.bigdata.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "areas")

public class Area {

	private String WDPAID;
	private String NAME;
	private String ISO3;
	private String STATUS;
	private String SUB_LOC;
	private String OWN_TYPE;
	private String DESIG_TYPE;
	private String GOV_TYPE;
	private String NO_TK_AREA;
	private float LAT;
	private float LON;
	
	public String getWDPAID() {
		return WDPAID;
	}
	public void setWDPAID(String wPDAID) {
		WDPAID = wPDAID;
	}
	public float getLAT() {
		return LAT;
	}
	public void setLAT(float lAT) {
		LAT = lAT;
	}
	public float getLON() {
		return LON;
	}
	public void setLON(float lON) {
		LON = lON;
	}	
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getISO3() {
		return ISO3;
	}
	public void setISO3(String iSO3) {
		ISO3 = iSO3;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getSUB_LOC() {
		return SUB_LOC;
	}
	public void setSUB_LOC(String sUB_LOC) {
		SUB_LOC = sUB_LOC;
	}
	public String getOWN_TYPE() {
		return OWN_TYPE;
	}
	public void setOWN_TYPE(String oWN_TYPE) {
		OWN_TYPE = oWN_TYPE;
	}
	public String getDESIG_TYPE() {
		return DESIG_TYPE;
	}
	public void setDESIG_TYPE(String dESIG_TYPE) {
		DESIG_TYPE = dESIG_TYPE;
	}
	public String getGOV_TYPE() {
		return GOV_TYPE;
	}
	public void setGOV_TYPE(String gOV_TYPE) {
		GOV_TYPE = gOV_TYPE;
	}
	public String getNO_TK_AREA() {
		return NO_TK_AREA;
	}
	public void setNO_TK_AREA(String nO_TK_AREA) {
		NO_TK_AREA = nO_TK_AREA;
	}		
}
