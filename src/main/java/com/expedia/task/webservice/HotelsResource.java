package com.expedia.task.webservice;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.expedia.task.business.BusinessException;
import com.expedia.task.business.HotelResourceBusiness;

@Path("/hotels-offers")
public class HotelsResource {

	/**
	 * this method is executed when a get request is sent to this resource service ,
	 * it receives optional query parameters that are used to filter the result of offers, 
	 * it will return the fetched result of offers from the expedia service, 
	 * @return
	 * @author dina Al Ameen
	 * @since expedia task
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getoffers(@QueryParam("destinationName") String destinationName, @QueryParam("lengthOfStay") Integer lengthOfStay, @QueryParam("minTripStartDate") String minTripStartDate, @QueryParam("maxTripStartDate") String maxTripStartDate, @QueryParam("minStarRating") Double minStarRating, @QueryParam("maxStarRating") Double maxStarRating, @QueryParam("minGuestRating") Double minGuestRating, @QueryParam("maxGuestRating") Double maxGuestRating, @QueryParam("minTotalRating") Double minTotalRating, @QueryParam("maxTotalRating") Double maxTotalRating) {
		try {

			Map<String, Object> filters = constructFilters(destinationName, lengthOfStay, minTripStartDate, maxTripStartDate, minStarRating, maxStarRating, minGuestRating, maxGuestRating, minTotalRating, maxTotalRating);
			HotelResourceBusiness hotelResourceBusiness = new HotelResourceBusiness();
			Map<String, Object> result = hotelResourceBusiness.getOffers(filters);
			return Response.status(Status.OK).entity(result).build();
		} catch (BusinessException e) {
			throw new InternalServerErrorException(e.getMessage());
		}
	}

	/**
	 * this method takes the query params sent by the client and composes the filters map to be sent to the business class
	 * @param destinationName
	 * @param lengthOfStay
	 * @param minTripStartDate
	 * @param maxTripStartDate
	 * @param minStarRating
	 * @param maxStarRating
	 * @param minGuestRating
	 * @param maxGuestRating
	 * @param minTotalRating
	 * @param maxTotalRating
	 * @return a map that contains the filters
	 */
	public Map<String, Object> constructFilters(String destinationName, Integer lengthOfStay, String minTripStartDate, String maxTripStartDate, Double minStarRating, Double maxStarRating, Double minGuestRating, Double maxGuestRating, Double minTotalRating, Double maxTotalRating) {

		Map<String, Object> filters = new LinkedHashMap<>();
		filters.put("destinationName", destinationName);
		filters.put("minTripStartDate", minTripStartDate);
		filters.put("maxTripStartDate", maxTripStartDate);
		filters.put("lengthOfStay", lengthOfStay);
		filters.put("minStarRating", minStarRating);
		filters.put("maxStarRating", maxStarRating);
		filters.put("minGuestRating", minGuestRating);
		filters.put("maxGuestRating", maxGuestRating);
		filters.put("minTotalRating", minTotalRating);
		filters.put("maxTotalRating", maxTotalRating);
		return filters;
	}
}
