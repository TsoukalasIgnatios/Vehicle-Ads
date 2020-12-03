package com.bikeAdvert.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bikeAdvert.demo.dao.BikeAdvertDAO;
import com.bikeAdvert.demo.entity.BikeAdvert;
@Service
public class BikeAdvertServiceImpl implements BikeAdvertService {
	@Autowired
	private BikeAdvertDAO bikeAdvertDAO;
	
	@Override
	@Transactional
	public List<BikeAdvert> getBikeAdverts() {
		return bikeAdvertDAO.getBikeAdverts();
	}

	@Override
	@Transactional
	public void saveBikeAd(BikeAdvert theBikeAdvert) {
		bikeAdvertDAO.saveBikeAd(theBikeAdvert);
	}

	@Override
	@Transactional
	public BikeAdvert getBikeAdvert(int theId) {
		
		return bikeAdvertDAO.getBikeAdvert(theId);
	}

	@Override
	@Transactional
	public void deleteBikeAd(int theId) {
		bikeAdvertDAO.deleteBikeAd(theId);
	}

	@Override
	@Transactional
	public List<BikeAdvert> searchBikeAd(String theCompanyName) {
		List<BikeAdvert> theBikeAdverts=bikeAdvertDAO.searchBikeAd(theCompanyName);
		System.out.println("in service");
		return theBikeAdverts;
	}

}
