package nl.topicus.cambo.stubsis.model;

import javax.validation.constraints.Size;

public class Contactpersoon extends Linkable
{
	private static final long serialVersionUID = 1L;

	@Size(max = 5)
	private String aanhef;

	@Size(max = 100)
	private String voornamen;

	@Size(max = 20)
	private String voorletters;

	@Size(max = 20)
	private String voorvoegsel;

	@Size(max = 200)
	private String achternaam;

	@Size(max = 20)
	private String telefoon;

	@Size(max = 100)
	private String emailadres;

	public Contactpersoon()
	{
	}

	public String getAanhef()
	{
		return aanhef;
	}

	public void setAanhef(String aanhef)
	{
		this.aanhef = aanhef;
	}

	public String getVoornamen()
	{
		return voornamen;
	}

	public void setVoornamen(String voornamen)
	{
		this.voornamen = voornamen;
	}

	public String getVoorletters()
	{
		return voorletters;
	}

	public void setVoorletters(String voorletters)
	{
		this.voorletters = voorletters;
	}

	public String getVoorvoegsel()
	{
		return voorvoegsel;
	}

	public void setVoorvoegsel(String voorvoegsel)
	{
		this.voorvoegsel = voorvoegsel;
	}

	public String getAchternaam()
	{
		return achternaam;
	}

	public void setAchternaam(String achternaam)
	{
		this.achternaam = achternaam;
	}

	public String getTelefoon()
	{
		return telefoon;
	}

	public void setTelefoon(String telefoon)
	{
		this.telefoon = telefoon;
	}

	public String getEmailadres()
	{
		return emailadres;
	}

	public void setEmailadres(String emailadres)
	{
		this.emailadres = emailadres;
	}
}
