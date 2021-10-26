package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Contact;
import com.example.entities.CustomResponse;
import com.example.entities.Profile;
import com.example.service.ProfileService;
import com.tcs.exception.ProfileNotFoundException;

@RestController
@RequestMapping("profile")
public class ProfileRestApi {

	@Autowired
	private ProfileService profileService;

	// storing the profile
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveProfile(@RequestBody Profile profile) {
		return ResponseEntity.status(HttpStatus.CREATED).body(profileService.save(profile));
	}
	// getting all the profiles
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getProfiles() {
		return ResponseEntity.status(HttpStatus.OK).body(profileService.getProfiles());
	}
	// getting the contacts of a particular profile
	@GetMapping(path = "contact/{profileId}")
	public ResponseEntity<Object> getContactFromProfile(@PathVariable("profileId") int profileId) 
	{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(profileService.getContacts(profileId));
		} catch (ProfileNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		
	}
	// getting a particular profile
	@GetMapping(path = "{profileId}")
	public ResponseEntity<Object> getProfile(@PathVariable("profileId") int profileId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(profileService.getProfile(profileId));
		} catch (ProfileNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		
	}
	// getting a particular profile
	@DeleteMapping(path = "{contactId}/{profileId}")
	public ResponseEntity<Object> deleteContactFromProfile(@PathVariable("contactId") int contactId, 
			@PathVariable("profileId") int profileId) {
		try {
			profileService.deleteContact(contactId, profileId);
			CustomResponse data =new CustomResponse();
			data.setMsg("Contact Deleted Successfully ");
			return ResponseEntity.status(HttpStatus.OK).body(data);
			
		} catch (ProfileNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		
	}
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addContact(@RequestBody Contact contact) {
		try {
			profileService.addContact(contact.getProfileId(),contact);
			CustomResponse data = new CustomResponse();
			data.setMsg("Contact Successfully Added");
			return ResponseEntity.status(HttpStatus.CREATED).body(data);
		}
		catch(ProfileNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
	}
	
		
}
