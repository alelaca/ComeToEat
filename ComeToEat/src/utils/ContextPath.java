package utils;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.web.context.WebApplicationContext;

public class ContextPath {

	private String contextPath;

	public ContextPath(){

		URL resource = getClass().getResource("/");
		try {
			URI uri = new URI(resource.getPath().toString());
			String path = uri.getPath();
			this.contextPath = path;
		} catch (URISyntaxException e) {
		}

	}

	/***
	 * Return the full context path of a file
	 * @param pathFile - the resources solicitated
	 * @return the full path
	 */
	public String getPath(String pathFile){

		System.out.println(this.contextPath + pathFile);
		return this.contextPath + File.separator + pathFile;
	}
}
