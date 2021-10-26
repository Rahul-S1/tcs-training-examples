package com.example.service;

import java.util.List;

import com.example.entities.Contact;
import com.example.entities.Profile;
import com.tcs.exception.ProfileNotFoundException;

public interface ProfileService {
	// you can perform all the crud operations
	public Profile save(Profile profile);
	public Profile getProfile(int profileId) throws ProfileNotFoundException;
	public List<Contact> getContacts(int profileId) throws ProfileNotFoundException;
	public Contact getContact(int contactId, int profileId) throws ProfileNotFoundException;
	public List<Profile> getProfiles();
	public void deleteContact(int contactId, int profileId) throws  ProfileNotFoundException;
	public void addContact(int profileId, Contact contact)throws ProfileNotFoundException;
	// you can create addContact(int profileId, Contact contact);
}
