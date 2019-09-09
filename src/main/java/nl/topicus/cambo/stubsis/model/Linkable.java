package nl.topicus.cambo.stubsis.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE,
		isGetterVisibility = Visibility.NONE, creatorVisibility = Visibility.NONE,
		setterVisibility = Visibility.NONE)
@JsonInclude(Include.NON_NULL)
public abstract class Linkable implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String $type;

	public Linkable()
	{
	}

	public String get$type()
	{
		return $type;
	}

	public void set$type(String $type)
	{
		this.$type = $type;
	}
}
