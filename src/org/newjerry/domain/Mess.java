package org.newjerry.domain;

/**
 * Mess entity. @author MyEclipse Persistence Tools
 */

public class Mess implements java.io.Serializable {

	// Fields

	private Integer id;
	private String urname;
	private Integer vid;
	private String mes;
	private String date;

	// Constructors

	/** default constructor */
	public Mess() {
	}

	/** minimal constructor */
	public Mess(String urname, Integer vid, String mes) {
		this.urname = urname;
		this.vid = vid;
		this.mes = mes;
	}

	/** full constructor */
	public Mess(String urname, Integer vid, String mes, String date) {
		this.urname = urname;
		this.vid = vid;
		this.mes = mes;
		this.date = date;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrname() {
		return this.urname;
	}

	public void setUrname(String urname) {
		this.urname = urname;
	}

	public Integer getVid() {
		return this.vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public String getMes() {
		return this.mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Mess [id=" + id + ", urname=" + urname + ", vid=" + vid
				+ ", mes=" + mes + ", date=" + date + "]";
	}
	
	
}