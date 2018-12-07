package com.ensa.batch;

import java.util.List;

import com.ensa.Dao.PersonneDao;
import com.ensa.entities.Personne;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personWriter")
public class PersonWriter implements ItemWriter<Personne>{
	
	@Autowired
	private PersonneDao dao;

	@Override
	public void write(List<? extends Personne> personnes) throws Exception {
		for(Personne pr : personnes){
			dao.ajoutPersonne(pr);
		}
		
	}

}
