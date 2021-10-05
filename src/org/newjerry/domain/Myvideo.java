package org.newjerry.domain;

/**
 * Myvideo entity. @author MyEclipse Persistence Tools
 */

public class Myvideo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Myfolder myfolder;
	private String videoName;
	private String videoTrueUrl;
	private String videoPathUrl;
	private String imgTrueUrl;
	private String imgPathUrl;

	// Constructors

	/** default constructor */
	public Myvideo() {
	}

	/** full constructor */
	public Myvideo(Myfolder myfolder, String videoName, String videoTrueUrl,
			String videoPathUrl, String imgTrueUrl, String imgPathUrl) {
		this.myfolder = myfolder;
		this.videoName = videoName;
		this.videoTrueUrl = videoTrueUrl;
		this.videoPathUrl = videoPathUrl;
		this.imgTrueUrl = imgTrueUrl;
		this.imgPathUrl = imgPathUrl;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Myfolder getMyfolder() {
		return this.myfolder;
	}

	public void setMyfolder(Myfolder myfolder) {
		this.myfolder = myfolder;
	}

	public String getVideoName() {
		return this.videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoTrueUrl() {
		return this.videoTrueUrl;
	}

	public void setVideoTrueUrl(String videoTrueUrl) {
		this.videoTrueUrl = videoTrueUrl;
	}

	public String getVideoPathUrl() {
		return this.videoPathUrl;
	}

	public void setVideoPathUrl(String videoPathUrl) {
		this.videoPathUrl = videoPathUrl;
	}

	public String getImgTrueUrl() {
		return this.imgTrueUrl;
	}

	public void setImgTrueUrl(String imgTrueUrl) {
		this.imgTrueUrl = imgTrueUrl;
	}

	public String getImgPathUrl() {
		return this.imgPathUrl;
	}

	public void setImgPathUrl(String imgPathUrl) {
		this.imgPathUrl = imgPathUrl;
	}

}