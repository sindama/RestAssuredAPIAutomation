package resources;

public enum APIEnumResources {

	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	APIEnumResources(String resource) {
		this.resource=resource;// TODO Auto-generated constructor stub
	}
	
	public String getResource() {
		return resource;
	}
	
}
