package com.bikeAdvert.demo.entity;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bike_adverts")
public class BikeAdvert {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="company_name")
	private String companyName;
	@Column(name="model_name")
	private String modelName;
	@Column(name="cylinder")
	private int cylinder;
	@Column(name="build_year")
	private int buildYear;
	@Column(name="kms")
	private int kms;
	@Column(name="price")
	private int price;
	
	public BikeAdvert () {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getCylinder() {
		return cylinder;
	}

	public void setCylinder(int cylinder) {
		this.cylinder = cylinder;
	}

	public int getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}

	public int getKms() {
		return kms;
	}

	public void setKms(int kms) {
		this.kms = kms;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BikeAdvert [id=" + id + ", companyName=" + companyName + ", modelName=" + modelName + ", cylinder="
				+ cylinder + ", buildYear=" + buildYear + ", kms=" + kms + ", price=" + price + "]";
	}

	

	
	
	
}
