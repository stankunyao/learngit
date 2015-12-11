package com.harmony.themis.persistence.domain;

// default package

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * ImMessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "HM_IM_MESSAGE")
public class ImMessage implements java.io.Serializable {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column(name = "LISTENID")
	private String listenid;

	@Column(name = "SEND_PERID")
	private String sendPerid;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "URL")
	private String url;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "CONTENT_TYPE")
	private String contentType;

	@Column(name = "SEND_TIME")
	private Date sendTime;

	//接收人
	@Transient
	private String receivePerid;	
	
	//发送人姓名
	@Transient
	private String sendName;

	// Constructors

	/** default constructor */
	public ImMessage() {
	}

	/** full constructor */
	public ImMessage(String listenid, String sendPerid, String content,
			String url, String type, String contentType, Date sendTime) {
		this.listenid = listenid;
		this.sendPerid = sendPerid;
		this.content = content;
		this.url = url;
		this.type = type;
		this.contentType = contentType;
		this.sendTime = sendTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSendPerid() {
		return this.sendPerid;
	}

	public void setSendPerid(String sendPerid) {
		this.sendPerid = sendPerid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getListenid() {
		return listenid;
	}

	public void setListenid(String listenid) {
		this.listenid = listenid;
	}

	public String getReceivePerid() {
		return receivePerid;
	}

	public void setReceivePerid(String receivePerid) {
		this.receivePerid = receivePerid;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

}