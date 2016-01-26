package edu.starterkit.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the countrylanguage database table.
 * 
 */
@Entity
@NamedQuery(name="CountryLanguage.findAll", query="SELECT c FROM CountryLanguage c")
public class CountryLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CountryLanguagePK id;

	private String isOfficial;

	private float percentage;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="CountryCode")
	private Country country;

	public CountryLanguage() {
	}

	public CountryLanguagePK getId() {
		return this.id;
	}

	public void setId(CountryLanguagePK id) {
		this.id = id;
	}

	public String getIsOfficial() {
		return this.isOfficial;
	}

	public void setIsOfficial(String isOfficial) {
		this.isOfficial = isOfficial;
	}

	public float getPercentage() {
		return this.percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}