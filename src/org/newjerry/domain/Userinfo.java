package org.newjerry.domain;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String uname;
	private String upsw;
	private String urname;
	private String uemail;
	private Integer rank;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** full constructor */
	public Userinfo(String uname, String upsw, String urname, String uemail,
			Integer rank) {
		this.uname = uname;
		this.upsw = upsw;
		this.urname = urname;
		this.uemail = uemail;
		this.rank = rank;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpsw() {
		return this.upsw;
	}

	public void setUpsw(String upsw) {
		this.upsw = upsw;
	}

	public String getUrname() {
		return this.urname;
	}

	public void setUrname(String urname) {
		this.urname = urname;
	}

	public String getUemail() {
		return this.uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

}