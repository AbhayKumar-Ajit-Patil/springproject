package com.jspiders.springmvc1.dao;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;


import com.jspiders.springmvc1.dto.UserDTO;

@Component
public class UserDAO {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("contact_manager");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private void closeConnection() {
		if (entityManagerFactory != null)
			entityManagerFactory.close();
		if (entityManager != null)
			entityManager.close();
		if (entityTransaction != null) {
			if (entityTransaction.isActive())
				entityTransaction.rollback();
		}
	}

	public void addUser(UserDTO userDTO) {

		openConnection();
		entityTransaction.begin();
		entityManager.persist(userDTO);
		entityTransaction.commit();
		closeConnection();

	}

	public UserDTO authUser(String email, String password) {
		openConnection();
		Query query = entityManager
				.createQuery("SELECT user FROM UserDTO user WHERE user.email = ?1 AND user.password = ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		UserDTO user = (UserDTO) query.getSingleResult();
		closeConnection();
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<UserDTO> findAllUser() {
		openConnection();
	Query query = entityManager.createQuery("SELECT user FROM UserDTO user");
	List<UserDTO> users = query.getResultList();
	closeConnection();
	return users;}

	public void deleteuserbyId(int id) {
		openConnection();
		entityTransaction.begin();
		UserDTO user = entityManager.find(UserDTO.class, id);
		entityManager.remove(user);
		entityTransaction.commit();
		closeConnection();
		
	}

	public UserDTO findUserById(int id) {
		openConnection();
		UserDTO userDTO = entityManager.find(UserDTO.class, id);
		closeConnection();
		return userDTO;
	}

	public void updateUser(int id, String name, String email, long mobile, String password) {
		openConnection();
		UserDTO userDTO = entityManager.find(UserDTO.class, id);
		userDTO.setName(name);
	    userDTO.setEmail(email);
		userDTO.setMobile(mobile);
		userDTO.setPassword(password);
		entityTransaction.begin();
		entityManager.persist(userDTO);
		entityTransaction.commit();
		closeConnection();
		
	}

}