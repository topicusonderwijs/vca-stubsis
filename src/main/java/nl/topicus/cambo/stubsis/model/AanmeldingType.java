package nl.topicus.cambo.stubsis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AanmeldingType
{
	@JsonProperty("A")
	AANMELDING,

	@JsonProperty("I")
	INTERESSEMELDING
}
