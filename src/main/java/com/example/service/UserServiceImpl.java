package com.example.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.model.User;

@Service
public class UserServiceImpl implements UserService {

	@PersistenceContext
	EntityManager em;
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class); 
	
	@Transactional
	public void addUser(User user) {
		em.persist(user);
		logger.info("created User:"+ user.getUserName());
		return;
	}

	@Override
	public boolean validateUser(User user) {
		
		logger.info("user received: "+user.getUserName() +" Passwd: "+user.getPasswd());
		
		Query qry = em.createQuery("Select u from User u where u.userName = ?1 and u.passwd = ?2");
		qry.setParameter(1, user.getUserName());
		qry.setParameter(2, user.getPasswd());
		
		try {
			User u = (User) qry.getSingleResult();
		} catch (Exception e) {
			logger.info("user not valid");
			return false;
		}
		
		logger.info("user is valid");
		return true;
	}
}
