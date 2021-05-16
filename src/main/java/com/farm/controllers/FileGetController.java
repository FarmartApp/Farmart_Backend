
package com.farm.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farm.settings.Constants;
import com.google.common.net.HttpHeaders;


@RestController
@RequestMapping(Constants.BASE_URI)
public class FileGetController {

	@Value("${com.apptimus.user.image.save.path}")
	private String url;
	
	@Value("${com.farm.user.avatar}")
	private String urlUseravatar;
	
	@Value("${com.apptimus.user.cover_image}")
	private String urlusercover;
	
	@Value("${com.apptimus.cv}")
	private String cvurl;
	
	@Value("${com.apptimus.vacancy.banner}")
	private String urlBanner;
	
	@GetMapping(value = "users/avatar/{imageName}")
	public ResponseEntity<byte[]> getuserAvatar(@PathVariable String imageName) throws IOException {


		InputStream is = new FileInputStream(new File(urlUseravatar).getAbsolutePath() + "\\" + imageName);

		byte[] bytes = StreamUtils.copyToByteArray(is);
		
		String imageExtension = "";
		int i = imageName.lastIndexOf('.');
		if (i > 0) {
			imageExtension = imageName.substring(i + 1);
		}

		switch (imageExtension) {
		case "jpg":
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
		case "jpeg":
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
		case "png":
			return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bytes);
		}
		return ResponseEntity.badRequest().body(bytes);

	}

	@GetMapping(value = "users/cover_image/{imageName}")
	public ResponseEntity<byte[]> getusercoverimage(@PathVariable String imageName) throws IOException {


		InputStream is = new FileInputStream(urlusercover + imageName);

		byte[] bytes = StreamUtils.copyToByteArray(is);
		String imageExtension = "";
		int i = imageName.lastIndexOf('.');
		if (i > 0) {
			imageExtension = imageName.substring(i + 1);
		}

		switch (imageExtension) {
		case "jpg":
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
		case "jpeg":
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
		case "png":
			return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bytes);
		}
		return ResponseEntity.badRequest().body(bytes);

	}

	@GetMapping(value = "cv/{imageName}")
	public ResponseEntity<ByteArrayResource> getcv(@PathVariable String imageName) throws IOException {


		InputStream is = new FileInputStream(cvurl + imageName);

		byte[] bytes = StreamUtils.copyToByteArray(is);
		ByteArrayResource resource = new ByteArrayResource(bytes);
		String imageExtension = "";
		int i = imageName.lastIndexOf('.');
		if (i > 0) {
			imageExtension = imageName.substring(i + 1);
		}

		switch (imageExtension) {
		
		case "pdf":
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).contentLength(bytes.length).body(resource);

		
		}
		return ResponseEntity.badRequest().body(resource);

	}

	@GetMapping(value = "vacancybanner/{imageName}")
	public ResponseEntity<byte[]> getvacancybanner(@PathVariable String imageName) throws IOException {


		InputStream is = new FileInputStream(urlBanner + imageName);

		byte[] bytes = StreamUtils.copyToByteArray(is);
		
		String imageExtension = "";
		int i = imageName.lastIndexOf('.');
		if (i > 0) {
			imageExtension = imageName.substring(i + 1);
		}

		switch (imageExtension) {
		case "jpg":
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
		case "jpeg":
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
		case "png":
			return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bytes);
		}
		return ResponseEntity.badRequest().body(bytes);

	}
}