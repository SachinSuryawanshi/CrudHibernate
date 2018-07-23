package com.scp.Service.Impl.copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.scp.ConstantMsg.AppConstants.AppConstanst;
import com.scp.Service.UserService;
import com.scp.UserEntity.UserEntity;
import com.scp.Util.Util;
import com.scp.pojos.User;

public class UserServiceImpl implements UserService {
public static Logger logger = Logger.getLogger(UserServiceImpl
			.class);
	static SessionFactory sessionFactory = null;
	static {
		sessionFactory = Util.getSessionFactory();

	}

	public boolean addUser(User u) {
		Session session=null;
		Transaction tr=null;

		try {
			session = sessionFactory.openSession();
			tr = session.beginTransaction();
			int id = (Integer) session.save(mapPojoToEntity(u));
			
			Util.FlushNCommit(session, tr);
			return id!=0;
		} catch (Exception e) {
		tr.rollback();			//transtion rolls back
		}finally{
			Util.CloseSession(session);
		}
		return false;
		}

	public User getUser(int id) {
		Session session=null;
		Transaction tr=null;

		try {
			session = sessionFactory.openSession();
			tr = session.beginTransaction();
			
			return mapEntityToPojo( session.get(UserEntity.class, id));
		} catch (Exception e) {
		tr.rollback();			
			Util.CloseSession(session);
		}
		return null;
		
		
		
		
	}


	public boolean deleteUser(int id) {
		Session session=null;
		Transaction tr=null;

		try {
			session = sessionFactory.openSession();
			tr = session.beginTransaction();
	UserEntity	dbObject=session.get(UserEntity.class, id);
	if(dbObject==null)
		return false;
		session.delete(dbObject);
		Util.FlushNCommit(session, tr);
		} catch (Exception e) {
		tr.rollback();			
			Util.CloseSession(session);
		}
		return false;
	}

	public boolean upedateUser(User user) {
		Session session=null;
		Transaction tr=null;

		try {
			session = sessionFactory.openSession();
			tr = session.beginTransaction();
		UserEntity us=	(UserEntity) session.merge(mapPojoToEntity(user));
			
			Util.FlushNCommit(session, tr);
		//	return id!=0;
		} catch (Exception e) {
		tr.rollback();			//transtion rolls back
		}finally{
			Util.CloseSession(session);
		}
		return false;
	}
		

	public List<User> getAllUser() {
		Session session=null;
		Transaction tr=null;

		try {
			session = sessionFactory.openSession();
			tr = session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<UserEntity> listOfUserEnties = session.createQuery("from UserEntity").list();
			return mapListOfEntitiesToListOfPojo(listOfUserEnties);
					} catch (Exception e) {
		tr.rollback();			
			Util.CloseSession(session);
		}
		return null;
		}

	@SuppressWarnings({ "unchecked", "null" })
	public List<User> searchUser(HashMap<AppConstanst, String> serachcriteria) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tr=null;

		try {
			session=sessionFactory.openSession();
			tr=session.beginTransaction();
			
			Criteria criteria = session.createCriteria(UserEntity.class);
			criteria.add(Restrictions.eq("10", AppConstanst.id));
		criteria.add(Restrictions.eq("Yes", AppConstanst.isActive));
		List<User> 	u1= (List<User>) criteria.list();
		
		tr.commit();
		} catch (Exception e) {
			System.out.println("record not found");
		}finally{
			Util.CloseSession(session);
						
		}

		return null;
	}
	
	

	private List<User> mapListOfEntitiesToListOfPojo(List<UserEntity> listOfUserEntities){
		List<User> listOfPojos =null;
		if(listOfUserEntities==null || listOfUserEntities.isEmpty()){
			return null;
		}else{
			 listOfPojos = new ArrayList<User>();
			for (UserEntity  entity : listOfUserEntities) {
				listOfPojos.add(mapEntityToPojo(entity));
			}
		}
		return listOfPojos;
	}
	
	
	private UserEntity mapPojoToEntity(User user){
		if(user==null)
			return null;
		UserEntity userEntity=new UserEntity();
		userEntity.setId(user.getId());
		userEntity.setName(user.getName());
		userEntity.setPassword(user.getPassword());
		String yesOrNO=user.isActive()?"Yes":"No";
		userEntity.setIsActive(yesOrNO);
		
		return userEntity;
		
		
	}
	private User mapEntityToPojo(UserEntity userEntity){
		if(userEntity==null)
			return null;
		User user=new User();
		user.setId(userEntity.getId());
		user.setName(userEntity.getName());
		user.setPassword(userEntity.getPassword());
		user.setActive(userEntity.getIsActive().equals("Yes"));
		
		return user;
		
		
	}

	



}
