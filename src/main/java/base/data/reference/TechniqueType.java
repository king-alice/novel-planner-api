package base.data.reference;

public enum TechniqueType {
	TRADITIONAL("chapters on cards"),
	SYNOPSIS("big ol summary"),
	SNOWFLAKE("incremental plottin"),
	THREE_ACT("inciting event, first conflict, PNR, midpoint, climax, resolution"),
	FREYTAG("pyramid - exposition, rising action, climax, falling action and denouement"),
	FREESTYLE("draft zero");
	
	private final String desc;
	
	TechniqueType(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
}
