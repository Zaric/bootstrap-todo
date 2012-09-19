package com.example.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.model.UserRoles;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@PersistenceContext
	EntityManager em;
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class); 
	
	@Override
	public void addUserRole(UserRoles userRole) {

		em.persist(userRole);
		
		if (em.contains(userRole))
			logger.info("userRole present: "+userRole.getUserRoleId());
		else
			logger.info("user not present");
//		UserRoles resultId = em.find(UserRoles.class, userRole.getUserRoleId());
		
//		logger.info("user Role created with userRoleId: "+userRole.getUserRoleId()+" and UserId: "+userRole.getUser().getId());
		return;
	}

}
