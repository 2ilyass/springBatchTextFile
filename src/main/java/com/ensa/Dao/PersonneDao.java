package com.ensa.Dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.entities.Personne;

public interface PersonneDao {
	
	public void ajoutPersonne(Personne personne);

	

}
