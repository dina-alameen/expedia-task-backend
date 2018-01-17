package com.expedia.task.webservice;

import java.util.Map;

import org.junit.Test;

public class HotelsResourceTest extends HotelsResource {

	/**
	 * this method is used to test the construction of filters map from the
	 * passed service resource parameters
	 */
	@Test
	public void mockConstructFilters() {
		HotelsResource hotelsResource = new HotelsResource();
		Map<String, Object> filters = hotelsResource.constructFilters("Amman", null, "2017-01-02", null, null, new Double(4), null, null, null, null);
		assert (filters.containsKey("destinationName") && filters.containsKey("minTripStartDate") && filters.containsKey("maxStarRating"));
	}
}
