package nl.topicus.cambo.stubsis.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class Aanmelding extends Linkable
{
	private static final long serialVersionUID = 1L;

	@Size(min = 13, max = 15)
	@Pattern(regexp = "[0-9]{2}[A-Z]{2}([0-9]{2})?:[0-9]{8}")
	private String ketenId;

	@Min(value = 0)
	private long wijzigingsvolgnummer;

	@NotNull
	private AanmeldingType type;

	private boolean ingetrokken;

	@Size(min = 9, max = 9)
	private String bsn;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate geboortedatum;

	private Geslacht geslacht;

	@Size(max = 75)
	private String roepnaam;

	@Size(max = 200)
	private String achternaam;

	@Size(max = 20)
	private String voorvoegsels;

	@Size(max = 200)
	private String voornamen;

	private List<Vooropleiding> vooropleidingen = new ArrayList<>();

	private Adres correspondentieadres;

	@Size(max = 20)
	private String telefoonnummerMobiel;

	@Size(max = 100)
	private String emailAdres;

	private List<WettelijkVertegenwoordiger> wettelijkVertegenwoordigers;

	@NotNull
	@Size(min = 4, max = 4)
	private String instelling;

	@NotNull
	@Size(max = 36)
	private String opleiding;

	@NotNull
	@Size(max = 100)
	private String opleidingCohort;

	private Leerbedrijf leerbedrijf;

	private boolean aanmeldingVoorEersteLeerjaar;

	public Aanmelding()
	{
	}

	public String getKetenId()
	{
		return ketenId;
	}

	public void setKetenId(String ketenId)
	{
		this.ketenId = ketenId;
	}

	public long getWijzigingsvolgnummer()
	{
		return wijzigingsvolgnummer;
	}

	public void setWijzigingsvolgnummer(long wijzigingsvolgnummer)
	{
		this.wijzigingsvolgnummer = wijzigingsvolgnummer;
	}

	public AanmeldingType getType()
	{
		return type;
	}

	public void setType(AanmeldingType type)
	{
		this.type = type;
	}

	public boolean isIngetrokken()
	{
		return ingetrokken;
	}

	public void setIngetrokken(boolean ingetrokken)
	{
		this.ingetrokken = ingetrokken;
	}

	public String getBsn()
	{
		return bsn;
	}

	public void setBsn(String bsn)
	{
		this.bsn = bsn;
	}

	public LocalDate getGeboortedatum()
	{
		return geboortedatum;
	}

	public void setGeboortedatum(LocalDate geboortedatum)
	{
		this.geboortedatum = geboortedatum;
	}

	public Geslacht getGeslacht()
	{
		return geslacht;
	}

	public void setGeslacht(Geslacht geslacht)
	{
		this.geslacht = geslacht;
	}

	public String getRoepnaam()
	{
		return roepnaam;
	}

	public void setRoepnaam(String roepnaam)
	{
		this.roepnaam = roepnaam;
	}

	public String getAchternaam()
	{
		return achternaam;
	}

	public void setAchternaam(String achternaam)
	{
		this.achternaam = achternaam;
	}

	public String getVoorvoegsels()
	{
		return voorvoegsels;
	}

	public void setVoorvoegsels(String voorvoegsels)
	{
		this.voorvoegsels = voorvoegsels;
	}

	public String getVoornamen()
	{
		return voornamen;
	}

	public void setVoornamen(String voornamen)
	{
		this.voornamen = voornamen;
	}

	public List<Vooropleiding> getVooropleidingen()
	{
		return vooropleidingen;
	}

	public void setVooropleidingen(List<Vooropleiding> vooropleidingen)
	{
		this.vooropleidingen = vooropleidingen;
	}

	public Adres getCorrespondentieadres()
	{
		return correspondentieadres;
	}

	public void setCorrespondentieadres(Adres correspondentieadres)
	{
		this.correspondentieadres = correspondentieadres;
	}

	public String getTelefoonnummerMobiel()
	{
		return telefoonnummerMobiel;
	}

	public void setTelefoonnummerMobiel(String telefoonnummerMobiel)
	{
		this.telefoonnummerMobiel = telefoonnummerMobiel;
	}

	public String getEmailAdres()
	{
		return emailAdres;
	}

	public void setEmailAdres(String emailAdres)
	{
		this.emailAdres = emailAdres;
	}

	public List<WettelijkVertegenwoordiger> getWettelijkVertegenwoordigers()
	{
		return wettelijkVertegenwoordigers;
	}

	public void setWettelijkVertegenwoordigers(
			List<WettelijkVertegenwoordiger> wettelijkVertegenwoordigers)
	{
		this.wettelijkVertegenwoordigers = wettelijkVertegenwoordigers;
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

	public String getOpleidingCohort()
	{
		return opleidingCohort;
	}

	public void setOpleidingCohort(String opleidingCohort)
	{
		this.opleidingCohort = opleidingCohort;
	}

	public Leerbedrijf getLeerbedrijf()
	{
		return leerbedrijf;
	}

	public void setLeerbedrijf(Leerbedrijf leerbedrijf)
	{
		this.leerbedrijf = leerbedrijf;
	}

	public boolean isAanmeldingVoorEersteLeerjaar()
	{
		return aanmeldingVoorEersteLeerjaar;
	}

	public void setAanmeldingVoorEersteLeerjaar(boolean aanmeldingVoorEersteLeerjaar)
	{
		this.aanmeldingVoorEersteLeerjaar = aanmeldingVoorEersteLeerjaar;
	}
}
