
package com.farm.settings;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.farm.entities.requestbodies.FileSaveResponse;


@Component
public class FileStore {

	@Value("${com.apptimus.user.image.save.path}")
	private String url;
	
	@Value("${com.apptimus.department.image.save.path}")
	private String urlDepartmentImage;
	
	
	@Value("${com.apptimus.user.avatar}")
	private String urlUseravatar;
	
	@Value("${com.apptimus.user.cover_image}")
	private String urlusercover;
	
	@Value("${com.apptimus.cv}")
	private String cvurl;
	
	@Value("${com.apptimus.vacancy.banner}")
	private String urlBanner;
	
	public FileSaveResponse imageSave(MultipartFile avatar, String avatarAlreadyThere) {
		final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
		final String baseUri = Constants.BASE_URI+"/logo/";
		
		
		
		try {

			if(avatar.isEmpty() && avatarAlreadyThere == null) {
				return new FileSaveResponse(baseUrl + baseUri + "default-user-image.jpg/",null,true);
				//System.out.println("is null");
			}
			if(avatar.isEmpty() && avatarAlreadyThere != null) {
				return new FileSaveResponse(avatarAlreadyThere,null,true);
				
			}
			
			String extension;
			switch (avatar.getContentType()) {
			case "image/png":
				extension = ".png";
				break;
			case "image/jpeg":
				extension = ".jpeg";
				break;
			default:
				extension=null;
				break;
			}
			
			if(extension ==null ) {
				return new FileSaveResponse(null,"File format not in PNG, JPEG or JPG. Please upload correct file format",false);
			}
			
			String imageName =  UUID.randomUUID().toString().replaceAll("-", "") + extension ;
			try {
				 OutputStream os = new FileOutputStream(url + imageName);
				 os.write(avatar.getBytes());
				 os.close();
				return new FileSaveResponse( imageName + "/",null,true);
			} catch (Exception e) {
				return new FileSaveResponse(null,e.toString(),false);
			}
			
			
		} catch (Exception e) {
			//System.out.println("is null");
			return new FileSaveResponse(null,e.toString(),false);
		}
		
	}

	public FileSaveResponse departmentImageSave(MultipartFile avatar) {
		final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
		final String baseUri = Constants.BASE_URI + "/department-image/";

		try {

			if (avatar.isEmpty()) {
				return new FileSaveResponse(null, "Image cannot be null", false);

			}
			String extension;
			switch (avatar.getContentType()) {
			case "image/png":
				extension = ".png";
				break;
			case "image/jpeg":
				extension = ".jpeg";
				break;
			default:
				extension = null;
				break;
			}

			if (extension == null) {
				return new FileSaveResponse(null,
						"File format not in PNG, JPEG or JPG. Please upload correct file format", false);
			}

			String imageName = UUID.randomUUID().toString().replaceAll("-", "") + extension;
			try {
				OutputStream os = new FileOutputStream(urlDepartmentImage + imageName);
				os.write(avatar.getBytes());
				os.close();
				return new FileSaveResponse( imageName + "/", null, true);
			} catch (Exception e) {
				return new FileSaveResponse(null, e.toString(), false);
			}

		} catch (Exception e) {
			return new FileSaveResponse(null, e.toString(), false);
		}

	}

	
	public FileSaveResponse courselogoSave(MultipartFile logo) {
		final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
		final String baseUri = Constants.BASE_URI+"/logo/";
		
		
		
		try {

			if(logo.isEmpty())
					{
				return new FileSaveResponse(null, "Logo cannot be null", false);
				
			}
			
			
			String extension;
			switch (logo.getContentType()) {
			case "image/png":
				extension = ".png";
				break;
			case "image/jpeg":
				extension = ".jpeg";
				break;
			default:
				extension=null;
				break;
			}
			
			if(extension ==null ) {
				return new FileSaveResponse(null,"File format not in PNG, JPEG or JPG. Please upload correct file format",false);
			}
			
			String imageName =  UUID.randomUUID().toString().replaceAll("-", "") + extension ;
			try {
				 OutputStream os = new FileOutputStream(url + imageName);
				 os.write(logo.getBytes());
				 os.close();
				return new FileSaveResponse( imageName + "/",null,true);
			} catch (Exception e) {
				return new FileSaveResponse(null,e.toString(),false);
			}
			
			
		} catch (Exception e) {
			//System.out.println("is null");
			return new FileSaveResponse(null,e.toString(),false);
		}
		
	}
	
	
	public FileSaveResponse useravatarSave(MultipartFile avatar) {
		final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
	
		final String baseUri = Constants.BASE_URI+"/user/avatar/";
		
		
		
		try {

			if(avatar.isEmpty())
					{
				return new FileSaveResponse(null, "avatar cannot be null", false);
				
			}
			
			
			String extension;
			switch (avatar.getContentType()) {
			case "image/png":
				extension = ".png";
				break;
			case "image/jpeg":
				extension = ".jpeg";
				break;
			default:
				extension=null;
				break;
			}
			
			if(extension ==null ) {
				return new FileSaveResponse(null,"File format not in PNG, JPEG or JPG. Please upload correct file format",false);
			}
			
			String imageName =  UUID.randomUUID().toString().replaceAll("-", "") + extension ;
			try {
				
				 OutputStream os = new FileOutputStream(urlUseravatar + imageName);
				 os.write(avatar.getBytes());
				 os.close();
				return new FileSaveResponse(imageName ,null,true);
			} catch (Exception e) {
				return new FileSaveResponse(null,e.toString(),false);
			}
			
			
		} catch (Exception e) {
			//System.out.println("is null");
			return new FileSaveResponse(null,e.toString(),false);
		}
		
	}
	
	public FileSaveResponse usercoverphotoSave(MultipartFile coverphoto) {
		final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
		final String baseUri = Constants.BASE_URI+"/cover_image/";
		
		
		
		try {

			if(coverphoto.isEmpty())
					{
				return new FileSaveResponse(null, "cover_image cannot be null", false);
				
			}
			
			
			String extension;
			switch (coverphoto.getContentType()) {
			case "image/png":
				extension = ".png";
				break;
			case "image/jpeg":
				extension = ".jpeg";
				break;
			default:
				extension=null;
				break;
			}
			
			if(extension ==null ) {
				return new FileSaveResponse(null,"File format not in PNG, JPEG or JPG. Please upload correct file format",false);
			}
			
			String imageName =  UUID.randomUUID().toString().replaceAll("-", "") + extension ;
			try {
				 OutputStream os = new FileOutputStream(urlusercover + imageName);
				 os.write(coverphoto.getBytes());
				 os.close();
				return new FileSaveResponse(imageName,null,true);
			} catch (Exception e) {
				return new FileSaveResponse(null,e.toString(),false);
			}
			
			
		} catch (Exception e) {
			//System.out.println("is null");
			return new FileSaveResponse(null,e.toString(),false);
		}
		
	}

	public FileSaveResponse usercvaSave(MultipartFile cv) {
		
		
		try {

			if(cv.isEmpty())
					{
				return new FileSaveResponse(null, "cv cannot be null", false);
				
			}
	
			//System.out.println(cv.getContentType());
			String extension;
			switch (cv.getContentType()) {
		
			case "application/pdf":
				extension = ".pdf";
				break;
			
		
			default:
				extension=null;
				break;

			}
			
			if(extension ==null ) {
				return new FileSaveResponse(null,"File format not in PDF Please upload correct file format",false);
			}
			
			String fileName =  UUID.randomUUID().toString().replaceAll("-", "") + extension ;
			try {
				 OutputStream os = new FileOutputStream(cvurl + fileName);
				 os.write(cv.getBytes());
				 os.close();
				return new FileSaveResponse(fileName,null,true);
			} catch (Exception e) {
				return new FileSaveResponse(null,e.toString(),false);
			}
			
			
		} catch (Exception e) {
			//System.out.println("is null");
			return new FileSaveResponse(null,e.toString(),false);
		}
	}
	
	public FileSaveResponse saveVacancyBanner(MultipartFile file) {
		//final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
		//final String baseUri = Constants.BASE_URI+"/vacancies";
		
		
		
		try {

			if(file.isEmpty())
					{
				return new FileSaveResponse(null, "banner cannot be null", false);
				
			}
			
			
			String extension;
			switch (file.getContentType()) {
			case "image/png":
				extension = ".png";
				break;
			case "image/jpeg":
				extension = ".jpeg";
				break;
			default:
				extension=null;
				break;
			}
			
			if(extension ==null ) {
				return new FileSaveResponse(null,"File format not in PNG, JPEG or JPG. Please upload correct file format",false);
			}
			
			String imageName =  UUID.randomUUID().toString().replaceAll("-", "") + extension ;
			try {
				 OutputStream os = new FileOutputStream(urlBanner + imageName);
				 os.write(file.getBytes());
				 os.close();
				return new FileSaveResponse(imageName,null,true);
			} catch (Exception e) {
				return new FileSaveResponse(null,e.toString(),false);
			}
			
			
		} catch (Exception e) {
			//System.out.println("is null");
			return new FileSaveResponse(null,e.toString(),false);
		}
		
	}
	
	

}
