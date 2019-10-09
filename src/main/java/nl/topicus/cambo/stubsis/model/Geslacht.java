package nl.topicus.cambo.stubsis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Geslacht
{
	@JsonProperty("V")
	VROUW,

	@JsonProperty("M")
	MAN,

	@JsonProperty("-")
	VASTGESTELD_ONBEKEND
}
