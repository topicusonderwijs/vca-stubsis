package nl.topicus.cambo.stubsis.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Vak extends Linkable
{
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(max = 100)
	private String naam;

	@NotNull
	@Size(max = 10)
	private String resultaat;

	public Vak()
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

	public String getResultaat()
	{
		return resultaat;
	}

	public void setResultaat(String resultaat)
	{
		this.resultaat = resultaat;
	}
}
