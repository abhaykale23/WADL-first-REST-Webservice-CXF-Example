package de.jethroo.rest.example;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class ExampleServiceImpl implements Thingies {

	private final Gson serializer = new Gson();

	private final Logger logger = LoggerFactory.getLogger(ExampleServiceImpl.class);

	public Response onRetrieve(int id) {
		logger.debug("recieved GET request for thingies with id : " + id);

		// just generate a dummy resource for this request
		Thingy somethingy = new Thingy(id, "attribute_value_for_id_" + id);
		return Response.ok(serializer.toJson(somethingy), MediaType.APPLICATION_JSON).build();
	}

	public Response onList() {
		logger.debug("recieved GET request for thingies (index)");

		// just generate a dummy resource for this request
		List<Thingy> thingies = new ArrayList<Thingy>();
		for(int i=1; i < 5; i++){
			thingies.add(new Thingy(i, "foo_"+i));
		}
		return Response.ok(serializer.toJson(thingies), MediaType.APPLICATION_JSON).build();
	}

	public Response onUpdate(int id, String attribute_name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response onDelete(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	

}
