package com.bikeAdvert.demo.dao;

import java.awt.print.Book;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bikeAdvert.demo.entity.BikeAdvert;
@Repository
public class BikeAdvertDAOImpl implements BikeAdvertDAO {
   //inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<BikeAdvert> getBikeAdverts() {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//create the query
		Query<BikeAdvert> theQuery= 
				currentSession.createQuery("from BikeAdvert order by companyName",BikeAdvert.class);
		//execute query and get result list
		List<BikeAdvert> bikeAdverts= theQuery.getResultList();
		// and return the results 
		return bikeAdverts;
	}

	@Override
	public void saveBikeAd(BikeAdvert theBikeAdvert) {
		
		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		//save the customer
		currentSession.saveOrUpdate(theBikeAdvert);
	}

	@Override
	public BikeAdvert getBikeAdvert(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//now retrive /read from db using the primary key
		BikeAdvert theBikeAdvert = currentSession.get(BikeAdvert.class,theId);
		
		return theBikeAdvert;
	}

	@Override
	public void deleteBikeAd(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//delete the object with the primary key
	    Query theQuery = currentSession.createQuery("delete from BikeAdvert where id=:BikeAdvertId");
		theQuery.setParameter("BikeAdvertId",theId);
		theQuery.executeUpdate();
	}

	@Override
	public List<BikeAdvert> searchBikeAd(String theCompanyName) {
		
		try {
		Session currentSession = sessionFactory.getCurrentSession();
		Query <BikeAdvert> theQuery=null;
		if(theCompanyName!=null && theCompanyName.trim().length()>0) {
		 theQuery = currentSession.createQuery("from BikeAdvert B where lower(B.companyName) = :theName",BikeAdvert.class);
		
		theQuery.setParameter("theName","%"+theCompanyName.toLowerCase()+"%");
		}else {
			theQuery = currentSession.createQuery("from BikeAdvert",BikeAdvert.class);
		}
		List<BikeAdvert>theBikeAdverts=theQuery.getResultList();
		return theBikeAdverts;
	}
		 catch(Exception e)
		   {
		      throw e;
		   }
	}

}
