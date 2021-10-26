package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
