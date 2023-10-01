package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace addplacePayload(String name, String lang,String add) {
		 AddPlace a=new AddPlace();
	      a.setAccuracy(50);
	      a.setAddress(add);
	      a.setLnaguage(lang);
	      a.setPhone_number("000999");
	      a.setWebsite("www.google.com");
	      a.setName(name);
	      List<String> l=new ArrayList<String>();
	      l.add("Shoe Park");
	      l.add("Shop");
	      a.setTypes(l);
	      Location loc=new Location();
	      loc.setLat(-33.1234);
	      loc.setLng(33.456);
	      a.setLocation(loc);
	      return a;
	}
	
	public String deletePlacePayload(String place) {
		return "{\r\n"
				+ "    \"place_id\":\""+place+"\"\r\n"
				+ "}\r\n"
				+ "";
	}
}
