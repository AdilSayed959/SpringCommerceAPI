package com.ct.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorExtracter {

	//Extracts the short message from a detailed error response
	public static String extractMessage(String apiResponse) {
		try {
			Pattern pattern = Pattern.compile("\"message\"\\s*:\\s*\"([^\"]+)\"");
			Matcher matcher = pattern.matcher(apiResponse);

			if (matcher.find()) {
				String extractedMessage = matcher.group(1); // This captures the message
				System.out.println("Extracted Message: " + extractedMessage);
				return extractedMessage;
			} else {
				return apiResponse;
			}
		} catch (Exception e) {
			return "An unexpected error occurred while processing the request.";
		}
	}
}
