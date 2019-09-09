package nl.topicus.cambo.stubsis.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Aanmeldingen implements Serializable
{
	private static final long serialVersionUID = 1L;

	private List<Aanmelding> items = new ArrayList<>();

	public Aanmeldingen()
	{
	}

	public List<Aanmelding> getItems()
	{
		return items;
	}

	public void setItems(List<Aanmelding> items)
	{
		this.items = items;
	}
}
