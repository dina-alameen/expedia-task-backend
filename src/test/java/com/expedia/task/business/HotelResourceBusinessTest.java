package com.expedia.task.business;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class HotelResourceBusinessTest extends HotelResourceBusiness {

	/**
	 * this method is used to test the case where the "destinationName" query
	 * param has white spaces, the composeServiceURL is supposed to handle this
	 * case and encode the url hence the generated url is not supposed to
	 * contain white space
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void mockGetServiceURL() throws UnsupportedEncodingException {
		HotelResourceBusiness hotelResourceBusiness = new HotelResourceBusiness();
		Map<String, Object> filters = new HashMap<>();
		filters.put("destinationName", "Las Vegas");
		String uri = "";
		try {
			uri = hotelResourceBusiness.getServiceURL(filters);
		} catch (BusinessException e) {
			Assert.fail("composeServiceURL throwed a BusinessException");
		}
		assert (uri.contains(URLEncoder.encode("Las Vegas", UTF_8_ENCODING)));
	}

}
