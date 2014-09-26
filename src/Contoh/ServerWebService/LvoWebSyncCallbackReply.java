package Contoh.ServerWebService;

import java.util.List;

public class LvoWebSyncCallbackReply {
	private String eventId;
	private String id;
	private String nama;
	private String level;
	private String jutsu;
	private String desa;
	private long timeout;

	public LvoWebSyncCallbackReply() {

	}

	public LvoWebSyncCallbackReply(String eventId, String id, String nama,
			String level, String jutsu, String desa, long timeout) {
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
