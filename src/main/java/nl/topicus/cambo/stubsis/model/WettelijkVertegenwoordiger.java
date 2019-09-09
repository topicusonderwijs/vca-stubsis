package nl.topicus.cambo.stubsis.model;

import javax.validation.constraints.Size;

public class WettelijkVertegenwoordiger extends Linkable
{
	private static final long serialVersionUID = 1L;

	@Size(max = 100)
	private String voornamen;

	@Size(max = 20)
	private String voorvoegsel;

	@Size(max = 200)
	private String achternaam;

	@Size(max = 20)
	private String telefoon;

	@Size(max = 20)
	private String mobiel;

	@Size(max = 100)
	private String emailadres;

	private Adres correspondentieadres;

	public WettelijkVertegenwoordiger()
	{
	}

	public String getVoornamen()
	{
		return voornamen;
	}

	public void setVoornamen(String voornamen)
	{
		this.voornamen = voornamen;
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

	public String getMobiel()
	{
		return mobiel;
	}

	public void setMobiel(String mobiel)
	{
		this.mobiel = mobiel;
	}

	public String getEmailadres()
	{
		return emailadres;
	}

	public void setEmailadres(String emailadres)
	{
		this.emailadres = emailadres;
	}

	public Adres getCorrespondentieadres()
	{
		return correspondentieadres;
	}

	public void setCorrespondentieadres(Adres correspondentieadres)
	{
		this.correspondentieadres = correspondentieadres;
	}
}
