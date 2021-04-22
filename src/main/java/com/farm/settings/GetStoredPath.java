
package com.farm.settings;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


public class GetStoredPath {

	public static String locationStoredUrl(String path, Integer id) {

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(path).buildAndExpand(id).toUri();

		return location.getPath();
	}
}
