package org.newjerry.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Myfolder entity. @author MyEclipse Persistence Tools
 */

public class Myfolder implements java.io.Serializable {

	// Fields

	private Integer id;
	private String folderName;
	private String folderTrueUrl;
	private String folderPathUrl;
	private String imgFolderTrueUrl;
	private String imgFolderPathUrl;
	private String xmlTrueUrl;
	private Integer rank;
	private Set<Myvideo> myvideos = new HashSet<Myvideo>(0);

	// Constructors

	/** default constructor */
	public Myfolder() {
	}

	/** minimal constructor */
	public Myfolder(String folderName, Integer rank) {
		this.folderName = folderName;
		this.rank = rank;
	}

	/** full constructor */
	public Myfolder(String folderName, String folderTrueUrl,
			String folderPathUrl, String imgFolderTrueUrl,
			String imgFolderPathUrl, String xmlTrueUrl, Integer rank,
			Set<Myvideo> myvideos) {
		this.folderName = folderName;
		this.folderTrueUrl = folderTrueUrl;
		this.folderPathUrl = folderPathUrl;
		this.imgFolderTrueUrl = imgFolderTrueUrl;
		this.imgFolderPathUrl = imgFolderPathUrl;
		this.xmlTrueUrl = xmlTrueUrl;
		this.rank = rank;
		this.myvideos = myvideos;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFolderName() {
		return this.folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getFolderTrueUrl() {
		return this.folderTrueUrl;
	}

	public void setFolderTrueUrl(String folderTrueUrl) {
		this.folderTrueUrl = folderTrueUrl;
	}

	public String getFolderPathUrl() {
		return this.folderPathUrl;
	}

	public void setFolderPathUrl(String folderPathUrl) {
		this.folderPathUrl = folderPathUrl;
	}

	public String getImgFolderTrueUrl() {
		return this.imgFolderTrueUrl;
	}

	public void setImgFolderTrueUrl(String imgFolderTrueUrl) {
		this.imgFolderTrueUrl = imgFolderTrueUrl;
	}

	public String getImgFolderPathUrl() {
		return this.imgFolderPathUrl;
	}

	public void setImgFolderPathUrl(String imgFolderPathUrl) {
		this.imgFolderPathUrl = imgFolderPathUrl;
	}

	public String getXmlTrueUrl() {
		return this.xmlTrueUrl;
	}

	public void setXmlTrueUrl(String xmlTrueUrl) {
		this.xmlTrueUrl = xmlTrueUrl;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Set<Myvideo> getMyvideos() {
		return this.myvideos;
	}

	public void setMyvideos(Set<Myvideo> myvideos) {
		this.myvideos = myvideos;
	}

}