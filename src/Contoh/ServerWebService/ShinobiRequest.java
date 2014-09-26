package Contoh.ServerWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ShinobiRequest {
	@XmlElement(name = "EVENTID")
	private String eventId;
	@XmlElement(name = "ID")
	private String id;
	@XmlElement(name = "NAMA")
	private String nama;
	@XmlElement(name = "LEVEL")
	private String level;
	@XmlElement(name = "JUTSU")
	private String jutsu;
	@XmlElement(name = "DESA")
	private String desa;
	@XmlElement(name = "TIMEOUT")
	private long timeout;

	public ShinobiRequest() {

	}

	public ShinobiRequest(String eventId, String id, String nama, String level,
			String jutsu, String desa, long timeout) {
		this.eventId = eventId;
		this.id = id;
		this.nama = nama;
		this.level = level;
		this.jutsu = jutsu;
		this.desa = desa;
		this.timeout = timeout;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getJutsu() {
		return jutsu;
	}

	public void setJutsu(String jutsu) {
		this.jutsu = jutsu;
	}

	public String getDesa() {
		return desa;
	}

	public void setDesa(String desa) {
		this.desa = desa;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

}
