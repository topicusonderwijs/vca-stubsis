package nl.topicus.cambo.stubsis.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class Vooropleiding extends Linkable
{
	private static final long serialVersionUID = 1L;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate vanaf;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate totEnMet;

	@NotNull
	@Size(max = 100)
	private String instelling;

	@NotNull
	@Size(max = 200)
	private String opleiding;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate datumUitslag;

	private boolean diplomaBehaald;

	@Size(max = 100)
	private String eindresultaat;

	private List<Vak> vakken = new ArrayList<>();

	public Vooropleiding()
	{
	}

	public LocalDate getVanaf()
	{
		return vanaf;
	}

	public void setVanaf(LocalDate vanaf)
	{
		this.vanaf = vanaf;
	}

	public LocalDate getTotEnMet()
	{
		return totEnMet;
	}

	public void setTotEnMet(LocalDate totEnMet)
	{
		this.totEnMet = totEnMet;
	}

	public String getInstelling()
	{
		return instelling;
	}

	public void setInstelling(String instelling)
	{
		this.instelling = instelling;
	}

	public String getOpleiding()
	{
		return opleiding;
	}

	public void setOpleiding(String opleiding)
	{
		this.opleiding = opleiding;
	}

	public LocalDate getDatumUitslag()
	{
		return datumUitslag;
	}

	public void setDatumUitslag(LocalDate datumUitslag)
	{
		this.datumUitslag = datumUitslag;
	}

	public boolean isDiplomaBehaald()
	{
		return diplomaBehaald;
	}

	public void setDiplomaBehaald(boolean diplomaBehaald)
	{
		this.diplomaBehaald = diplomaBehaald;
	}

	public String getEindresultaat()
	{
		return eindresultaat;
	}

	public void setEindresultaat(String eindresultaat)
	{
		this.eindresultaat = eindresultaat;
	}

	public List<Vak> getVakken()
	{
		return vakken;
	}

	public void setVakken(List<Vak> vakken)
	{
		this.vakken = vakken;
	}
}
