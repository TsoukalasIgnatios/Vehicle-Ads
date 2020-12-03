package com.bikeAdvert.demo.service;

import java.util.List;

import com.bikeAdvert.demo.entity.BikeAdvert;

public interface BikeAdvertService {
	public List<BikeAdvert> getBikeAdverts();

	public void saveBikeAd(BikeAdvert theBikeAdvert);

	public BikeAdvert getBikeAdvert(int theId);

	public void deleteBikeAd(int theId);

	public List<BikeAdvert> searchBikeAd(String theCompanyName);
}
