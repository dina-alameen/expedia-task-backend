package com.expedia.task.business;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is responsible for handling the business of fetching offers from expedia offers service. 
 * 
 * @author Dina Al Ameen
 * @since Expedia task
 */
public class HotelResourceBusiness {
	private static final String BASE_SERVICE_URL = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";
	protected static final String UTF_8_ENCODING = "UTF-8";
	private static final String DESTINATION_NAME_PARAMETER_KEY = "destinationName";

	private ObjectMapper mapper = new ObjectMapper();

	/**
	 * This method executes the call to expedia service in order to fetch the offers
	 * @param filters : a map of query params such as  destinationName -> Amman
	 * @return the resulted map that is fetched from the expedia service
	 * @throws BusinessException
	 * @since expedia task
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getOffers(Map<String, Object> filters) throws BusinessException {

		InputStream inputStream = null;
		try {
			URL httpUrl = new URL(getServiceURL(filters));
			HttpsURLConnection httpURLConnection = (HttpsURLConnection) httpUrl.openConnection();
			httpURLConnection.setRequestMethod("GET");
			inputStream = httpURLConnection.getInputStream();
			return mapper.readValue(inputStream, Map.class);
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException("Failed to get offers, please try again later");
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new BusinessException(e.getMessage());
				}
			}
		}
	}

	/**
	 * This method returns the url to be sent to expedia service after adding the query parameters to it . 
	 * @param filters the query parameters map that will be appended to the url
	 * @throws BusinessException
	 * @author dina Al Ameen
	 * @since expedia task
	 */
	protected String getServiceURL(Map<String, Object> filters) throws BusinessException {

		try {
			StringBuilder urlWithParameters = new StringBuilder(BASE_SERVICE_URL);
			for (Entry<String, Object> filterEntry : filters.entrySet()) {
				if (filterEntry.getValue() == null || filterEntry.getValue().toString().trim().isEmpty()) {
					continue;
				}
				urlWithParameters.append("&");
				urlWithParameters.append(filterEntry.getKey());
				urlWithParameters.append("=");

				if (filterEntry.getKey().equals(DESTINATION_NAME_PARAMETER_KEY)) {
					String destinationNameEncoded = URLEncoder.encode((String) filterEntry.getValue(), UTF_8_ENCODING);
					urlWithParameters.append(destinationNameEncoded);
				} else {
					urlWithParameters.append(filterEntry.getValue());
				}
			}
			return urlWithParameters.toString();
		} catch (IOException e) {
			throw new BusinessException(e);
		}
	}

}
