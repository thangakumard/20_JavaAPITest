package coreFramework;

import java.io.IOException;
import java.nio.file.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Util {

	public static JSONObject fetchTemplateAsObject() {
			String template = fetchTemplate();
			try {
				return (JSONObject)(new JSONParser()).parse(template);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
	}
	
	private static String fetchTemplate() {
		try {
			String templateContent = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/java/templates/userResponse.json")));
			return templateContent;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
