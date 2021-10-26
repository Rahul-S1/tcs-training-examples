package com.example.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ContactRepository;
import com.example.dao.ProfileRepository;
import com.example.entities.Contact;
import com.example.entities.Profile;
import com.tcs.exception.ProfileNotFoundException;
@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository profileDao;
	@Autowired
	private ContactRepository contactDao;

	@Override
	@Transactional
	public Profile save(Profile profile) {
		return profileDao.save(profile);
	}

	@Override
	public List<Contact> getContacts(int profileId) throws ProfileNotFoundException
	{
		Profile profile = getProfile(profileId);
		
		if(profile == null)
		{
			throw new ProfileNotFoundException("profile with profileid"+ profileId + "not found");
		}
		return profile.getContactsList();
	}

	@Override
	public List<Profile> getProfiles() {
		// TODO Auto-generated method stub
		return profileDao.findAll();
	}
	@Override
	public Contact getContact(int contactId, int profileId) throws ProfileNotFoundException 
	{
		List<Contact> l= getContacts(profileId);
		for(Contact i:l){
			if(i.getContactId()==contactId) {
				return i;
			}
		}
		throw new ProfileNotFoundException("Contact Id : "+contactId+" not found");
	}

	@Override
	@Transactional
	public void deleteContact(int contactId, int profileId) throws  ProfileNotFoundException 
	{ 
		Contact contact = getContact(contactId, profileId);
		contactDao.deleteContact(contact.getContactId(), profileId);
	}

	@Override
	public Profile getProfile(int profileId) throws ProfileNotFoundException {
		Profile profile = profileDao.findById(profileId).orElse(null);
		if(profile == null) 
		{
			 throw new ProfileNotFoundException("Profile with profileid "+profileId+ "not found");
		}
		return profile;
	}

	@Override
	@Transactional
	public void addContact(int profileId, Contact contact) throws ProfileNotFoundException 
	{
		Profile profile = getProfile(profileId);
		if(profile!=null)
		{
			contactDao.save(contact);
			
		}
		
		else {
			throw new ProfileNotFoundException("Profile with profileid "+profileId+ "not found");
		}
	}


	
}
	
