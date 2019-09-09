package nl.topicus.cambo.stubsis.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Leerbedrijf extends Linkable
{
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(max = 200)
	private String naam;

	@Size(max = 20)
	private String leerbedrijfId;

	private Adres adres;

	private Contactpersoon contactpersoonErkenning;

	private Contactpersoon tweedeContactpersoon;

	@Size(max = 100)
	private String erkenning;

	public Leerbedrijf()
	{
	}

	public String getNaam()
	{
		return naam;
	}

	public void setNaam(String naam)
	{
		this.naam = naam;
	}

	public String getLeerbedrijfId()
	{
		return leerbedrijfId;
	}

	public void setLeerbedrijfId(String leerbedrijfId)
	{
		this.leerbedrijfId = leerbedrijfId;
	}

	public Adres getAdres()
	{
		return adres;
	}

	public void setAdres(Adres adres)
	{
		this.adres = adres;
	}

	public Contactpersoon getContactpersoonErkenning()
	{
		return contactpersoonErkenning;
	}

	public void setContactpersoonErkenning(Contactpersoon contactpersoonErkenning)
	{
		this.contactpersoonErkenning = contactpersoonErkenning;
	}

	public Contactpersoon getTweedeContactpersoon()
	{
		return tweedeContactpersoon;
	}

	public void setTweedeContactpersoon(Contactpersoon tweedeContactpersoon)
	{
		this.tweedeContactpersoon = tweedeContactpersoon;
	}

	public String getErkenning()
	{
		return erkenning;
	}

	public void setErkenning(String erkenning)
	{
		this.erkenning = erkenning;
	}
}
