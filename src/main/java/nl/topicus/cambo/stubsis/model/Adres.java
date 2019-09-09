package nl.topicus.cambo.stubsis.model;

import javax.validation.constraints.Size;

public class Adres extends Linkable
{
	private static final long serialVersionUID = 1L;

	@Size(max = 200)
	private String straat;

	@Size(max = 10)
	private String huisnummer;

	@Size(max = 10)
	private String huisnummerToevoeging;

	@Size(max = 100)
	private String huisnummerToelichting;

	@Size(max = 6)
	private String postcode;

	@Size(max = 200)
	private String plaats;

	@Size(max = 4)
	private String land;

	@Size(max = 200)
	private String regel1;

	@Size(max = 200)
	private String regel2;

	@Size(max = 200)
	private String regel3;

	public Adres()
	{
	}

	public String getStraat()
	{
		return straat;
	}

	public void setStraat(String straat)
	{
		this.straat = straat;
	}

	public String getHuisnummer()
	{
		return huisnummer;
	}

	public void setHuisnummer(String huisnummer)
	{
		this.huisnummer = huisnummer;
	}

	public String getHuisnummerToevoeging()
	{
		return huisnummerToevoeging;
	}

	public void setHuisnummerToevoeging(String huisnummerToevoeging)
	{
		this.huisnummerToevoeging = huisnummerToevoeging;
	}

	public String getHuisnummerToelichting()
	{
		return huisnummerToelichting;
	}

	public void setHuisnummerToelichting(String huisnummerToelichting)
	{
		this.huisnummerToelichting = huisnummerToelichting;
	}

	public String getPostcode()
	{
		return postcode;
	}

	public void setPostcode(String postcode)
	{
		this.postcode = postcode;
	}

	public String getPlaats()
	{
		return plaats;
	}

	public void setPlaats(String plaats)
	{
		this.plaats = plaats;
	}

	public String getLand()
	{
		return land;
	}

	public void setLand(String land)
	{
		this.land = land;
	}

	public String getRegel1()
	{
		return regel1;
	}

	public void setRegel1(String regel1)
	{
		this.regel1 = regel1;
	}

	public String getRegel2()
	{
		return regel2;
	}

	public void setRegel2(String regel2)
	{
		this.regel2 = regel2;
	}

	public String getRegel3()
	{
		return regel3;
	}

	public void setRegel3(String regel3)
	{
		this.regel3 = regel3;
	}
}
