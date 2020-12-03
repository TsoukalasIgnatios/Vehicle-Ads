package com.bikeAdvert.demo.dao;

import java.util.List;

import com.bikeAdvert.demo.entity.BikeAdvert;

public interface BikeAdvertDAO {
	
	public List<BikeAdvert> getBikeAdverts() ;

	public void saveBikeAd(BikeAdvert theBikeAdvert);

	public BikeAdvert getBikeAdvert(int theId);

	public void deleteBikeAd(int theId);

	public List<BikeAdvert> searchBikeAd(String theCompanyName);

	
}