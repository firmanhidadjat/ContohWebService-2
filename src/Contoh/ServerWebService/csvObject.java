package Contoh.ServerWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "nama", "level", "jutsu", "desa", "columnCount" })
@XmlRootElement(name = "csvObject")
public class csvObject {
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
	@XmlElement(name = "COLUMNCOUNT")
	private int columnCount;

	public csvObject() {

	}

	public csvObject(String id2, String nama2, String level2, String jutsu2,
			String desa2, int columnCount) {
		this.id = id2;
		this.nama = nama2;
		this.level = level2;
		this.jutsu = jutsu2;
		this.desa = desa2;
		this.columnCount = columnCount;
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

	public int getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

}
